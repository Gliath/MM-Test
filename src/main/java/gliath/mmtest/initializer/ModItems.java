package gliath.mmtest.initializer;

import gliath.mmtest.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {

    public static Item mod_item;

    public static void init() {
        mod_item = new Item().setUnlocalizedName("mod_item");
    }

    public static void register() {
        GameRegistry.registerItem(mod_item, mod_item.getUnlocalizedName().substring(5)); // substring removes "tile." in unlocalizedname
    }

    public static void registerRenders() {
        registerRender(mod_item);
    }

    public static void registerRender(Item item) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }
}
