package zkamper.romaniansdelight;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import zkamper.romaniansdelight.common.ModBlockEntities;
import zkamper.romaniansdelight.common.ModBlocks;
import zkamper.romaniansdelight.common.ModItems;

@Mod(RomaniansDelight.MOD_ID)
public class RomaniansDelight {
    public static final String MOD_ID = "romaniansdelight";
    private static final Logger LOGGER = LogUtils.getLogger();
    public RomaniansDelight() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);
    }


    private void commonSetup(final FMLCommonSetupEvent event) {
        // No idea tbh
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            LOGGER.info("Client setup complete");
            LOGGER.info("Username: {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
