package gliath.mmtest.CreativeTab;

import gliath.mmtest.initializer.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ModTab extends CreativeTabs {

    public ModTab(String label) {
        super(label);
        this.setBackgroundImageName("mod.png");
    }

    @Override
    public Item getTabIconItem() {
        return ModItems.mod_item;
    }
}
