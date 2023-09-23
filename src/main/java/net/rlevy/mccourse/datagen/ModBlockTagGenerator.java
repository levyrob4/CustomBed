package net.rlevy.mccourse.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.rlevy.mccourse.MCCourseMod;
import net.rlevy.mccourse.block.ModBlocks;
import net.rlevy.mccourse.util.ModTags;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                                @Nullable ExistingFileHelper existingFileHelper) {
        super(output,lookupProvider, MCCourseMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        //add custom metal detector tag
        this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES).add(ModBlocks.ALEXANDRITE_ORE.get()).addTag(Tags.Blocks.ORES);


    }

    @Override
    public String getName(){
        return "Block Tags";
    }
}
