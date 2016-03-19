package gliath.mmtest.items;

import gliath.mmtest.MMTest;
import net.minecraft.item.ItemFood;

public class ModCookedFood extends ItemFood {

    public ModCookedFood() {
        super(20, 1.0f, true);
        this.setUnlocalizedName("mod_cookedfood");
        this.setCreativeTab(MMTest.tabMod);
    }
}