package zkamper.romaniansdelight.registry;

import com.mojang.datafixers.types.Type;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import zkamper.romaniansdelight.RomaniansDelight;
import zkamper.romaniansdelight.common.block.entity.GrillBlockEntity;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, RomaniansDelight.MOD_ID);

    public static final RegistryObject<BlockEntityType<GrillBlockEntity>> GRILL;

    static {
        GRILL = BLOCK_ENTITIES.register("grill",
                () -> BlockEntityType.Builder.of(GrillBlockEntity::new, new Block[]{(Block) ModBlocks.GRILL_BLOCK.get()}).build((Type) null));
    }

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
