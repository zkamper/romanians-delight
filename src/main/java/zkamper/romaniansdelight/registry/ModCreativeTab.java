package zkamper.romaniansdelight.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import zkamper.romaniansdelight.RomaniansDelight;

public class ModCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RomaniansDelight.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MOD_TAB = CREATIVE_MODE_TABS.register(
            "romaniansdelight_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.romaniansdelight_tab"))
                    .icon(() -> new ItemStack(ModItems.COOKED_MICI.get()))
                    .displayItems((params, output) -> {
                        output.accept(ModItems.GARLIC.get());
                        output.accept(ModItems.CORN_FLOUR.get());
                        output.accept(ModItems.RAW_MICI.get());
                        output.accept(ModItems.COOKED_MICI.get());
                        output.accept(ModItems.MAMALIGA.get());
                        output.accept(ModItems.SARMALE.get());
                        output.accept(ModItems.BOILED_CORN.get());
                        output.accept(ModItems.BOILED_EGG.get());
                        output.accept(ModItems.RAW_POTATOES.get());
                        output.accept(ModItems.FRIED_POTATOES.get());
                        output.accept(ModItems.SALAD_BOEUF.get());
                        output.accept(ModItems.MAYONNAISE.get());
                        output.accept(ModItems.RADAUTI_CIORBA.get());
                        output.accept(ModItems.STOMACH_CIORBA.get());
                        output.accept(new ItemStack(ModBlocks.GRILL_BLOCK.get()));
                        output.accept(new ItemStack(ModBlocks.GARLIC_CRATE.get()));
                        output.accept(ModBlocks.MAMALIGA_ITEM.get());
                    })
                    .build()
    );

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
