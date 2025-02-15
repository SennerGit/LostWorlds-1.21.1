package net.sen.lostworlds.datagen.models;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.sen.lostworlds.LostWorlds;

import java.util.function.Supplier;

import static net.sen.lostworlds.common.utils.ResourceTools.*;

public abstract class ModBlockStateHelper extends BlockStateProvider {
    ExistingFileHelper exFileHelper;
    public ModBlockStateHelper(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, LostWorlds.MODID, exFileHelper);
        this.exFileHelper = exFileHelper;
    }

    protected void simpleBlock(Supplier<Block> block) {
        this.simpleBlock(block.get());
    }

    protected void floorBlock(Supplier<Block> block, String... modelFiles) {
//        List<ModelFile> floorModel = new ArrayList<>();
//
//        for (int i = 0; i < modelFiles.length; i++) {
//            String name = modelFiles[i];
//            floorModel.add(models().withExistingParent(name, ResourceLocation.fromNamespaceAndPath(LostWorlds.MODID, "block/template_floor_block")).texture("all", ResourceLocation.fromNamespaceAndPath(LostWorlds.MODID, "block/" + name)));
//        }
//
//        this.getVariantBuilder(block.get()).forAllStates(blockState -> {
//
//            return ConfiguredModel.builder().modelFile().build();
//        })
//        ;
    }
}
