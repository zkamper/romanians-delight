package zkamper.romaniansdelight;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import zkamper.romaniansdelight.registry.ModBlockEntities;
import zkamper.romaniansdelight.common.block.renderer.GrillRenderer;

@Mod.EventBusSubscriber(
        modid = RomaniansDelight.MOD_ID,
        bus = Mod.EventBusSubscriber.Bus.MOD,
        value = {Dist.CLIENT}
)
public class ClientSetupEvents {
    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntities.GRILL.get(), GrillRenderer::new);
    }
}
