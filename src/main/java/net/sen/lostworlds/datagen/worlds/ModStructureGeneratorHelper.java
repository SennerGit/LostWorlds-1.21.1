package net.sen.lostworlds.datagen.worlds;

import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.StructureSpawnOverride;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

import static net.sen.lostworlds.common.utils.ResourceTools.*;

public abstract class ModStructureGeneratorHelper {
    private static Structure.StructureSettings structure(@NotNull HolderSet<Biome> holderSet, @NotNull Map<MobCategory, StructureSpawnOverride> spawns, @NotNull GenerationStep.Decoration featureStep, @NotNull TerrainAdjustment terrainAdjustment) {
        return new Structure.StructureSettings(holderSet, spawns, featureStep, terrainAdjustment);
    }

    private static Structure.StructureSettings structure(@NotNull HolderSet<Biome> holderSet, @NotNull GenerationStep.Decoration featureStep, @NotNull TerrainAdjustment terrainAdjustment) {
        return new Structure.StructureSettings(holderSet, Map.of(), featureStep, terrainAdjustment);
    }

    public static ResourceKey<Structure> createStructureKey(String name) {
        return ResourceKey.create(Registries.STRUCTURE, getModPath(name));
    }

    private static ResourceKey<StructureSet> createStructureSetKey(String name) {
        return ResourceKey.create(Registries.STRUCTURE_SET, getModPath(name));
    }

    public static ResourceKey<StructureTemplatePool> createStructureTemplatePoolKey(String name) {
        return ResourceKey.create(Registries.TEMPLATE_POOL, getModPath(name));
    }

    public static ResourceKey<StructureProcessorList> createStructureProcessors(String name) {
        return ResourceKey.create(Registries.PROCESSOR_LIST, getModPath(name));
    }
}
