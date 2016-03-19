package gliath.mmtest.proxy;

import gliath.mmtest.initializer.ModBlocks;
import gliath.mmtest.initializer.ModItems;

public class ClientProxy extends CommonProxy {
    @Override
    public void registerRenders() {
        ModItems.registerRenders();
        ModBlocks.registerRenders();
    }
}