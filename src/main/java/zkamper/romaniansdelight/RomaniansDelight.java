package zkamper.romaniansdelight;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import zkamper.romaniansdelight.registry.ModBlockEntities;
import zkamper.romaniansdelight.registry.ModBlocks;
import zkamper.romaniansdelight.registry.ModItems;

@Mod(RomaniansDelight.MOD_ID)
public class RomaniansDelight {
    public static final String MOD_ID = "romaniansdelight";
    public RomaniansDelight() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        // Registries
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModItems.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);
    }
}
