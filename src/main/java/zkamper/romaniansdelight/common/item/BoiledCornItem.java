package zkamper.romaniansdelight.common.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import zkamper.romaniansdelight.registry.ModCreativeTab;

public class BoiledCornItem extends Item {

    public static final String NAME = "boiled_corn";

    public static Item.Properties PROPERTIES = new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(4).saturationMod(0.5f).build())
            .tab(ModCreativeTab.MOD_TAB);

    public BoiledCornItem() {
        super(PROPERTIES);
    }
}