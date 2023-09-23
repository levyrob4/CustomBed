package net.rlevy.mccourse.datagen;

import net.minecraftforge.client.model.generators.ModelFile;
import net.rlevy.mccourse.MCCourseMod;
import net.rlevy.mccourse.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MCCourseMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        //this generattes the JSON file for the modified block models and
        //modified block item JSON files
        blockWithItem(ModBlocks.ALEXANDRITE_BLOCK);
        blockWithItem(ModBlocks.RAW_ALEXANDRITE_BLOCK);

        blockWithItem(ModBlocks.ALEXANDRITE_ORE);
        //blockWithItem(ModBlocks.DEEPSLATE_ALEXANDRITE_ORE);
        //blockWithItem(ModBlocks.END_STONE_ALEXANDRITE_ORE);
        //blockWithItem(ModBlocks.NETHER_ALEXANDRITE_ORE);

        //blockWithItem(ModBlocks.SOUND_BLOCK);

        //this is for custom table model
        horizontalBlock(ModBlocks.TEST_TABLE.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/test_table")));

        //add custom bed
//        horizontalBlock(ModBlocks.CUSTOM_BED_BLOCK.get(),
//                new ModelFile.UncheckedModelFile(modLoc("block/test_table")));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
