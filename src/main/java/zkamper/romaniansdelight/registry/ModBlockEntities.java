package zkamper.romaniansdelight.registry;

import com.mojang.datafixers.types.Type;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import zkamper.romaniansdelight.RomaniansDelight;
import zkamper.romaniansdelight.common.block.entity.GrillBlockEntity;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, RomaniansDelight.MOD_ID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<GrillBlockEntity>> GRILL;

    static {
        GRILL = BLOCK_ENTITIES.register("grill",
                () -> BlockEntityType.Builder.of(GrillBlockEntity::new, ModBlocks.GRILL_BLOCK.get()).build((Type<?>) null));
    }

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
