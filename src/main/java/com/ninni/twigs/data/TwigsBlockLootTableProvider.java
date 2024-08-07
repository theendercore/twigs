package com.ninni.twigs.data;

import com.ninni.twigs.TwigsProperties;
import com.ninni.twigs.block.enums.SiltPotBlock;
import com.ninni.twigs.registry.TwigsBlocks;
import com.ninni.twigs.registry.TwigsItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.util.ProblemReporter;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class TwigsBlockLootTableProvider extends LootTableProvider {
    public TwigsBlockLootTableProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, Set.of(), List.of(new SubProviderEntry(TwigsBlockLootSubProvider::new, LootContextParamSets.BLOCK)), lookupProvider);
    }

    @Override
    protected void validate(Registry<LootTable> registry, ValidationContext context, ProblemReporter reporter) {
        registry.forEach(table -> table.validate(context));
    }

    public static class TwigsBlockLootSubProvider extends BlockLootSubProvider {
        public TwigsBlockLootSubProvider(HolderLookup.Provider provider) {
            super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
        }

        @Override
        public void generate() {
            for (Block block : TwigsDataGenerator.getModBlocks()) {
                switch (block) {
                    case SlabBlock slabBlock -> add(slabBlock, this::createSlabItemTable);
                    case SiltPotBlock siltPotBlock -> add(siltPotBlock, this::createNameableBlockEntityTable);
                    case MultifaceBlock multifaceBlock -> add(multifaceBlock, this::createCustomMultifaceBlockDrops);
                    default -> dropSelf(block);
                }
            }

            dropPottedContents(TwigsBlocks.POTTED_AZALEA_FLOWERS.get());
            add(TwigsBlocks.SILT.get(), (block) -> createSingleItemTableWithSilkTouch(block, TwigsItems.SILT_BALL.get(), ConstantValue.exactly(4)));


            add(TwigsBlocks.BAMBOO_LEAVES.get(), (block) -> LootTable.lootTable()
                    .withPool(LootPool.lootPool().when(LootItemEntityPropertyCondition.entityPresent(LootContext.EntityTarget.THIS))
                            .add(LootItem.lootTableItem(TwigsBlocks.BAMBOO_LEAVES.get())
                                    .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2)).when(getLeafState(block, 2)))
                                    .apply(SetItemCountFunction.setCount(ConstantValue.exactly(3)).when(getLeafState(block, 3)))
                                    .apply(SetItemCountFunction.setCount(ConstantValue.exactly(4)).when(getLeafState(block, 4)))
                            )
                    )
            );
        }

        private LootItemBlockStatePropertyCondition.Builder getLeafState(Block block, int layer) {
            return LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(TwigsProperties.LAYERS_1_4, layer));
        }

        public LootTable.Builder createCustomMultifaceBlockDrops(Block block) {
            return LootTable.lootTable().withPool(LootPool.lootPool().add(
                            this.applyExplosionDecay(block,
                                    LootItem.lootTableItem(block).apply(Direction.values(), direction -> SetItemCountFunction.setCount(ConstantValue.exactly(1.0f), true).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(MultifaceBlock.getFaceProperty(direction), true))))).apply(SetItemCountFunction.setCount(ConstantValue.exactly(-1.0f), true)
                            )
                    )
            );
        }
    }
}