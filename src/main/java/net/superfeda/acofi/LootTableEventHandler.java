package net.superfeda.acofi;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = ACOFI.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class LootTableEventHandler {

    @SubscribeEvent
    public static void onLootTableLoad(LootTableLoadEvent event) {
        List<? extends String> lootTables = ACOFIConfig.TARGET_LOOT_TABLES.get();
        float chance = ACOFIConfig.FIERY_UPGRADE_TEMPLATE_CHANCE.get().floatValue();

        for (String lootTableID : lootTables) {
            ResourceLocation targetTable = ResourceLocation.tryParse(lootTableID);

            if (targetTable == null) {
                continue;
            }

            if (event.getName().equals(targetTable)) {
                LootPool fieryUpgradeTemplatePool = LootPool.lootPool()
                        .name("fiery_upgrade_template_pool")
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(ACOFI.FIERY_UPGRADE_TEMPLATE.get()))
                        .when(LootItemRandomChanceCondition.randomChance(chance))
                        .build();

                event.getTable().addPool(fieryUpgradeTemplatePool);

                ACOFI.LOGGER.info(String.format("Pool fiery_upgrade_template_pool added to %s; Chance: %s", targetTable, chance));
            }
        }
    }
}
