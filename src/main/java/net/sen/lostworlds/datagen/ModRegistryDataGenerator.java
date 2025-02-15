package net.sen.lostworlds.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.sen.lostworlds.LostWorlds;
import net.sen.lostworlds.datagen.worlds.*;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

import static net.sen.lostworlds.common.utils.ResourceTools.*;

public class ModRegistryDataGenerator extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
            .add(Registries.BIOME, ModBiomes::bootstrap)
            .add(Registries.CONFIGURED_CARVER, ModConfiguredCarvers::bootstrap)
            .add(Registries.STRUCTURE, ModStructureGenerator::bootstrapStructures)
            .add(Registries.STRUCTURE_SET, ModStructureGenerator::bootstrapStructureSets)
            .add(Registries.TEMPLATE_POOL, ModStructureGenerator::bootstrapStructureTemplatePools)
            .add(Registries.PROCESSOR_LIST, ModStructureGenerator::bootstrapProcessors)
            ;

    public ModRegistryDataGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, BUILDER, Set.of("minecraft", LostWorlds.MODID));
    }
}
