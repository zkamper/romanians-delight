package zkamper.romaniansdelight.registry;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.item.DrinkableItem;
import zkamper.romaniansdelight.RomaniansDelight;
import zkamper.romaniansdelight.common.item.*;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(RomaniansDelight.MOD_ID);

    public static final DeferredItem<Item> RADAUTI_CIORBA;
    public static final DeferredItem<Item> STOMACH_CIORBA;
    public static final DeferredItem<Item> MAYONNAISE;
    public static final DeferredItem<Item> SALAD_BOEUF;
    public static final DeferredItem<Item> RAW_MICI;
    public static final DeferredItem<Item> COOKED_MICI;
    public static final DeferredItem<Item> CORN_FLOUR;
    public static final DeferredItem<Item> MAMALIGA;
    public static final DeferredItem<Item> SARMALE;
    public static final DeferredItem<Item> BOILED_CORN;
    public static final DeferredItem<Item> BOILED_EGG;
    public static final DeferredItem<Item> GARLIC;
    public static final DeferredItem<Item> RAW_POTATOES;
    public static final DeferredItem<Item> FRIED_POTATOES;

    static {
        RADAUTI_CIORBA = ITEMS.register("radauti_soup", () -> new ConsumableItem(new Item.Properties()
                .food(FoodValues.RADAUTI_SOUP)
                .stacksTo(16)
                .craftRemainder(Items.BOWL), true));
        STOMACH_CIORBA = ITEMS.register("tripe_soup", () -> new ConsumableItem(new Item.Properties()
                .food(FoodValues.TRIPE_SOUP)
                .stacksTo(16)
                .craftRemainder(Items.BOWL), true));
        SALAD_BOEUF = ITEMS.register("salad_boeuf", () -> new ConsumableItem(new Item.Properties()
                .food(FoodValues.SALAD_BOEUF)
                .stacksTo(16)
                .craftRemainder(Items.BOWL), true));
        MAYONNAISE = ITEMS.register("mayonnaise", () -> new DrinkableItem(new Item.Properties()
                .food(FoodValues.MAYONNAISE)
                .stacksTo(16)));
        SARMALE = ITEMS.register("sarmale", () -> new ConsumableItem(new Item.Properties()
                .food(FoodValues.SARMALE)
                .stacksTo(64), true));
        RAW_MICI = ITEMS.register("raw_mici", () -> new Item(new Item.Properties()
                .food(FoodValues.RAW_MICI)));
        COOKED_MICI = ITEMS.register("cooked_mici", () -> new Item(new Item.Properties()
                .food(FoodValues.COOKED_MICI)));
        CORN_FLOUR = ITEMS.register("corn_flour", () -> new Item(new Item.Properties()));
        MAMALIGA = ITEMS.register("mamaliga_serving", () -> new Item(new Item.Properties()
                .food(FoodValues.MAMALIGA)));
        BOILED_CORN = ITEMS.register("boiled_corn", () -> new Item(new Item.Properties()
                .food(FoodValues.BOILED_CORN)));
        BOILED_EGG = ITEMS.register("boiled_egg", () -> new Item(new Item.Properties()
                .food(FoodValues.BOILED_EGG)));
        RAW_POTATOES = ITEMS.register("raw_potatoes", () -> new Item(new Item.Properties()
                .food(FoodValues.RAW_POTATOES)));
        FRIED_POTATOES = ITEMS.register("fried_potatoes", () -> new Item(new Item.Properties()
                .food(FoodValues.FRIED_POTATOES)));
        GARLIC = ITEMS.register(GarlicItem.NAME, GarlicItem::new);
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
