package zkamper.romaniansdelight.common.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.registry.ModEffects;
import zkamper.romaniansdelight.registry.ModCreativeTab;


public class RadautiChorbaItem extends ConsumableItem {
    public static final String NAME = "radauti_soup";
    public static final FoodProperties FOOD_PROPERTIES = new FoodProperties.Builder()
            .nutrition(14)
            .saturationMod(0.8F)
            .effect(() -> new MobEffectInstance((MobEffect) ModEffects.COMFORT.get(), 3600, 0),1.0F)
            .build();
    public static final Properties PROPERTIES = new Item.Properties()
            .tab(ModCreativeTab.MOD_TAB)
            .food(FOOD_PROPERTIES)
            .stacksTo(16)
            .craftRemainder(Items.BOWL);

    public RadautiChorbaItem() {
        super(PROPERTIES, true);
    }
}
