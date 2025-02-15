package net.sen.lostworlds.datagen.language;

import net.minecraft.data.PackOutput;

import java.util.List;

public class EnUsLanguageProvider extends LanguageDefenition {

    public EnUsLanguageProvider(PackOutput output) {
        super(output, "en_us");
    }

    @Override
    List<String> blockNames() {
        return List.of(
        );
    }

    @Override
    List<String> itemNames() {
        return List.of(
        );
    }

    @Override
    List<String> entityTypeNames() {
        return List.of(
        );
    }
}
