package com.tistory.illysig.JumpingBlock;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.Event;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.getspout.spoutapi.inventory.SpoutItemStack;
import org.getspout.spoutapi.material.CustomBlock;

public class JumpingBlockPlugin extends JavaPlugin{
	
	public static CustomBlock jumpingBlock;
	
	Logger log = Logger.getLogger("Minecraft");

	private final JumpingBlockPlayerListener pl = new JumpingBlockPlayerListener(this);

	@Override
	public void onDisable() {
		log.info("[JumpingBlock] Disable!");
		
	}

	@Override
	public void onEnable() {
		log.info("[JumpingBlock] Enable!");
		jumpingBlock = new JumpingBlock(this);
		
		PluginManager pm = this.getServer().getPluginManager();
		Bukkit.getServer().addRecipe(new FurnaceRecipe(new SpoutItemStack(jumpingBlock, 1), Material.CLAY));
		pm.registerEvent(Event.Type.PLAYER_MOVE, pl, Event.Priority.Normal, this);
		
		
		
		
		
		
		
	}
}
