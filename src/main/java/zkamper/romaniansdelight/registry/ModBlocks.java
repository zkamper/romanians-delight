package zkamper.romaniansdelight.registry;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import zkamper.romaniansdelight.RomaniansDelight;
import zkamper.romaniansdelight.common.block.GarlicCrateBlock;
import zkamper.romaniansdelight.common.block.GarlicCropBlock;
import zkamper.romaniansdelight.common.block.GrillBlock;
import zkamper.romaniansdelight.common.block.MamaligaBlock;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
        DeferredRegister.create(ForgeRegistries.BLOCKS, RomaniansDelight.MOD_ID);

    public static final RegistryObject<Block> GRILL_BLOCK;
    public static final RegistryObject<Block> MAMALIGA_BLOCK;
    public static final RegistryObject<Item> MAMALIGA_ITEM;
    public static final RegistryObject<Block> GARLIC_CROP;

    public static final RegistryObject<Block> GARLIC_CRATE;

    static {
        GRILL_BLOCK = registerBlock(GrillBlock.NAME,GrillBlock::new);
        MAMALIGA_BLOCK = BLOCKS.register(MamaligaBlock.NAME, MamaligaBlock::new);
        MAMALIGA_ITEM = ModItems.ITEMS.register(MamaligaBlock.NAME,() ->
                new BlockItem(MAMALIGA_BLOCK.get(), new Item.Properties().tab(ModCreativeTab.MOD_TAB).stacksTo(1)));
        GARLIC_CROP = BLOCKS.register(GarlicCropBlock.NAME, GarlicCropBlock::new);
        GARLIC_CRATE = registerBlock(GarlicCrateBlock.NAME, GarlicCrateBlock::new);
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
