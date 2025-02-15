package net.sen.lostworlds.datagen.worlds;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.sen.lostworlds.LostWorlds;

import java.util.List;
import java.util.function.Supplier;

import static net.sen.lostworlds.common.utils.ResourceTools.*;

public abstract class ModConfiguredFeaturesHelper {
    protected static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, getModPath(name));
    }

    protected static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

    protected static void configureOverworldOre(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> oreKey, Supplier<Block> ore, Supplier<Block> deepslateOre, int size) {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> ores = List.of(
                OreConfiguration.target(stoneReplaceables, ore.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, deepslateOre.get().defaultBlockState())
        );

        register(context, oreKey, Feature.ORE, new OreConfiguration(ores, size));
    }

    private static <C extends FeatureConfiguration, F extends Feature<C>> F register(String string, F feature) {
        return Registry.register(BuiltInRegistries.FEATURE, ResourceLocation.fromNamespaceAndPath(LostWorlds.MODID, string), feature);
    }
}
