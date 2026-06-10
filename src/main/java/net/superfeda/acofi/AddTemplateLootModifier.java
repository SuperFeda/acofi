package net.superfeda.acofi;

import com.google.common.base.Suppliers;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;

import net.neoforged.neoforge.common.loot.LootModifier;

import java.util.function.Supplier;

public class AddTemplateLootModifier extends LootModifier {
    public static final Supplier<MapCodec<AddTemplateLootModifier>> CODEC = Suppliers.memoize(() ->
            RecordCodecBuilder.mapCodec(inst -> codecStart(inst).apply(inst, AddTemplateLootModifier::new))
    );

    public AddTemplateLootModifier(LootItemCondition[] conditionsIn) {
        super(conditionsIn);
    }

    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        ResourceLocation tableId = context.getQueriedLootTableId();
        if (tableId == null) {
            return generatedLoot;
        }

        String currentTableId = tableId.toString();

        if (!ACOFIConfig.TARGET_LOOT_TABLES.get().contains(currentTableId)) {
            return generatedLoot;
        }

        float chance = ACOFIConfig.FIERY_UPGRADE_TEMPLATE_CHANCE.get().floatValue();
        if (context.getRandom().nextFloat() >= chance) {
            return generatedLoot;
        }

        generatedLoot.add(new ItemStack(ACOFI.FIERY_UPGRADE_TEMPLATE.get(), 1));
        ACOFI.LOGGER.info("Added fiery_upgrade_template to loot table: {}", currentTableId);

        return generatedLoot;
    }

    @Override
    public MapCodec<? extends LootModifier> codec() {
        return CODEC.get();
    }
}
