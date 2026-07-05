package zkamper.romaniansdelight.common.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import zkamper.romaniansdelight.registry.ModBlocks;

public class GarlicItem extends ItemNameBlockItem {
    public static final String NAME = "garlic";

    public static Item.Properties PROPERTIES = new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.5f).build());

    public GarlicItem() {
        super(ModBlocks.GARLIC_CROP.get(), PROPERTIES);
    }
}
