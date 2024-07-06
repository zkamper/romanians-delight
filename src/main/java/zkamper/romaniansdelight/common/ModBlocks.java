package zkamper.romaniansdelight.common;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import zkamper.romaniansdelight.RomaniansDelight;
import zkamper.romaniansdelight.common.block.GrillBlock;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
        DeferredRegister.create(ForgeRegistries.BLOCKS, RomaniansDelight.MOD_ID);

    public static final RegistryObject<Block> GRILL_BLOCK;

    static {
        GRILL_BLOCK = registerBlock(GrillBlock.NAME,GrillBlock::new);
    }

    public static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    public static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(
                name,
                () -> new BlockItem(block.get(), new Item.Properties().tab(ModCreativeTab.MOD_TAB))
        );
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
