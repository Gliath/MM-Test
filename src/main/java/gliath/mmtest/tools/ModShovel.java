package gliath.mmtest.tools;

import gliath.mmtest.MMTest;
import net.minecraft.item.ItemSpade;

public class ModShovel extends ItemSpade {

    public ModShovel(ToolMaterial material) {
        super(material);
        this.setUnlocalizedName("mod_shovel");
        this.setCreativeTab(MMTest.tabMod);
    }
}