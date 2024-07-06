package zkamper.romaniansdelight;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import zkamper.romaniansdelight.common.ModBlockEntities;
import zkamper.romaniansdelight.common.ModBlocks;
import zkamper.romaniansdelight.common.ModItems;

@Mod(RomaniansDelight.MOD_ID)
public class RomaniansDelight {
    public static final String MOD_ID = "romaniansdelight";
    public RomaniansDelight() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);
    }
}
