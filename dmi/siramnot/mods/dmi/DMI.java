package siramnot.mods.dmi;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.Configuration;
import siramnot.mods.dmi.blocks.DMIBlocks;
import siramnot.mods.dmi.blocks.tileeents.TileEntityWorkStationBlock;
import siramnot.mods.dmi.blocks.tileeents.TileEntityWorkStationBlockEntity;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Dominus ex Magica et Industria mod. (C) Copyright SirAmNot 2013 This classes
 * are Devteam-exclusive.
 * 
 * @author SirAmNot
 */
@Mod(modid = DMI.MOD_ID, name = DMI.MOD_NAM, version = DMI.MOD_VER)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class DMI {

	// Static constants and variables
	public static final String MOD_ID = "DMI";
	public static final String MOD_NAM = "Dominus ex Magica et Industria";
	public static final String MOD_VER = "[1.6.2] 0.0.1A";

	public static final CreativeTabs TAB_CREATIVE = new CreativeTabs("DMI");

	public static boolean doWorldGen;
	public static boolean doOreGen;

	// Blocks
	public static TileEntityWorkStationBlock machine_workStation;

	// Pre Init. Config here.
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		Configuration cfg = new Configuration(e.getSuggestedConfigurationFile()); // Creates configuration file, if doesn't already exist
		// Load config
		cfg.load();

		doWorldGen = cfg.get(Configuration.CATEGORY_GENERAL, "DMI_worldGen", true).getBoolean(true);
		doOreGen = cfg.get(cfg.CATEGORY_GENERAL, "DMI_oreGen", true).getBoolean(true);
		
		

		if (!doWorldGen)
			doOreGen = false;

		// Save config
		cfg.save();
	}

	// Load the mod itself. Prepare for spam -.-"
	@EventHandler
	public void load(FMLInitializationEvent e) {
		// Create custom creative tab for items
		machine_workStation = new TileEntityWorkStationBlock(1402);
		GameRegistry.registerTileEntity(TileEntityWorkStationBlockEntity.class, "tileEntiyWorkStationBlock");
		
		DMIBlocks.load();
	}

	// Post init.
	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
	}
}