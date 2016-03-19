package gliath.mmtest.tools;

import gliath.mmtest.MMTest;
import net.minecraft.item.ItemArmor;

public class ModChestplate extends ItemArmor {
    public ModChestplate(ArmorMaterial material) {
        super(material, 4, 1);
        this.setUnlocalizedName("mod_chestplate");
        this.setCreativeTab(MMTest.tabMod);
    }
}