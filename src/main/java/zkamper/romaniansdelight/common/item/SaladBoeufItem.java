package zkamper.romaniansdelight.common.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.registry.ModEffects;
import zkamper.romaniansdelight.registry.ModCreativeTab;

public class SaladBoeufItem extends ConsumableItem {
    public static final String NAME = "salad_boeuf";
    public static final FoodProperties FOOD_PROPERTIES = new FoodProperties.Builder()
            .nutrition(10)
            .saturationMod(1F)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 6000, 0),1.0F)
            .build();
    public static final Item.Properties PROPERTIES = new Item.Properties()
            .tab(ModCreativeTab.MOD_TAB)
            .food(FOOD_PROPERTIES)
            .stacksTo(16)
            .craftRemainder(Items.BOWL);

    public SaladBoeufItem() {
        super(PROPERTIES, true);
    }
}
