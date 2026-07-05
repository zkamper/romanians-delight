package zkamper.romaniansdelight.registry;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class FoodValues {
    public static FoodProperties BOILED_CORN = new FoodProperties.Builder()
            .nutrition(4)
            .saturationModifier(0.5F)
            .build();
    public static FoodProperties BOILED_EGG = new FoodProperties.Builder()
            .nutrition(2)
            .saturationModifier(0.5F)
            .fast()
            .build();
    public static FoodProperties COOKED_MICI = new FoodProperties.Builder()
            .nutrition(6)
            .saturationModifier(0.9F)
            .build();
    public static FoodProperties RAW_MICI = new FoodProperties.Builder()
            .nutrition(2)
            .saturationModifier(0.2F)
            .build();
    public static FoodProperties MAMALIGA = new FoodProperties.Builder()
            .nutrition(5)
            .saturationModifier(0.8F)
            .build();
    public static FoodProperties MAYONNAISE = new FoodProperties.Builder()
            .nutrition(1)
            .saturationModifier(0F)
            .build();
    public static FoodProperties RADAUTI_SOUP = new FoodProperties.Builder()
            .nutrition(14)
            .saturationModifier(0.8F)
            .effect(new MobEffectInstance(ModEffects.COMFORT, 3600, 0), 1.0F)
            .build();
    public static FoodProperties SALAD_BOEUF = new FoodProperties.Builder()
            .nutrition(10)
            .saturationModifier(1F)
            .effect(new MobEffectInstance(ModEffects.COMFORT, 6000, 0), 1.0F)
            .build();
    public static FoodProperties SARMALE = new FoodProperties.Builder()
            .nutrition(7)
            .saturationModifier(0.5F)
            .build();
    public static FoodProperties TRIPE_SOUP = new FoodProperties.Builder()
            .nutrition(12)
            .saturationModifier(0.6F)
            .effect(new MobEffectInstance(ModEffects.COMFORT, 3600, 0), 1.0F)
            .build();
    public static FoodProperties RAW_POTATOES = new FoodProperties.Builder()
            .nutrition(1)
            .saturationModifier(1F)
            .build();
    public static FoodProperties FRIED_POTATOES = new FoodProperties.Builder()
            .nutrition(3)
            .saturationModifier(0.5F)
            .build();
}
