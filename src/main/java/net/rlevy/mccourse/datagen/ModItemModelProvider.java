package net.rlevy.mccourse.datagen;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import net.rlevy.mccourse.MCCourseMod;
import net.rlevy.mccourse.block.ModBlocks;
import net.rlevy.mccourse.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MCCourseMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.ALEXANDRITE);
        simpleItem(ModItems.RAW_ALEXANDRITE);

        //simpleItem(ModItems.KOHLRABI);
        simpleItem(ModItems.METAL_DETECTOR);
        //simpleItem(ModItems.PEAT_BRICK);

        //for the custom table model helper method
        complexBlock(ModBlocks.TEST_TABLE.get());

        //custom bed
//        complexBlock(ModBlocks.CUSTOM_BED_BLOCK.get());
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(MCCourseMod.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder complexBlock(Block block){
        return withExistingParent(ForgeRegistries.BLOCKS.getKey(block).getPath(),
                new ResourceLocation(MCCourseMod.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(block).getPath()));
    }
}