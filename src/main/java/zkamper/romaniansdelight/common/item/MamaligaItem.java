package zkamper.romaniansdelight.common.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import zkamper.romaniansdelight.registry.ModCreativeTab;

public class MamaligaItem extends Item {
    public static final String NAME = "mamaliga_serving";

    public static Item.Properties PROPERTIES = new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(5).saturationMod(0.8f).build())
            .tab(ModCreativeTab.MOD_TAB)
            .stacksTo(64);

    public MamaligaItem() {
        super(PROPERTIES);
    }
}
