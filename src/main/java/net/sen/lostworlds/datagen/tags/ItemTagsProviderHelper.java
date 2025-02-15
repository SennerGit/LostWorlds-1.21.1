package net.sen.lostworlds.datagen.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.sen.lostworlds.LostWorlds;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static net.sen.lostworlds.common.utils.ResourceTools.*;

public abstract class ItemTagsProviderHelper extends ItemTagsProvider {
    public ItemTagsProviderHelper(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, LostWorlds.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        ModTags();
        VanillaTags();
        ForgeTags();
    }

    abstract void ModTags();
    abstract void VanillaTags();
    abstract void ForgeTags();
}
