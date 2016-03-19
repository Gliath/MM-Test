package gliath.mmtest.tools;

import gliath.mmtest.MMTest;
import net.minecraft.item.ItemHoe;

public class ModHoe extends ItemHoe {
    public ModHoe(ToolMaterial material) {
        super(material);
        this.setUnlocalizedName("mod_hoe");
        this.setCreativeTab(MMTest.tabMod);
    }
}