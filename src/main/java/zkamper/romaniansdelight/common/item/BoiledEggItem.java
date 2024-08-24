package zkamper.romaniansdelight.common.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import zkamper.romaniansdelight.registry.ModCreativeTab;

public class BoiledEggItem extends Item {
    public static final String NAME = "boiled_egg";

    public static Item.Properties PROPERTIES = new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(2).saturationMod(0.5f).fast().build())
            .tab(ModCreativeTab.MOD_TAB);

    public BoiledEggItem() {
        super(PROPERTIES);
    }
}
