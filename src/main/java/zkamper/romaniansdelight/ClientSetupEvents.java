package zkamper.romaniansdelight;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import zkamper.romaniansdelight.common.block.renderer.GrillRenderer;
import zkamper.romaniansdelight.registry.ModBlockEntities;

@EventBusSubscriber(
        modid = RomaniansDelight.MOD_ID,
        bus = EventBusSubscriber.Bus.MOD,
        value = {Dist.CLIENT}
)
public class ClientSetupEvents {
    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntities.GRILL.get(), GrillRenderer::new);
    }
}
