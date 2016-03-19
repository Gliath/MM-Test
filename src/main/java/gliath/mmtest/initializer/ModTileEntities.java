package gliath.mmtest.initializer;

import gliath.mmtest.tileentity.ModTileEntity;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModTileEntities {
    public static void register() {
        GameRegistry.registerTileEntity(ModTileEntity.class, "mmtestModTileEntity");
    }
}
