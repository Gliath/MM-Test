package gliath.mmtest.tools;

import gliath.mmtest.MMTest;
import net.minecraft.item.ItemArmor;

public class ModLeggings extends ItemArmor {
    public ModLeggings(ArmorMaterial material) {
        super(material, 4, 2);
        this.setUnlocalizedName("mod_leggings");
        this.setCreativeTab(MMTest.tabMod);
    }
}