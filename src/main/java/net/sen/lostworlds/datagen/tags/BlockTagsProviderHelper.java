package net.sen.lostworlds.datagen.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.sen.lostworlds.LostWorlds;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static net.sen.lostworlds.common.utils.ResourceTools.*;

public abstract class BlockTagsProviderHelper extends BlockTagsProvider {
    public BlockTagsProviderHelper(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, LostWorlds.MODID, existingFileHelper);
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
