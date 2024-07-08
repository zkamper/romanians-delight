package zkamper.romaniansdelight.common.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import zkamper.romaniansdelight.registry.ModCreativeTab;

public class RawMiciItem extends Item {

    public static final String NAME = "raw_mici";

    public static Item.Properties PROPERTIES = new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(2).saturationMod(0.2f).build())
            .tab(ModCreativeTab.MOD_TAB);

    public RawMiciItem() {
        super(PROPERTIES);
    }
}
