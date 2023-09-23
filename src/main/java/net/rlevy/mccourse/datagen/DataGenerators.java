package net.rlevy.mccourse.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.rlevy.mccourse.MCCourseMod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = MCCourseMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        //this is where you add recipes to data generator for execution
        //recipes get saved to the "src/generated/resource/data folder NOT the main...>resources folder
        generator.addProvider(event.includeServer(), new ModRecipeProvider(packOutput));

        ///this adds the JSON files for the loot tables. Loot tables are the treasures that the blocks
        //leave behind after breaking them.
        generator.addProvider(event.includeServer(),ModLootTableProvider.create(packOutput));

        //this adds the JSON files for the mod block tags
        generator.addProvider(event.includeServer(),new ModBlockTagGenerator(packOutput, lookupProvider,
                existingFileHelper));

        //adds the item model provider that adds the JSON files for that items
        generator.addProvider(event.includeServer(),new ModItemModelProvider(packOutput, existingFileHelper));

        ///adds the JSON file for the mod blocks
        generator.addProvider(event.includeClient(), new ModBlockStateProvider(packOutput, existingFileHelper));


    }
    
}
