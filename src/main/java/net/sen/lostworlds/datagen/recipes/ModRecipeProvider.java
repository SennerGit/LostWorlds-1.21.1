package net.sen.lostworlds.datagen.recipes;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.sen.lostworlds.common.registry.LostWorldsItems;

import java.util.concurrent.CompletableFuture;

import static net.sen.lostworlds.common.utils.ResourceTools.getItemLikeId;
import static net.sen.lostworlds.common.utils.ResourceTools.getModPath;

public class ModRecipeProvider extends ModRecipeHelper {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {
        super.buildRecipes(output);
    }
}
