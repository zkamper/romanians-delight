package zkamper.romaniansdelight.registry;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.item.MilkBottleItem;
import zkamper.romaniansdelight.RomaniansDelight;
import zkamper.romaniansdelight.common.item.*;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, RomaniansDelight.MOD_ID);
    public static final RegistryObject<Item> RADAUTI_CIORBA;
    public static final RegistryObject<Item> STOMACH_CIORBA;
    public static final RegistryObject<Item> RAW_MICI;
    public static final RegistryObject<Item> COOKED_MICI;
    public static final RegistryObject<Item> CORN_FLOUR;
    public static final RegistryObject<Item> MAMALIGA;

    static {
        RADAUTI_CIORBA = ITEMS.register(RadautiChorbaItem.NAME, RadautiChorbaItem::new);
        STOMACH_CIORBA = ITEMS.register(StomachChorbaItem.NAME, StomachChorbaItem::new);
        RAW_MICI = ITEMS.register(RawMiciItem.NAME, RawMiciItem::new);
        COOKED_MICI = ITEMS.register(CookedMiciItem.NAME, CookedMiciItem::new);
        CORN_FLOUR = ITEMS.register(CornFlourItem.NAME, CornFlourItem::new);
        MAMALIGA = ITEMS.register(MamaligaItem.NAME, MamaligaItem::new);
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
