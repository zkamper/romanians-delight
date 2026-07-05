package zkamper.romaniansdelight.registry;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import zkamper.romaniansdelight.RomaniansDelight;
import zkamper.romaniansdelight.common.block.GarlicCrateBlock;
import zkamper.romaniansdelight.common.block.GarlicCropBlock;
import zkamper.romaniansdelight.common.block.GrillBlock;
import zkamper.romaniansdelight.common.block.MamaligaBlock;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(RomaniansDelight.MOD_ID);

    public static final DeferredBlock<Block> GRILL_BLOCK;
    public static final DeferredBlock<Block> MAMALIGA_BLOCK;
    public static final DeferredItem<Item> MAMALIGA_ITEM;
    public static final DeferredBlock<Block> GARLIC_CROP;
    public static final DeferredBlock<Block> GARLIC_CRATE;

    static {
        GRILL_BLOCK = registerBlock(GrillBlock.NAME, GrillBlock::new);
        MAMALIGA_BLOCK = BLOCKS.register(MamaligaBlock.NAME, MamaligaBlock::new);
        MAMALIGA_ITEM = ModItems.ITEMS.register(MamaligaBlock.NAME,
                () -> new BlockItem(MAMALIGA_BLOCK.get(), new Item.Properties().stacksTo(1)));
        GARLIC_CROP = BLOCKS.register(GarlicCropBlock.NAME, GarlicCropBlock::new);
        GARLIC_CRATE = registerBlock(GarlicCrateBlock.NAME, GarlicCrateBlock::new);
    }

    public static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    public static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
