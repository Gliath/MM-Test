package gliath.mmtest.tools;

import gliath.mmtest.MMTest;
import net.minecraft.item.ItemPickaxe;

public class ModPickaxe extends ItemPickaxe {

    public ModPickaxe(ToolMaterial material) {
        super(material);
        this.setUnlocalizedName("mod_pickaxe");
        this.setCreativeTab(MMTest.tabMod);
    }
}