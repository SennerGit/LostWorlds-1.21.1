package net.sen.lostworlds.datagen.loot_tables;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.WritableRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.util.ProblemReporter;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends LootTableProvider {
    public ModLootTableProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
        super(output, ModLootTables.allBuiltin(), List.of(
                new SubProviderEntry(ModBlockLootTables::new, LootContextParamSets.BLOCK),
                new SubProviderEntry(ModEntityLootTables::new, LootContextParamSets.ENTITY),
                new SubProviderEntry(ModChestLootTables::new, LootContextParamSets.CHEST),
                new SubProviderEntry(ModArchaeologyLootTables::new, LootContextParamSets.ARCHAEOLOGY),
                new SubProviderEntry(ModFishingLootTables::new, LootContextParamSets.FISHING),
                new SubProviderEntry(ModShearingLootTables::new, LootContextParamSets.SHEARING),
                new SubProviderEntry(ModSpecialLootTables::new, LootContextParamSets.EMPTY)
        ), provider);
    }

    @Override
    protected void validate(WritableRegistry<LootTable> writableregistry, ValidationContext validationcontext, ProblemReporter.Collector problemreporter$collector) {

    }
}
