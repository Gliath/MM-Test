package gliath.mmtest.tools;

import gliath.mmtest.MMTest;
import net.minecraft.item.ItemArmor;

public class ModHelmet extends ItemArmor {
    public ModHelmet(ArmorMaterial material) {
        super(material, 4, 0);
        this.setUnlocalizedName("mod_helmet");
        this.setCreativeTab(MMTest.tabMod);
    }


}