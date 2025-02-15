package net.sen.lostworlds.client;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

public class LostWorldsClient {
    public static void LostWorldsClientRegistry(IEventBus eventBus) {
        eventBus.addListener(LostWorldsClient::renderEntities);
        eventBus.addListener(LostWorldsClient::registerLayer);
    }

    private static void renderEntities(EntityRenderersEvent.RegisterRenderers event) {
    }

    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
    }
}