package zkamper.romaniansdelight.registry;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.registry.ModEffects;

import java.util.function.Supplier;

public class FoodValues {
    public static FoodProperties BOILED_CORN = new FoodProperties.Builder()
            .nutrition(4)
            .saturationMod(0.5F)
            .build();
    public static FoodProperties BOILED_EGG = new FoodProperties.Builder()
            .nutrition(2)
            .saturationMod(0.5F)
            .fast()
            .build();
    public static FoodProperties COOKED_MICI = new FoodProperties.Builder()
            .nutrition(6)
            .saturationMod(0.9F)
            .build();
    public static FoodProperties RAW_MICI = new FoodProperties.Builder()
            .nutrition(2)
            .saturationMod(0.2F)
            .build();
    public static FoodProperties GARLIC =  new FoodProperties.Builder()
            .nutrition(1)
            .saturationMod(0.5F)
            .build();
    public static FoodProperties MAMALIGA = new FoodProperties.Builder()
            .nutrition(5)
            .saturationMod(0.8F)
            .build();
    public static FoodProperties MAYONNAISE = new FoodProperties.Builder()
            .nutrition(1)
            .saturationMod(0F)
            .build();
    public static FoodProperties RADAUTI_SOUP = new FoodProperties.Builder()
            .nutrition(14)
            .saturationMod(0.8F)
            .effect(() -> new MobEffectInstance((MobEffect) ModEffects.COMFORT.get(), 3600, 0),1.0F)
            .build();
    public static FoodProperties SALAD_BOEUF = new FoodProperties.Builder()
            .nutrition(10)
            .saturationMod(1F)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 6000, 0),1.0F)
            .build();
    public static FoodProperties SARMALE = new FoodProperties.Builder()
            .nutrition(7)
            .saturationMod(0.5F)
            .build();
    public static FoodProperties TRIPE_SOUP = new FoodProperties.Builder()
            .nutrition(12)
            .saturationMod(0.6F)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 3600, 0),1.0F)
            .build();
}
