package net.sen.lostworlds.client.layers;

import net.minecraft.client.model.geom.ModelLayerLocation;

import static net.sen.lostworlds.common.utils.ResourceTools.*;

public class LostWorldsLayers {
    private static ModelLayerLocation createModelLayerLocation(String name) {
        String id = name + "_layer";
        return new ModelLayerLocation(getModPath(id), "main");
    }
}
