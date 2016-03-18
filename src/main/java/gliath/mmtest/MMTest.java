package gliath.mmtest;

import gliath.mmtest.initializer.ModBlocks;
import gliath.mmtest.initializer.ModItems;
import gliath.mmtest.proxy.CommonProxy;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
public class MMTest {
    @Mod.Instance(Reference.MOD_ID)
    public static MMTest instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    @EventHandler
    public void init(FMLPreInitializationEvent event) {
        ModBlocks.init();
        ModBlocks.register();
        ModItems.init();
        ModItems.register();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.registerRenders();
    }

    @EventHandler
    public void init(FMLPostInitializationEvent event) {
        // some example code
        System.out.println("STONE BLOCK >> " + Blocks.stone.getUnlocalizedName());
    }
}