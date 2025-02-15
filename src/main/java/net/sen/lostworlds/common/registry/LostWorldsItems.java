package net.sen.lostworlds.common.registry;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static net.sen.lostworlds.common.utils.ResourceTools.*;

public class LostWorldsItems {
    private static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SensBiomesExpansion.MODID);

    private static DeferredItem<Item> createItem(String name) {
        return ITEMS.register(name, () -> new Item(new Item.Properties()));
    }

    private static <T extends Item> DeferredItem<T> createItem(String name, Supplier<T> item) {
        return ITEMS.register(name, item);
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
