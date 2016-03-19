package gliath.mmtest.tools;

import gliath.mmtest.MMTest;
import net.minecraft.item.ItemSword;

public class ModSword extends ItemSword {
    public ModSword(ToolMaterial material) {
        super(material);
        this.setUnlocalizedName("mod_sword");
        this.setCreativeTab(MMTest.tabMod);
    }
}