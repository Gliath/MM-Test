package gliath.mmtest.initializer;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class ModRecipes {
    public static void init() {
        // Shaped Recipe (has to be that shape)
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.mod_block), "M", "S", 'M', ModItems.mod_item, 'S', Blocks.stone);

        // Shapeless Recipe (has to have the items, not the shape)
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.mod_item, 4), Items.ender_pearl, Items.redstone);

        //OreDictionary Shaped Recipe (has to be that shape, but the items need to be of the same oreDictionary)
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.mod_block, 8), "M M", " R ", "M M", 'M', ModItems.mod_item, 'R', Blocks.redstone_block));

        //OreDictionary Shapeless Recipe (has to have the items of the same oreDictionary, not the shape)
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.mod_item, 32), Items.ghast_tear, Items.blaze_powder));

        // Adds smelting recipe
        GameRegistry.addSmelting(ModItems.mod_food, new ItemStack(ModItems.mod_cookedfood), 1.0f);
    }
}