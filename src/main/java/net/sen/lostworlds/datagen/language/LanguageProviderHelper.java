package net.sen.lostworlds.datagen.language;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.sen.lostworlds.LostWorlds;

import java.util.function.Supplier;

import static net.sen.lostworlds.common.utils.ResourceTools.*;

public abstract class LanguageProviderHelper extends LanguageProvider
{
    public LanguageProviderHelper(PackOutput output, String locale)
    {
        super(output, LostWorlds.MODID, locale);
    }

    protected void addCreativeTab(Supplier<CreativeModeTab> creativeTab, String translation) {
        this.add("itemgroup." + LostWorlds.MODID + "." + (BuiltInRegistries.CREATIVE_MODE_TAB.getKey(creativeTab.get()).getPath()), translation);
    }

    protected void addMob(Supplier<? extends EntityType<?>> entityType, String name) {
        this.add(entityType.get(), name);
        this.add("item." + LostWorlds.MODID + "." + getEntityId(entityType.get()) + "_spawn_egg", name + " Spawn Egg");
    }

    protected void addWoodGroup(Supplier<LeavesBlock> leaves, Supplier<Block> log, Supplier<Block> wood, Supplier<Block> strippedLog, Supplier<Block> strippedWood, Supplier<Block> planks, Supplier<StairBlock> stairs, Supplier<SlabBlock> slab, Supplier<FenceBlock> fence, Supplier<FenceGateBlock> fenceGate, Supplier<DoorBlock> door, Supplier<TrapDoorBlock> trapdoor, Supplier<PressurePlateBlock> pressurePlate, Supplier<ButtonBlock> button, Supplier<StandingSignBlock> sign, Supplier<WallSignBlock> wallSign, Supplier<CeilingHangingSignBlock> hangingSign, Supplier<WallHangingSignBlock> wallHangingSign, Supplier<Item> itemSign, Supplier<Item> itemHangingSign, String name) {
//        this.addBlock(sapling, name + " Sapling");
        this.addBlock(leaves, name + " Leaves");
        this.addBlock(log, name + " Log");
        this.addBlock(wood, name + " Wood");
        this.addBlock(strippedLog, "Stripped " + name + " Log");
        this.addBlock(strippedWood, "Stripped " + name + " Wood");
        this.addBlock(planks, name + " Planks");
        this.addBlock(stairs, name + " Stairs");
        this.addBlock(slab, name + " Slab");
        this.addBlock(fence, name + " Fence");
        this.addBlock(fenceGate, name + " Fence Gate");
        this.addBlock(door, name + " Door");
        this.addBlock(trapdoor, name + " Trapdoor");
        this.addBlock(pressurePlate, name + " Pressure Plate");
        this.addBlock(button, name + " Button");
//        this.addBlock(sign, name + " Sign");
//        this.addBlock(wallSign, name + " Wall Sign");
//        this.addBlock(hangingSign, name + " Hanging Sign");
//        this.addBlock(wallHangingSign, name + " Wall Hanging Sign");
        this.addItem(itemSign, name + " Sign");
        this.addItem(itemHangingSign, name + " Hanging Sign");
    }
}
