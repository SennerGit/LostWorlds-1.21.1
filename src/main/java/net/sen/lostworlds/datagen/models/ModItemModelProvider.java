package net.sen.lostworlds.datagen.models;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.sen.lostworlds.common.registry.LostWorldsItems;

public class ModItemModelProvider extends ModItemModelHelper {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, existingFileHelper);
    }

    @Override
    protected void generateItems() {
    }

    @Override
    protected void generateBlocks() {

    }
}
