package net.sen.lostworlds.datagen.language;

import net.minecraft.data.PackOutput;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.sen.lostworlds.common.registry.LostWorldsBlocks;
import net.sen.lostworlds.common.registry.LostWorldsItems;

import java.util.HashMap;
import java.util.List;
import java.util.function.Supplier;

public abstract class LanguageDefenition extends LanguageProviderHelper {
    public LanguageDefenition(PackOutput output, String locale) {
        super(output, locale);
    }

    @Override
    protected void addTranslations() {
        blockMap().forEach((key, name) -> {
            addBlock(key, name);
        });
        itemMap().forEach((key, name) -> {
            addItem(key, name);
        });
        entityTypeMap().forEach((key, name) -> {
            addMob(key, name);
        });
    }

    /**
     * blockList contents: [LostWorldsBlocks.TWIG, LostWorldsBlocks.PEBBLE, LostWorldsBlocks.SEASHELL]
     */
    abstract List<String> blockNames();
    private static List<Supplier<? extends Block>> blockList = List.of(
    );
    private HashMap<Supplier<? extends Block>, String> blockMap(){
        HashMap<Supplier<? extends Block>, String> newBlocksMap = new HashMap<>();

        for (int i = 0; i < blockList.size(); i++) {
            newBlocksMap.put(blockList.get(i), blockNames().get(i));
        }

        return newBlocksMap;
    }

    /**
     * itemList contents: [LostWorldsItems.PEBBLE, LostWorldsItems.SEASHELL]
     */
    abstract List<String> itemNames();
    private static List<Supplier<? extends Item>> itemList = List.of(
    );
    private HashMap<Supplier<? extends Item>, String> itemMap(){
        HashMap<Supplier<? extends Item>, String> newItemsMap = new HashMap<>();

        for (int i = 0; i < itemList.size(); i++) {
            newItemsMap.put(itemList.get(i), itemNames().get(i));
        }

        return newItemsMap;
    }

    /**
     * entityTypeList contents: []
     */
    abstract List<String> entityTypeNames();
    private static List<Supplier<? extends EntityType<?>>> entityTypeList = List.of(
    );
    private HashMap<Supplier<? extends EntityType<?>>, String> entityTypeMap(){
        HashMap<Supplier<? extends EntityType<?>>, String> newEntityTypesMap = new HashMap<>();

        for (int i = 0; i < entityTypeList.size(); i++) {
            newEntityTypesMap.put(entityTypeList.get(i), entityTypeNames().get(i));
        }

        return newEntityTypesMap;
    }
}
