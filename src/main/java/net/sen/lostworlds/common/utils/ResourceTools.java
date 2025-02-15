package net.sen.lostworlds.common.utils;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.sen.lostworlds.LostWorlds;

import java.util.Locale;

public class ResourceTools {
    public static String getBlockId(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block).getPath().toLowerCase(Locale.ROOT);
    }

    public static String getItemId(Item item) {
        return BuiltInRegistries.ITEM.getKey(item).getPath().toLowerCase(Locale.ROOT);
    }

    public static String getItemLikeId(ItemLike item) {
        return BuiltInRegistries.ITEM.getKey(item.asItem()).getPath().toLowerCase(Locale.ROOT);
    }

    public static String getCreativeModeId(CreativeModeTab creativeModeTab) {
        return BuiltInRegistries.CREATIVE_MODE_TAB.getKey(creativeModeTab).getPath().toLowerCase(Locale.ROOT);
    }

    public static String getEntityId(EntityType<?> entityType) {
        return BuiltInRegistries.ENTITY_TYPE.getKey(entityType).getPath().toLowerCase(Locale.ROOT);
    }

    public static ResourceLocation getModPath(String name) {
        return ResourceLocation.fromNamespaceAndPath(LostWorlds.MODID.toLowerCase(Locale.ROOT), name.toLowerCase(Locale.ROOT));
    }

    public static ResourceLocation getMinecraftPath(String name) {
        return ResourceLocation.fromNamespaceAndPath("minecraft", name.toLowerCase(Locale.ROOT));
    }

    public static ResourceLocation entityRendererLoc(String name) {
        return getModPath("textures/entity/" + name + "/" + name + ".png");
    }

    public static ResourceLocation getRendererLocation(EntityType<? extends Entity> entityType) {
        return entityRendererLoc(getEntityId(entityType).toLowerCase(Locale.ROOT));
    }
}
