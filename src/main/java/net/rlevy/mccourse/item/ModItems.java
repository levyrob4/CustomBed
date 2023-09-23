package net.rlevy.mccourse.item;

import net.minecraft.client.resources.model.Material;
import net.minecraft.world.item.BedItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rlevy.mccourse.MCCourseMod;
import net.rlevy.mccourse.block.custom.CustomBedBlock;
import net.rlevy.mccourse.item.custom.CustomBedItem;
import net.rlevy.mccourse.item.custom.MetalDetectorItem;

public class ModItems {
    public  static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
            MCCourseMod.MOD_ID);

    //add an item
    //the item name HAS  TO MATCH THE assets.mccourse.models.item.alexandrite.json file name!
    public static final RegistryObject<Item> ALEXANDRITE = ITEMS.register("alexandrite",
            () -> new Item(new Properties()));
    public static final RegistryObject<Item> RAW_ALEXANDRITE = ITEMS.register("raw_alexandrite",
            () -> new Item(new Properties()));

    //add metal detector item
    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Properties().durability(512)));

    //add custom bed item
    //public static final RegistryObject<Item> CUSTOM_BED_ITEM = ITEMS.register("custom_bed",
     //       () -> new CustomBedItem(new CustomBedBlock(DyeColor.WHITE,
    //                new BlockBehaviour.Properties().destroyTime(100.0F))));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
