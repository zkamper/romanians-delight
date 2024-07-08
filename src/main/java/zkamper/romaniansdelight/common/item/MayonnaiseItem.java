package zkamper.romaniansdelight.common.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import vectorwing.farmersdelight.common.item.DrinkableItem;
import zkamper.romaniansdelight.registry.ModCreativeTab;

public class MayonnaiseItem extends DrinkableItem {
    public static final String NAME = "mayonnaise";
    public static final FoodProperties FOOD_PROPERTIES = new FoodProperties.Builder()
            .nutrition(1)
            .saturationMod(0F)
            .build();
    public static final Item.Properties PROPERTIES = new Item.Properties()
            .tab(ModCreativeTab.MOD_TAB)
            .food(FOOD_PROPERTIES)
            .stacksTo(16);

    public MayonnaiseItem() {
        super(PROPERTIES);
    }
}
