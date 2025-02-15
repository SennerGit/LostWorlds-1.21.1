package net.sen.lostworlds;

import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.sen.lostworlds.client.LostWorldsClient;
import net.sen.lostworlds.common.registry.LostWorldsBlocks;
import net.sen.lostworlds.common.registry.LostWorldsCreativeModeTabs;
import net.sen.lostworlds.common.registry.LostWorldsEntityTypes;
import net.sen.lostworlds.common.registry.LostWorldsItems;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(LostWorlds.MODID)
public class LostWorlds
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "lostworlds";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public LostWorlds(IEventBus eventBus, ModContainer modContainer, Dist dist)
    {
        if (dist.isClient()) {
            LostWorldsClient.LostWorldsClientRegistry(eventBus);
        }

        eventBus.addListener(this::commonSetup);
        eventBus.addListener(this::onEntityAttributeCreation);

        LostWorldsBlocks.register(eventBus);
        LostWorldsItems.register(eventBus);
        LostWorldsEntityTypes.register(eventBus);

        LostWorldsCreativeModeTabs.register(eventBus);

        NeoForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

    private void onEntityAttributeCreation(final EntityAttributeCreationEvent event) {
        LostWorldsEntityTypes.onEntityAttributeCreation(event);
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    public void sendMessage(String message) { LOGGER.debug(message); }
}
