package zkamper.romaniansdelight.registry;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.item.DrinkableItem;
import zkamper.romaniansdelight.RomaniansDelight;
import zkamper.romaniansdelight.common.item.*;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, RomaniansDelight.MOD_ID);
    public static final RegistryObject<Item> RADAUTI_CIORBA;
    public static final RegistryObject<Item> STOMACH_CIORBA;
    public static final RegistryObject<Item> MAYONNAISE;
    public static final RegistryObject<Item> SALAD_BOEUF;
    public static final RegistryObject<Item> RAW_MICI;
    public static final RegistryObject<Item> COOKED_MICI;
    public static final RegistryObject<Item> CORN_FLOUR;
    public static final RegistryObject<Item> MAMALIGA;
    public static final RegistryObject<Item> SARMALE;
    public static final RegistryObject<Item> BOILED_CORN;
    public static final RegistryObject<Item> BOILED_EGG;
    public static final RegistryObject<Item> GARLIC;

    static {
        RADAUTI_CIORBA = ITEMS.register("radauti_soup", () -> new ConsumableItem(new Item.Properties()
                .tab(ModCreativeTab.MOD_TAB)
                .food(FoodValues.RADAUTI_SOUP)
                .stacksTo(16)
                .craftRemainder(Items.BOWL),true));
        STOMACH_CIORBA = ITEMS.register("tripe_soup", () -> new ConsumableItem(new Item.Properties()
                .tab(ModCreativeTab.MOD_TAB)
                .food(FoodValues.TRIPE_SOUP)
                .stacksTo(16)
                .craftRemainder(Items.BOWL),true));
        SALAD_BOEUF = ITEMS.register("salad_boeuf", () -> new ConsumableItem(new Item.Properties()
                .tab(ModCreativeTab.MOD_TAB)
                .food(FoodValues.SALAD_BOEUF)
                .stacksTo(16)
                .craftRemainder(Items.BOWL),true));
        MAYONNAISE = ITEMS.register("mayonnaise", () -> new DrinkableItem(new Item.Properties()
                .tab(ModCreativeTab.MOD_TAB)
                .food(FoodValues.MAYONNAISE)
                .stacksTo(16)));
        SARMALE = ITEMS.register("sarmale", () -> new ConsumableItem(new Item.Properties()
                .tab(ModCreativeTab.MOD_TAB)
                .food(FoodValues.SARMALE)
                .stacksTo(64),true));
        RAW_MICI = ITEMS.register("raw_mici", () -> new Item(new Item.Properties()
                .food(FoodValues.RAW_MICI)
                .tab(ModCreativeTab.MOD_TAB)));
        COOKED_MICI = ITEMS.register("cooked_mici", () -> new Item(new Item.Properties()
                .food(FoodValues.COOKED_MICI)
                .tab(ModCreativeTab.MOD_TAB)));
        CORN_FLOUR = ITEMS.register("corn_flour", () -> new Item(new Item.Properties()
                .tab(ModCreativeTab.MOD_TAB)));
        MAMALIGA = ITEMS.register("mamaliga", () -> new Item(new Item.Properties()
                .food(FoodValues.MAMALIGA)
                .tab(ModCreativeTab.MOD_TAB)));
        BOILED_CORN = ITEMS.register("boiled_corn", () -> new Item(new Item.Properties()
                .food(FoodValues.BOILED_CORN)
                .tab(ModCreativeTab.MOD_TAB)));
        BOILED_EGG = ITEMS.register("boiled_egg", () -> new Item(new Item.Properties()
                .food(FoodValues.BOILED_EGG)
                .tab(ModCreativeTab.MOD_TAB)));

        // Special items
        GARLIC = ITEMS.register(GarlicItem.NAME, GarlicItem::new);
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
