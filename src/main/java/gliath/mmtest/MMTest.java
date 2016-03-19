package gliath.mmtest;

import gliath.mmtest.creativetab.ModTab;
import gliath.mmtest.initializer.ModBlocks;
import gliath.mmtest.initializer.ModItems;
import gliath.mmtest.initializer.ModRecipes;
import gliath.mmtest.initializer.ModTileEntities;
import gliath.mmtest.proxy.CommonProxy;
import gliath.mmtest.utility.ModLogger;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
public class MMTest {
    @Mod.Instance(Reference.MOD_ID)
    public static MMTest instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    public static final ModTab tabMod = new ModTab("tabMod");

    @EventHandler
    public void init(FMLPreInitializationEvent event) {
        ModLogger.info("PreInitialization");
        ModBlocks.init();
        ModBlocks.register();
        ModItems.init();
        ModItems.register();
        ModTileEntities.register();
        GameRegistry.registerWorldGenerator(new ModGeneration(), 0);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        ModLogger.info("Initialization!");
        proxy.registerRenders();
        ModRecipes.init();
    }

    @EventHandler
    public void init(FMLPostInitializationEvent event) {
        ModLogger.info("PostInitialization");

    }
}