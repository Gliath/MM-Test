package gliath.mmtest.tools;

import gliath.mmtest.MMTest;
import net.minecraft.item.ItemArmor;

public class ModBoots extends ItemArmor {
    public ModBoots(ArmorMaterial material) {
        super(material, 4, 3);
        this.setUnlocalizedName("mod_boots");
        this.setCreativeTab(MMTest.tabMod);
    }
}