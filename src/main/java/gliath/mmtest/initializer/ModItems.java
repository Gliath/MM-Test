package gliath.mmtest.initializer;

import gliath.mmtest.Reference;
import gliath.mmtest.items.ModCookedFood;
import gliath.mmtest.items.ModFood;
import gliath.mmtest.items.ModItem;
import gliath.mmtest.tools.*;
import gliath.mmtest.utility.ModLogger;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {

    public static Item mod_item;
    public static Item mod_food;
    public static Item mod_cookedfood;
    public static Item mod_sword;
    public static Item mod_pickaxe;
    public static Item mod_axe;
    public static Item mod_shovel;
    public static Item mod_hoe;
    public static Item mod_helmet;
    public static Item mod_chestplate;
    public static Item mod_leggings;
    public static Item mod_boots;

    public static final Item.ToolMaterial mod_toolmaterial = EnumHelper.addToolMaterial("mod_toolmaterial", Integer.MAX_VALUE, Integer.MAX_VALUE, Float.MAX_VALUE, 12.8f, 128);
    public static final ItemArmor.ArmorMaterial mod_armormaterial = EnumHelper.addArmorMaterial("mod_armormaterial", "mmtest:mod", Integer.MAX_VALUE, new int[]{30, 80, 60, 30}, 128);

    public static void init() {
        mod_item = new ModItem();

        mod_food = new ModFood();
        mod_cookedfood = new ModCookedFood();

        mod_sword = new ModSword(mod_toolmaterial);
        mod_pickaxe = new ModPickaxe(mod_toolmaterial);
        mod_axe = new ModAxe(mod_toolmaterial);
        mod_shovel = new ModShovel(mod_toolmaterial);
        mod_hoe = new ModHoe(mod_toolmaterial);

        mod_helmet = new ModHelmet(mod_armormaterial);
        mod_chestplate = new ModChestplate(mod_armormaterial);
        mod_leggings = new ModLeggings(mod_armormaterial);
        mod_boots = new ModBoots(mod_armormaterial);
    }

    public static void register() {
        GameRegistry.registerItem(mod_item, mod_item.getUnlocalizedName().substring(5)); // substring removes "tile." in unlocalizedname

        GameRegistry.registerItem(mod_food, mod_food.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(mod_cookedfood, mod_cookedfood.getUnlocalizedName().substring(5));

        GameRegistry.registerItem(mod_sword, mod_sword.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(mod_pickaxe, mod_pickaxe.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(mod_axe, mod_axe.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(mod_shovel, mod_shovel.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(mod_hoe, mod_hoe.getUnlocalizedName().substring(5));

        GameRegistry.registerItem(mod_helmet, mod_helmet.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(mod_chestplate, mod_chestplate.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(mod_leggings, mod_leggings.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(mod_boots, mod_boots.getUnlocalizedName().substring(5));

    }

    public static void registerRenders() {
        registerRender(mod_item);

        registerRender(mod_food);
        registerRender(mod_cookedfood);

        registerRender(mod_sword);
        registerRender(mod_pickaxe);
        registerRender(mod_axe);
        registerRender(mod_shovel);
        registerRender(mod_hoe);

        registerRender(mod_helmet);
        registerRender(mod_chestplate);
        registerRender(mod_leggings);
        registerRender(mod_boots);
    }

    private static void registerRender(Item item) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }
}