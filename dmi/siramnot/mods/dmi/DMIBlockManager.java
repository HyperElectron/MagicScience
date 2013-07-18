package siramnot.mods.dmi;

import siramnot.mods.dmi.blocks.BlockAqueousCrystalOre;
import siramnot.mods.dmi.blocks.BlockLiquidator;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
/**
 * Dominus ex Magica et Industria mod. (C) Copyright SirAmNot 2013
 * 
 * 
 * @author SirAmNot, JiffyJay
 * 
 */
public class DMIBlockManager {
	
	//Blocks
	public static Block aqueousOre;
	public static Block liquidator;
	
	
	// Load the blocks
	public static void load() {
		aqueousOre = new BlockAqueousCrystalOre(600);
		liquidator = new BlockLiquidator(601);
		
		languageRegistry();
		gameRegistry();
		
	}

	// Register the blocks, gives them mod-unique names
	private static void gameRegistry() {
		GameRegistry.registerBlock(aqueousOre, "Aqueous Ore");
		GameRegistry.registerBlock(liquidator, "Liquidator");
		
	}

	// Name the blocks in-game
	private static void languageRegistry() {
		LanguageRegistry.addName(aqueousOre, "Aqueous Ore");
		LanguageRegistry.addName(liquidator, "Liquidator");
	}
}
