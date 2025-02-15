package net.sen.lostworlds.datagen.loot_tables;

import com.google.common.collect.Sets;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.Collections;
import java.util.Locale;
import java.util.Set;

import static net.sen.lostworlds.common.utils.ResourceTools.*;

public class ModLootTables {
    private static final Set<ResourceKey<LootTable>> LOOT_TABLES = Sets.newHashSet();
    private static final Set<ResourceKey<LootTable>> IMMUTABLE_LOCATIONS = Collections.unmodifiableSet(LOOT_TABLES);

    public final ResourceLocation lootTable;
    private ModLootTables(String path) {
        this.lootTable = getModPath(String.format("chests/%s", path).toLowerCase(Locale.ROOT));
    }

    public static Set<ResourceKey<LootTable>> allBuiltin() {
        return IMMUTABLE_LOCATIONS;
    }
}