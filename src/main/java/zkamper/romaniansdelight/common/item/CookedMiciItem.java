package zkamper.romaniansdelight.common.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import zkamper.romaniansdelight.registry.ModCreativeTab;

public class CookedMiciItem extends Item{
    public static final String NAME = "cooked_mici";

    public static Item.Properties PROPERTIES = new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(6).saturationMod(0.9f).build())
            .tab(ModCreativeTab.MOD_TAB);

    public CookedMiciItem() {
        super(PROPERTIES);
    }
}
