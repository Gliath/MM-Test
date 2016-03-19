package gliath.mmtest.tools;

import gliath.mmtest.MMTest;
import net.minecraft.item.ItemAxe;

public class ModAxe extends ItemAxe {
    public ModAxe(ToolMaterial material) {
        super(material);
        this.setUnlocalizedName("mod_axe");
        this.setCreativeTab(MMTest.tabMod);
    }
}