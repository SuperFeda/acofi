package net.superfeda.acofi;

import net.minecraftforge.common.ForgeConfigSpec;

import java.util.List;

public class ACOFIConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.DoubleValue FIERY_UPGRADE_TEMPLATE_CHANCE;
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> TARGET_LOOT_TABLES;

    static {
        BUILDER.push("ACOFI Config");

        FIERY_UPGRADE_TEMPLATE_CHANCE = BUILDER
                .comment("Upgrade template spawn chance. (0.2 = 20%)", "Default: 0.2")
                .defineInRange("upgrade_template_spawn_chance", 0.2, 0.0, 1.0);

        TARGET_LOOT_TABLES = BUILDER
                .comment("List of loot table IDs where the upgrade template will spawn.", "Default: [\"twilightforest:chests/darktower_cache\", \"twilightforest:chests/darktower_key\"]")
                .defineListAllowEmpty(
                        List.of("target_tables"),
                        () -> List.of("twilightforest:chests/darktower_cache", "twilightforest:chests/darktower_key"),
                        obj -> obj instanceof String
                );

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
