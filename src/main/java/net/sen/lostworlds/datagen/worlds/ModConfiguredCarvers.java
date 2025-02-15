package net.sen.lostworlds.datagen.worlds;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;

public class ModConfiguredCarvers {
    public static void bootstrap(BootstrapContext<ConfiguredWorldCarver<?>> context) {
        HolderGetter<Block> blocks = context.lookup(Registries.BLOCK);
    }
}
