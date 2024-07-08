package zkamper.romaniansdelight.common.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import vectorwing.farmersdelight.common.FoodValues;
import zkamper.romaniansdelight.registry.ModCreativeTab;

public class SarmaleItem extends Item {
    public static final String NAME = "sarmale";
    public static final FoodProperties FOOD_PROPERTIES = new FoodProperties.Builder()
            .nutrition(7)
            .saturationMod(0.5F)
            .build();
    public static final Item.Properties PROPERTIES = new Item.Properties()
            .tab(ModCreativeTab.MOD_TAB)
            .food(FOOD_PROPERTIES)
            .stacksTo(16);
    public SarmaleItem() {
        super(PROPERTIES);
    }
}
