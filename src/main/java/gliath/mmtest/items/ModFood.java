package gliath.mmtest.items;

import gliath.mmtest.MMTest;
import net.minecraft.item.ItemFood;

public class ModFood extends ItemFood {

    public ModFood() {
        super(10, 0.5f, false);
        this.setUnlocalizedName("mod_food");
        this.setCreativeTab(MMTest.tabMod);
    }
}