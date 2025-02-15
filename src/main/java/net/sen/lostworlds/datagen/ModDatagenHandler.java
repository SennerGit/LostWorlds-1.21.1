package net.sen.lostworlds.datagen;

import net.minecraft.DetectedVersion;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.metadata.PackMetadataGenerator;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;
import net.minecraft.util.InclusiveRange;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.sen.lostworlds.LostWorlds;
import net.sen.lostworlds.datagen.language.EnUsLanguageProvider;
import net.sen.lostworlds.datagen.loot_tables.ModLootTableProvider;
import net.sen.lostworlds.datagen.models.ModBlockStateProvider;
import net.sen.lostworlds.datagen.models.ModItemModelProvider;
import net.sen.lostworlds.datagen.recipes.ModRecipeProvider;
import net.sen.lostworlds.datagen.tags.ModBlockTagsProvider;
import net.sen.lostworlds.datagen.tags.ModEntityTagsProvider;
import net.sen.lostworlds.datagen.tags.ModItemTagsProvider;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = LostWorlds.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ModDatagenHandler
{
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = event.getGenerator().getPackOutput();
        ExistingFileHelper helper = event.getExistingFileHelper();

        //Automating stuff
        addArmorTrims(helper);

        //Client
        generator.addProvider(event.includeClient(), new EnUsLanguageProvider(output));
        generator.addProvider(event.includeClient(), new ModItemModelProvider(output, helper));
        generator.addProvider(event.includeClient(), new ModBlockStateProvider(output, helper));

        //Registry-based stuff
        DatapackBuiltinEntriesProvider datapackProvider = new ModRegistryDataGenerator(output, event.getLookupProvider());
        CompletableFuture<HolderLookup.Provider> lookupProvider = datapackProvider.getRegistryProvider();

        generator.addProvider(event.includeServer(), datapackProvider);
        generator.addProvider(event.includeServer(), new ModRecipeProvider(output, lookupProvider));
        generator.addProvider(event.includeServer(), new ModLootTableProvider(output, lookupProvider));

        //Tags
        ModBlockTagsProvider blockTags = new ModBlockTagsProvider(output, lookupProvider, helper);
        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(), new ModItemTagsProvider(output, lookupProvider, blockTags.contentsGetter(), helper));
        generator.addProvider(event.includeServer(), new ModEntityTagsProvider(output, lookupProvider, helper));

        //pack.meta
        generator.addProvider(true, new PackMetadataGenerator(output).add(PackMetadataSection.TYPE, new PackMetadataSection(
                Component.literal("Resources for Sens Biomes Expansion Mod"),
                DetectedVersion.BUILT_IN.getPackVersion(PackType.SERVER_DATA),
                Optional.of(new InclusiveRange<>(0, Integer.MAX_VALUE))
        )));
    }

    private static void addArmorTrims(ExistingFileHelper helper) {
        addTrimToArmor(helper, "boots_trim_");
        addTrimToArmor(helper, "chestplate_trim_");
        addTrimToArmor(helper, "helmet_trim_");
        addTrimToArmor(helper, "leggings_trim_");
    }

    private static void addTrimToArmor(ExistingFileHelper existingFileHelper, String armorPiece) {
        existingFileHelper.trackGenerated(ResourceLocation.withDefaultNamespace(armorPiece + TrimMaterials.QUARTZ.location().getPath()), PackType.CLIENT_RESOURCES, ".png", "textures/trims/items");
        existingFileHelper.trackGenerated(ResourceLocation.withDefaultNamespace(armorPiece + TrimMaterials.IRON.location().getPath()), PackType.CLIENT_RESOURCES, ".png", "textures/trims/items");
        existingFileHelper.trackGenerated(ResourceLocation.withDefaultNamespace(armorPiece + TrimMaterials.NETHERITE.location().getPath()), PackType.CLIENT_RESOURCES, ".png", "textures/trims/items");
        existingFileHelper.trackGenerated(ResourceLocation.withDefaultNamespace(armorPiece + TrimMaterials.REDSTONE.location().getPath()), PackType.CLIENT_RESOURCES, ".png", "textures/trims/items");
        existingFileHelper.trackGenerated(ResourceLocation.withDefaultNamespace(armorPiece + TrimMaterials.COPPER.location().getPath()), PackType.CLIENT_RESOURCES, ".png", "textures/trims/items");
        existingFileHelper.trackGenerated(ResourceLocation.withDefaultNamespace(armorPiece + TrimMaterials.GOLD.location().getPath()), PackType.CLIENT_RESOURCES, ".png", "textures/trims/items");
        existingFileHelper.trackGenerated(ResourceLocation.withDefaultNamespace(armorPiece + TrimMaterials.EMERALD.location().getPath()), PackType.CLIENT_RESOURCES, ".png", "textures/trims/items");
        existingFileHelper.trackGenerated(ResourceLocation.withDefaultNamespace(armorPiece + TrimMaterials.DIAMOND.location().getPath()), PackType.CLIENT_RESOURCES, ".png", "textures/trims/items");
        existingFileHelper.trackGenerated(ResourceLocation.withDefaultNamespace(armorPiece + TrimMaterials.LAPIS.location().getPath()), PackType.CLIENT_RESOURCES, ".png", "textures/trims/items");
        existingFileHelper.trackGenerated(ResourceLocation.withDefaultNamespace(armorPiece + TrimMaterials.AMETHYST.location().getPath()), PackType.CLIENT_RESOURCES, ".png", "textures/trims/items");
    }
}
