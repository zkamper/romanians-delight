package zkamper.romaniansdelight;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import zkamper.romaniansdelight.registry.ModBlockEntities;
import zkamper.romaniansdelight.registry.ModBlocks;
import zkamper.romaniansdelight.registry.ModCreativeTab;
import zkamper.romaniansdelight.registry.ModItems;

@Mod(RomaniansDelight.MOD_ID)
public class RomaniansDelight {
    public static final String MOD_ID = "romaniansdelight";

    public RomaniansDelight(IEventBus modEventBus) {
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModItems.register(modEventBus);
        ModCreativeTab.register(modEventBus);
    }
}
