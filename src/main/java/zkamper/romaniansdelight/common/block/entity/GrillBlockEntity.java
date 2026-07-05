package zkamper.romaniansdelight.common.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Clearable;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.Containers;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CampfireCookingRecipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import vectorwing.farmersdelight.common.registry.ModSounds;
import zkamper.romaniansdelight.common.block.GrillBlock;
import zkamper.romaniansdelight.registry.ModBlockEntities;

import javax.annotation.Nullable;
import java.util.Objects;
import java.util.Optional;

public class GrillBlockEntity extends BlockEntity implements Clearable {
    private final NonNullList<ItemStack> items;
    private final int[] cookingProgress;
    private final int[] cookingTime;
    private final RecipeManager.CachedCheck<SingleRecipeInput, CampfireCookingRecipe> quickCheck;

    public GrillBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.GRILL.get(), blockPos, blockState);
        this.items = NonNullList.withSize(4, ItemStack.EMPTY);
        this.cookingProgress = new int[4];
        this.cookingTime = new int[4];
        this.quickCheck = RecipeManager.createCheck(RecipeType.CAMPFIRE_COOKING);
    }

    public static void cookTick(Level level, BlockPos blockPos, BlockState blockState, GrillBlockEntity grillBlockEntity) {
        boolean ok = false;
        RandomSource randomSource = level.random;
        for (int idx = 0; idx < grillBlockEntity.items.size(); ++idx) {
            ItemStack itemStack = grillBlockEntity.items.get(idx);
            if (!itemStack.isEmpty()) {
                ok = true;
                grillBlockEntity.cookingProgress[idx]++;
                if (level.isRainingAt(blockPos) && level.canSeeSky(blockPos) && randomSource.nextFloat() < 0.5F) {
                    grillBlockEntity.cookingProgress[idx]--;
                }
                if (grillBlockEntity.cookingProgress[idx] >= grillBlockEntity.cookingTime[idx]) {
                    SingleRecipeInput input = new SingleRecipeInput(itemStack);
                    ItemStack result = grillBlockEntity.quickCheck
                            .getRecipeFor(input, level)
                            .map(holder -> holder.value().assemble(input, level.registryAccess()))
                            .orElse(itemStack);
                    Containers.dropItemStack(level, blockPos.getX(), blockPos.getY(), blockPos.getZ(), result);
                    grillBlockEntity.items.set(idx, ItemStack.EMPTY);
                    level.sendBlockUpdated(blockPos, blockState, blockState, 3);
                    level.gameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Context.of(blockState));
                }
            }
        }
        if (ok) {
            setChanged(level, blockPos, blockState);
        }
    }

    public static void particleTick(Level level, BlockPos blockPos, BlockState blockState, GrillBlockEntity grillBlockEntity) {
        RandomSource randomSource = level.random;
        int direction;
        if (randomSource.nextFloat() < 0.11F) {
            for (direction = 0; direction < randomSource.nextInt(2) + 2; ++direction) {
                GrillBlock.makeParticles(level, blockPos, false);
            }
        }

        direction = blockState.getValue(GrillBlock.FACING).get2DDataValue();

        for (int itemIndex = 0; itemIndex < grillBlockEntity.items.size(); ++itemIndex) {
            float rand = randomSource.nextFloat();
            if (!grillBlockEntity.items.get(itemIndex).isEmpty() && rand < 0.2F) {
                Direction direction1 = Direction.from2DDataValue(Math.floorMod(itemIndex + direction, 4));
                double xPos = (double) blockPos.getX() + 0.5 - (double) ((float) direction1.getStepX() * 0.3125F) + (double) ((float) direction1.getClockWise().getStepX() * 0.3125F);
                double yPos = (double) blockPos.getY() + 1.1;
                double zPos = (double) blockPos.getZ() + 0.5 - (double) ((float) direction1.getStepZ() * 0.3125F) + (double) ((float) direction1.getClockWise().getStepZ() * 0.3125F);
                if (rand < 0.005F && itemIndex == 0) {
                    level.playLocalSound(blockPos.getX(), blockPos.getY(), blockPos.getZ(), (SoundEvent) ModSounds.BLOCK_SKILLET_SIZZLE.get(), SoundSource.BLOCKS, 0.4F, randomSource.nextFloat() * 0.2F + 0.5F, false);
                }
                for (int idx = 0; idx < 4; ++idx) {
                    level.addParticle(ParticleTypes.SMOKE, xPos, yPos, zPos, 0.0, 5.0E-4, 0.0);
                }
            }
        }
    }

    public NonNullList<ItemStack> getItems() {
        return this.items;
    }

    @Override
    protected void loadAdditional(CompoundTag compoundTag, HolderLookup.Provider registries) {
        super.loadAdditional(compoundTag, registries);
        this.items.clear();
        ContainerHelper.loadAllItems(compoundTag, this.items, registries);
        int[] cookingTimesArr;
        if (compoundTag.contains("CookingTimes", 11)) {
            cookingTimesArr = compoundTag.getIntArray("CookingTimes");
            System.arraycopy(cookingTimesArr, 0, this.cookingProgress, 0, Math.min(this.cookingTime.length, cookingTimesArr.length));
        }
        if (compoundTag.contains("CookingTotalTimes", 11)) {
            cookingTimesArr = compoundTag.getIntArray("CookingTotalTimes");
            System.arraycopy(cookingTimesArr, 0, this.cookingTime, 0, Math.min(this.cookingTime.length, cookingTimesArr.length));
        }
    }

    @Override
    protected void saveAdditional(CompoundTag compoundTag, HolderLookup.Provider registries) {
        super.saveAdditional(compoundTag, registries);
        ContainerHelper.saveAllItems(compoundTag, this.items, true, registries);
        compoundTag.putIntArray("CookingTimes", this.cookingProgress);
        compoundTag.putIntArray("CookingTotalTimes", this.cookingTime);
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        CompoundTag compoundTag = new CompoundTag();
        ContainerHelper.saveAllItems(compoundTag, this.items, true, registries);
        return compoundTag;
    }

    public Optional<RecipeHolder<CampfireCookingRecipe>> getCookableRecipe(ItemStack itemStack) {
        if (this.items.stream().noneMatch(ItemStack::isEmpty)) {
            return Optional.empty();
        }
        assert this.level != null;
        return this.quickCheck.getRecipeFor(new SingleRecipeInput(itemStack), this.level);
    }

    public boolean placeFood(@Nullable Entity entity, ItemStack itemStack, int cookingTime) {
        for (int itemIndex = 0; itemIndex < this.items.size(); ++itemIndex) {
            ItemStack current = this.items.get(itemIndex);
            if (current.isEmpty()) {
                this.cookingTime[itemIndex] = cookingTime;
                this.cookingProgress[itemIndex] = 0;
                this.items.set(itemIndex, itemStack.split(1));
                this.level.gameEvent(GameEvent.BLOCK_CHANGE, this.getBlockPos(), GameEvent.Context.of(entity, this.getBlockState()));
                this.markUpdated();
                return true;
            }
        }
        return false;
    }

    private void markUpdated() {
        this.setChanged();
        Objects.requireNonNull(this.getLevel()).sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
    }

    @Override
    public void clearContent() {
        this.items.clear();
    }
}
