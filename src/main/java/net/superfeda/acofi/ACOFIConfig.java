package net.superfeda.acofi;

import java.util.List;

import net.neoforged.neoforge.common.ModConfigSpec;

public class ACOFIConfig {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    public static final ModConfigSpec SPEC;

    public static final ModConfigSpec.DoubleValue FIERY_UPGRADE_TEMPLATE_CHANCE;
    public static final ModConfigSpec.ConfigValue<List<? extends String>> TARGET_LOOT_TABLES;

    static {
        BUILDER.push("ACOFI Config");

        FIERY_UPGRADE_TEMPLATE_CHANCE = BUILDER
                .comment("Upgrade template spawn chance. (0.2 = 20%)")
                .defineInRange("upgrade_template_spawn_chance", 0.2, 0.0, 1.0);

        TARGET_LOOT_TABLES = BUILDER
                .comment("List of loot table IDs where the upgrade template will spawn.", "Default: [\"twilightforest:darktower_cache\", \"twilightforest:darktower_key\"]")
                .defineListAllowEmpty(
                        List.of("target_tables"),
                        () -> List.of("twilightforest:darktower_cache", "twilightforest:darktower_key"),
                        obj -> obj instanceof String
                );

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
