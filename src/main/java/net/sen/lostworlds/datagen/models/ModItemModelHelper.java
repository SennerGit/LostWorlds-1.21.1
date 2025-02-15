package net.sen.lostworlds.datagen.models;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.client.model.generators.loaders.ItemLayerModelBuilder;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.sen.lostworlds.LostWorlds;

import java.util.function.Supplier;

import static net.sen.lostworlds.common.utils.ResourceTools.*;

public abstract class ModItemModelHelper extends ItemModelProvider {
    public ModItemModelHelper(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, LostWorlds.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        generateItems();
        generateBlocks();
    }

    protected abstract void generateItems();

    protected abstract void generateBlocks();

    protected ItemModelBuilder basicItem(Supplier<Item> item) {
        return basicItem(item.get());
    }

    protected void generateBlockItem(Supplier<Block> block) {
        withExistingParent(getBlockId(block.get()), modLoc("block/" + getBlockId(block.get())));
    }

    protected void createArmourSet(Supplier<Item> helmet, Supplier<Item> chestplate, Supplier<Item> leggings, Supplier<Item> boots) {
        createArmourPiece(helmet, "helmet");
        createArmourPiece(chestplate, "chestplate");
        createArmourPiece(leggings, "leggings");
        createArmourPiece(boots, "boots");
    }

    protected void createArmourPiece(Supplier<Item> item, String name) {
        createTrim(item, name, TrimMaterials.QUARTZ, 0.1f);
        createTrim(item, name, TrimMaterials.IRON, 0.2f);
        createTrim(item, name, TrimMaterials.NETHERITE, 0.3f);
        createTrim(item, name, TrimMaterials.REDSTONE, 0.4f);
        createTrim(item, name, TrimMaterials.COPPER, 0.5f);
        createTrim(item, name, TrimMaterials.GOLD, 0.6f);
        createTrim(item, name, TrimMaterials.EMERALD, 0.7f);
        createTrim(item, name, TrimMaterials.DIAMOND, 0.8f);
        createTrim(item, name, TrimMaterials.LAPIS, 0.9f);
        createTrim(item, name, TrimMaterials.AMETHYST, 1.0f);
        createArmour(item);
    }

    protected ItemModelBuilder createTrim(Supplier<Item> item, String name, ResourceKey<TrimMaterial> trimMaterial, float indexId) {
        ItemModelBuilder base = this.basicItem(item);
        ModelFile trimModel = this.withExistingParent(getItemId(item.get()) + "_" + trimMaterial.location().getPath() + "_trim",
                        getMinecraftPath("item/generated"))
                .texture("layer0", getModPath("item/" + getItemId(item.get())))
                .texture("layer1", getMinecraftPath("trims/items/" + name + "_trim_" + trimMaterial.location().getPath()));

        return base.override().predicate(getMinecraftPath("trim_type"), indexId).model(trimModel).end();
    }

    protected ItemModelBuilder createArmour(Supplier<Item> item) {
        ModelFile quartzLoc = generateArmorModel(getItemTrim(item, "quartz_trim"));
        ModelFile ironLoc = generateArmorModel(getItemTrim(item, "iron_trim"));
        ModelFile netheriteLoc = generateArmorModel(getItemTrim(item, "netherite_trim"));
        ModelFile redstoneLoc = generateArmorModel(getItemTrim(item, "redstone_trim"));
        ModelFile copperLoc = generateArmorModel(getItemTrim(item, "copper_trim"));
        ModelFile goldLoc = generateArmorModel(getItemTrim(item, "gold_trim"));
        ModelFile emeraldLoc = generateArmorModel(getItemTrim(item, "emerald_trim"));
        ModelFile diamondLoc = generateArmorModel(getItemTrim(item, "diamond_trim"));
        ModelFile lapisLoc = generateArmorModel(getItemTrim(item, "lapis_trim"));
        ModelFile amethystLoc = generateArmorModel(getItemTrim(item, "amethyst_trim"));

        return withExistingParent(getItemId(item.get()),
                getMinecraftPath("item/generated"))
                .override().predicate(getModPath("item/" + getItemId(item.get())), 0.1f).model(quartzLoc).end()
                .override().predicate(getModPath("item/" + getItemId(item.get())), 0.2f).model(ironLoc).end()
                .override().predicate(getModPath("item/" + getItemId(item.get())), 0.3f).model(netheriteLoc).end()
                .override().predicate(getModPath("item/" + getItemId(item.get())), 0.4f).model(redstoneLoc).end()
                .override().predicate(getModPath("item/" + getItemId(item.get())), 0.5f).model(copperLoc).end()
                .override().predicate(getModPath("item/" + getItemId(item.get())), 0.6f).model(goldLoc).end()
                .override().predicate(getModPath("item/" + getItemId(item.get())), 0.7f).model(emeraldLoc).end()
                .override().predicate(getModPath("item/" + getItemId(item.get())), 0.8f).model(diamondLoc).end()
                .override().predicate(getModPath("item/" + getItemId(item.get())), 0.9f).model(lapisLoc).end()
                .override().predicate(getModPath("item/" + getItemId(item.get())), 1.0f).model(amethystLoc).end()
                .texture("layer0", getModPath("item/" + getItemId(item.get())));
    }

    protected static String getItemTrim(Supplier<Item> item, String trimType) {
        return LostWorlds.MODID + ":item/" + getItemId(item.get()) + "_" + trimType;
    }

    protected ItemModelBuilder generateArmorModel(String name, ResourceLocation... layers) {
        return buildItemModel(name, "item/generated", 0, layers);
    }

    protected ItemModelBuilder generateArmorModel(String name) {
        return buildItemModel(name, "item/generated", 0);
    }

    protected ItemModelBuilder buildItemModel(String name, String parent, int emissivity, ResourceLocation... layers) {
        ItemModelBuilder builder = withExistingParent(name, parent);
        for (int i = 0; i < layers.length; i++) {
            builder = builder.texture("layer" + i, layers[i]);
        }
        if (emissivity > 0) builder = builder.customLoader(ItemLayerModelBuilder::begin).emissive(emissivity, emissivity, 0).renderType("minecraft:translucent", 0).end();
        return builder;
    }

    protected ItemModelBuilder buildItemModel(String name, String parent, int emissivity) {
        ItemModelBuilder builder = withExistingParent(name, parent);

        if (emissivity > 0) builder = builder.customLoader(ItemLayerModelBuilder::begin).emissive(emissivity, emissivity, 0).renderType("minecraft:translucent", 0).end();
        return builder;
    }

    protected void createToolSet(Supplier<Item> sword, Supplier<Item> pickaxe, Supplier<Item> axe, Supplier<Item> shovel, Supplier<Item> hoe) {
        handheldItem(sword);
        handheldItem(pickaxe);
        handheldItem(axe);
        handheldItem(shovel);
        handheldItem(hoe);
    }

    protected ItemModelBuilder handheldItem(Supplier<Item> item) {
        return withExistingParent(getItemId(item.get()),
                getMinecraftPath("item/handheld")).texture("layer0",
                getModPath("item/" + getItemId(item.get())));
    }
}
