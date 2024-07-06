package zkamper.romaniansdelight.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.crafting.CampfireCookingRecipe;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import vectorwing.farmersdelight.common.block.SkilletBlock;
import vectorwing.farmersdelight.common.block.entity.SkilletBlockEntity;
import vectorwing.farmersdelight.common.registry.ModParticleTypes;
import vectorwing.farmersdelight.common.registry.ModSounds;
import zkamper.romaniansdelight.common.ModBlockEntities;
import zkamper.romaniansdelight.common.block.entity.GrillBlockEntity;


import javax.annotation.Nullable;
import java.util.Optional;
import java.util.stream.Stream;

public class  GrillBlock extends BaseEntityBlock {
    public static final String NAME = "grill";
    public static final DirectionProperty FACING;
    public static final VoxelShape SHAPE;

    public static final Properties PROPERTIES = BlockBehaviour.Properties
            .of(Material.METAL)
            .strength(0.5F, 6.0F)
            .sound(SoundType.LANTERN)
            .lightLevel((state) -> 5)
            .noOcclusion();

    public GrillBlock() {
        super(PROPERTIES);
        this.registerDefaultState(((BlockState)this.stateDefinition.any()).setValue(FACING, Direction.NORTH));
    }

    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult hitResult) {
        BlockEntity blockentity = level.getBlockEntity(blockPos);
        if (blockentity instanceof GrillBlockEntity grillBlockEntity) {
            ItemStack itemstack = player.getItemInHand(interactionHand);
            Optional<CampfireCookingRecipe> optional = grillBlockEntity.getCookableRecipe(itemstack);
            if (optional.isPresent()) {
                if (!level.isClientSide && grillBlockEntity.placeFood(player, player.getAbilities().instabuild ? itemstack.copy() : itemstack, optional.get().getCookingTime())) {
                    player.awardStat(Stats.INTERACT_WITH_CAMPFIRE);
                    return InteractionResult.SUCCESS;
                }

                return InteractionResult.CONSUME;
            }
        }

        return InteractionResult.PASS;
    }

    public VoxelShape getShape(BlockState p_51309_, BlockGetter p_51310_, BlockPos p_51311_, CollisionContext p_51312_) {
        return SHAPE;
    }

    public RenderShape getRenderShape(BlockState blockState) {
        return RenderShape.MODEL;
    }

    public void onRemove(BlockState blockState, Level level, BlockPos blockPos, BlockState blockStateNew, boolean p_51285_) {
        if (!blockState.is(blockStateNew.getBlock())) {
            BlockEntity blockentity = level.getBlockEntity(blockPos);
            if (blockentity instanceof GrillBlockEntity) {
                Containers.dropContents(level, blockPos, ((GrillBlockEntity)blockentity).getItems());
            }

            super.onRemove(blockState, level, blockPos, blockStateNew, p_51285_);
        }

    }
    public static void makeParticles(Level level, BlockPos blockPos, boolean cooking) {
        RandomSource randSource = level.getRandom();
        SimpleParticleType particleType = ModParticleTypes.STEAM.get();
        level.addAlwaysVisibleParticle(particleType, true, (double)blockPos.getX() + 0.5 + randSource.nextDouble() / 3.0 * (double)(randSource.nextBoolean() ? 1 : -1), (double)blockPos.getY() + 1.1 + randSource.nextDouble() + randSource.nextDouble(), (double)blockPos.getZ() + 0.5 + randSource.nextDouble() / 3.0 * (double)(randSource.nextBoolean() ? 1 : -1), 0.0, 0.07, 0.0);
        if (cooking) {
            level.addParticle(ParticleTypes.SMOKE, (double)blockPos.getX() + 0.5 + randSource.nextDouble() / 4.0 * (double)(randSource.nextBoolean() ? 1 : -1), (double)blockPos.getY() + 0.4, (double)blockPos.getZ() + 0.5 + randSource.nextDouble() / 4.0 * (double)(randSource.nextBoolean() ? 1 : -1), 0.0, 0.005, 0.0);
        }
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return this.defaultBlockState().setValue(FACING, ctx.getHorizontalDirection().getOpposite());
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_153212_, BlockState blockState, BlockEntityType<T> blockEntityType) {
        if (p_153212_.isClientSide) {
            return createTickerHelper(blockEntityType, ModBlockEntities.GRILL.get(), GrillBlockEntity::particleTick);
        } else {
            return createTickerHelper(blockEntityType, ModBlockEntities.GRILL.get(), GrillBlockEntity::cookTick);
        }
    }

    public BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }

    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new GrillBlockEntity(blockPos, blockState);
    }

    static {
        SHAPE = Stream.of(
                Block.box(0, 0, 0, 1, 16, 1),
                Block.box(0, 0, 15, 1, 16, 16),
                Block.box(15, 0, 15, 16, 16, 16),
                Block.box(15, 0, 0, 16, 16, 1),
                Block.box(0, 15, 0, 16, 17, 16)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
        FACING = BlockStateProperties.HORIZONTAL_FACING;
    }
}
