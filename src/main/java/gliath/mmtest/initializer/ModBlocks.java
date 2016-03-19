package gliath.mmtest.initializer;

import gliath.mmtest.Reference;
import gliath.mmtest.blocks.ModBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {

    public static Block mod_block;

    public static void init() {
        mod_block = new ModBlock();
    }

    public static void register() {
        GameRegistry.registerBlock(mod_block, mod_block.getUnlocalizedName().substring(5));
    }

    public static void registerRenders() {
        registerRender(mod_block);
    }

    public static void registerRender(Block block) {
        Item item = Item.getItemFromBlock(block);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }
}