package net.rlevy.mccourse.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import net.rlevy.mccourse.block.ModBlocks;
import net.rlevy.mccourse.item.ModItems;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables(){
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate(){
        this.dropSelf(ModBlocks.ALEXANDRITE_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_ALEXANDRITE_BLOCK.get());

        //this add the drops to each block I think.
        this.add(ModBlocks.ALEXANDRITE_ORE.get(),
                block ->  createOreDrop(ModBlocks.ALEXANDRITE_ORE.get(),
                        ModItems.RAW_ALEXANDRITE.get()));

        //adds the loot if you break the table you can get it back
        this.dropSelf(ModBlocks.TEST_TABLE.get());

        //custom bed
//        this.dropSelf(ModBlocks.CUSTOM_BED_BLOCK.get());

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
