package net.rlevy.mccourse.block;

import net.minecraft.world.item.BedItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.rlevy.mccourse.MCCourseMod;
import net.rlevy.mccourse.block.custom.CustomBedBlock;
import net.rlevy.mccourse.block.custom.TestModelBlock;
import net.rlevy.mccourse.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


import java.util.function.Supplier;

import static net.minecraft.world.item.Items.SNOW_BLOCK;
import static net.minecraft.world.item.Items.registerBlock;

public class ModBlocks {

    //for registering a block
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MCCourseMod.MOD_ID);

    //creates block and adds properties to it.
    //public static final RegistryObject<Block> ALEXANDRITE_BLOCK = registerBlock("alexandrite_block",
           // () -> new Block(BlockBehaviour.Properties.copy(Blocks.GRASS)));

    //*****note you can also custom define all properties of the block by using
    public static final RegistryObject<Block> ALEXANDRITE_BLOCK = registerBlock("alexandrite_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.BELL).
                    strength(2.0F, 3.0F).sound(SoundType.CHAIN)));
    //another block register
    public static final RegistryObject<Block> RAW_ALEXANDRITE_BLOCK = registerBlock("raw_alexandrite_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.BASS).
                    strength(2.0F, 3.0F).sound(SoundType.AZALEA).requiresCorrectToolForDrops()));


    public static final RegistryObject<Block> ALEXANDRITE_ORE = registerBlock("alexandrite_ore",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.FLUTE).
                    strength(2.0F, 3.0F).sound(SoundType.GLASS)));


    //register the testmodel furniture block
   public static final RegistryObject<Block> TEST_TABLE = registerBlock("test_table",
           () -> new TestModelBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

   //register the custom bed block
//    public static final RegistryObject<Block> CUSTOM_BED_BLOCK = registerBlock("custom_bed_block",
//    () -> new CustomBedBlock(DyeColor.WHITE, BlockBehaviour.Properties.copy(Blocks.COAL_BLOCK)));



    //register block items more efficiently
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name,toReturn);
        return toReturn;
    }

    //for registering a block item, you need an item
  private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {

        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
