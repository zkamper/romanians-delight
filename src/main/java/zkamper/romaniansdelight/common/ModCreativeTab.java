package zkamper.romaniansdelight.common;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeTab {
    public static final CreativeModeTab MOD_TAB  = new CreativeModeTab("romaniansdelight_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.COOKED_MICI.get());
        }
    };
}
