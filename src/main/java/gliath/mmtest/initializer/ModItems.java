package gliath.mmtest.initializer;

import gliath.mmtest.MMTest;
import gliath.mmtest.Reference;
import gliath.mmtest.items.ModCookedFood;
import gliath.mmtest.items.ModFood;
import gliath.mmtest.items.ModItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {

    public static Item mod_item;
    public static Item mod_food;
    public static Item mod_cookedfood;

    public static void init() {
        mod_item = new ModItem().setUnlocalizedName("mod_item").setCreativeTab(MMTest.tabMod);
        mod_food = new ModFood(10, 0.5f, false).setUnlocalizedName("mod_food").setCreativeTab(MMTest.tabMod);
        mod_cookedfood = new ModCookedFood(20, 1.0f, true).setUnlocalizedName("mod_cookedfood").setCreativeTab(MMTest.tabMod);
    }

    public static void register() {
        GameRegistry.registerItem(mod_item, mod_item.getUnlocalizedName().substring(5)); // substring removes "tile." in unlocalizedname
        GameRegistry.registerItem(mod_food, mod_food.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(mod_cookedfood, mod_cookedfood.getUnlocalizedName().substring(5));
    }

    public static void registerRenders() {
        registerRender(mod_item);
        registerRender(mod_food);
        registerRender(mod_cookedfood);
    }

    private static void registerRender(Item item) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }
}
