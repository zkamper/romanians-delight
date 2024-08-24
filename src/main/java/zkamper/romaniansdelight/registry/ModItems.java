package zkamper.romaniansdelight.registry;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import zkamper.romaniansdelight.RomaniansDelight;
import zkamper.romaniansdelight.common.item.*;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, RomaniansDelight.MOD_ID);
    public static final RegistryObject<Item> RADAUTI_CIORBA;
    public static final RegistryObject<Item> STOMACH_CIORBA;
    public static final RegistryObject<Item> MAYONNAISE;
    public static final RegistryObject<Item> SALAD_BOEUF;
    public static final RegistryObject<Item> RAW_MICI;
    public static final RegistryObject<Item> COOKED_MICI;
    public static final RegistryObject<Item> CORN_FLOUR;
    public static final RegistryObject<Item> MAMALIGA;
    public static final RegistryObject<Item> SARMALE;
    public static final RegistryObject<Item> BOILED_CORN;
    public static final RegistryObject<Item> BOILED_EGG;
    public static final RegistryObject<Item> GARLIC;

    static {
        RADAUTI_CIORBA = ITEMS.register(RadautiSoupItem.NAME, RadautiSoupItem::new);
        STOMACH_CIORBA = ITEMS.register(TripeSoupItem.NAME, TripeSoupItem::new);
        MAYONNAISE = ITEMS.register(MayonnaiseItem.NAME, MayonnaiseItem::new);
        SALAD_BOEUF = ITEMS.register(SaladBoeufItem.NAME, SaladBoeufItem::new);
        RAW_MICI = ITEMS.register(RawMiciItem.NAME, RawMiciItem::new);
        COOKED_MICI = ITEMS.register(CookedMiciItem.NAME, CookedMiciItem::new);
        CORN_FLOUR = ITEMS.register(CornFlourItem.NAME, CornFlourItem::new);
        MAMALIGA = ITEMS.register(MamaligaItem.NAME, MamaligaItem::new);
        SARMALE = ITEMS.register(SarmaleItem.NAME, SarmaleItem::new);
        BOILED_CORN = ITEMS.register(BoiledCornItem.NAME, BoiledCornItem::new);
        BOILED_EGG = ITEMS.register(BoiledEggItem.NAME, BoiledEggItem::new);
        GARLIC = ITEMS.register(GarlicItem.NAME, GarlicItem::new);
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
