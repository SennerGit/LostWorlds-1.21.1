package net.sen.lostworlds.datagen.worlds;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.util.random.WeightedRandomList;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.StructureSpawnOverride;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class ModStructureGenerator extends ModStructureGeneratorHelper {
    @SuppressWarnings("deprecation")
    public static void bootstrapStructures(BootstrapContext<Structure> context) {
        Map<MobCategory, StructureSpawnOverride> mobSpawnBox = Arrays.stream(MobCategory.values())
                .collect(Collectors.toMap((category) -> category, (category) -> new StructureSpawnOverride(StructureSpawnOverride.BoundingBoxType.STRUCTURE, WeightedRandomList.create())));

        Map<MobCategory, StructureSpawnOverride> mobSpawnPiece = Arrays.stream(MobCategory.values())
                .collect(Collectors.toMap((category) -> category, (category) -> new StructureSpawnOverride(StructureSpawnOverride.BoundingBoxType.PIECE, WeightedRandomList.create())));

        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
        HolderGetter<StructureTemplatePool> pools = context.lookup(Registries.TEMPLATE_POOL);
    }

    @SuppressWarnings("deprecation")
    public static void bootstrapStructureSets(BootstrapContext<StructureSet> context) {
        HolderGetter<Structure> structures = context.lookup(Registries.STRUCTURE);
    }

    @SuppressWarnings("deprecation")
    public static void bootstrapStructureTemplatePools(BootstrapContext<StructureTemplatePool> context) {
        Holder<StructureTemplatePool> emptyPool = context.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY);
        HolderGetter<StructureProcessorList> processors = context.lookup(Registries.PROCESSOR_LIST);
    }

    @SuppressWarnings("deprecation")
    public static void bootstrapProcessors(BootstrapContext<StructureProcessorList> context) {

    }
}
