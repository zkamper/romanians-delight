package zkamper.romaniansdelight.common;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import zkamper.romaniansdelight.RomaniansDelight;
import zkamper.romaniansdelight.common.item.CookedMiciItem;
import zkamper.romaniansdelight.common.item.CornFlourItem;
import zkamper.romaniansdelight.common.item.RawMiciItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, RomaniansDelight.MOD_ID);
    public static final RegistryObject<Item> RAW_MICI;
    public static final RegistryObject<Item> COOKED_MICI;
    public static final RegistryObject<Item> CORN_FLOUR;

    static {
        RAW_MICI = ITEMS.register(RawMiciItem.NAME, RawMiciItem::new);
        COOKED_MICI = ITEMS.register(CookedMiciItem.NAME, CookedMiciItem::new);
        CORN_FLOUR = ITEMS.register(CornFlourItem.NAME, CornFlourItem::new);
    }


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
