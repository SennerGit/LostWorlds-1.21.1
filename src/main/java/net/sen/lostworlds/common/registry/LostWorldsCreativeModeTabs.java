package net.sen.lostworlds.common.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sen.lostworlds.LostWorlds;

import java.util.Collection;
import java.util.Locale;
import java.util.function.Supplier;

import static net.sen.lostworlds.common.utils.ResourceTools.*;
import static net.sen.lostworlds.common.registry.LostWorldsEntityTypes.*;

public class LostWorldsCreativeModeTabs {
    private static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LostWorlds.MODID);

    private static String generateName(String id) {
        return ("itemgroup." + LostWorlds.MODID + "." + id).toLowerCase(Locale.ROOT);
    }

    private static void createSpawnEggsAlphabetical(CreativeModeTab.Output output) {
        Collection<? extends Item> eggs = SPAWN_EGGS.getEntries().stream().map(DeferredHolder::value).toList();
        eggs.forEach(output::accept);
    }

    public static void register(IEventBus eventBus) {
        TABS.register(eventBus);
    }
}
