package net.sen.lostworlds.common.registry;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sen.lostworlds.LostWorlds;

import java.util.function.Supplier;

import static net.sen.lostworlds.common.utils.ResourceTools.*;

public class LostWorldsBlocks {
    private static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(LostWorlds.MODID);
    private static final DeferredRegister.Items BLOCK_ITEMS = DeferredRegister.createItems(LostWorlds.MODID);
    
    private static DeferredBlock<Block> createBlock(String name) {
        DeferredBlock<Block> toReturn = BLOCKS.register(name, () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));
        createBlockItem(name, toReturn);
        return toReturn;
    }

    private static DeferredBlock<Block> createBlock(String name, BlockBehaviour.Properties properties) {
        DeferredBlock<Block> toReturn = BLOCKS.register(name, () -> new Block(properties));
        createBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> DeferredBlock<T> createBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        createBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> DeferredBlock<T> createBlock(String name, DeferredBlock<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        createBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> DeferredItem<Item> createBlockItem(String name, DeferredBlock<T> block) {
        return BLOCK_ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        BLOCK_ITEMS.register(eventBus);
    }
}
