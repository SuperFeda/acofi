package net.superfeda.acofi;

import com.mojang.serialization.MapCodec;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.world.item.Item;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;

import twilightforest.init.TFCreativeTabs;

@Mod(ACOFI.MOD_ID)
public class ACOFI {
    public static final String MOD_ID = "acofi";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MOD_ID);
    public static final DeferredHolder<Item, FieryUpgradeTemplate> FIERY_UPGRADE_TEMPLATE = ITEMS.registerItem("fiery_upgrade_template", properties -> new FieryUpgradeTemplate());

    public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS =
            DeferredRegister.create(NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, MOD_ID);
    public static final DeferredHolder<MapCodec<? extends IGlobalLootModifier>, MapCodec<AddTemplateLootModifier>> ADD_TEMPLATE_MODIFIER =
            LOOT_MODIFIER_SERIALIZERS.register("add_fiery_upgrade_template", () -> AddTemplateLootModifier.CODEC.get());

    public ACOFI(IEventBus modEventBus, ModContainer modContainer) {
        modContainer.registerConfig(ModConfig.Type.COMMON, ACOFIConfig.SPEC);

        modEventBus.addListener(this::addCreative);

        ITEMS.register(modEventBus);
        LOOT_MODIFIER_SERIALIZERS.register(modEventBus);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == TFCreativeTabs.EQUIPMENT.getKey()) {
            event.accept(FIERY_UPGRADE_TEMPLATE.get());
        }
    }
}
