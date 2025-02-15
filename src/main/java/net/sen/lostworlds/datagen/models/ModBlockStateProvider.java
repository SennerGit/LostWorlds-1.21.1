package net.sen.lostworlds.datagen.models;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.sen.lostworlds.common.registry.LostWorldsBlocks;

public class ModBlockStateProvider extends ModBlockStateHelper {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
    }
}
