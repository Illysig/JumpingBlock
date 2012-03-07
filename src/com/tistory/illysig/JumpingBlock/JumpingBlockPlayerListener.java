package com.tistory.illysig.JumpingBlock;

import java.util.logging.Logger;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.getspout.spoutapi.block.SpoutBlock;
import org.getspout.spoutapi.player.SpoutPlayer;

public class JumpingBlockPlayerListener extends PlayerListener{
	
	Logger log = Logger.getLogger("Minecraft");
	public JumpingBlockPlugin plugin;
	
	  public JumpingBlockPlayerListener(JumpingBlockPlugin instance) {
		    plugin = instance;
		}

	  @Override 
	  public void onPlayerMove(PlayerMoveEvent event) {
		  SpoutPlayer sp = (SpoutPlayer) event.getPlayer();
		  
		  Block below = event.getPlayer().getWorld().getBlockAt(event.getPlayer().getLocation().getBlockX(), event.getPlayer().getLocation().getBlockY() - 1, event.getPlayer().getLocation().getBlockZ());
	        SpoutBlock sb = (SpoutBlock) below;
	        
	    	if (sb.getCustomBlock() != null) {
	    		if (sb.getCustomBlock() instanceof JumpingBlock) {
	    			sp.setNoDamageTicks(5);
	    			sp.setAirSpeedMultiplier(1);
	    			sp.setWalkingMultiplier(1);
	    			sp.setJumpingMultiplier(3);
	    		} else {
	    			sp.setAirSpeedMultiplier(1);
	    			sp.setWalkingMultiplier(1);
	    			sp.setJumpingMultiplier(1);
	    		}
	    	} else {
	    		if (below.getType() != Material.AIR) {
	    			sp.setAirSpeedMultiplier(1);
	    			sp.setWalkingMultiplier(1);
	    			sp.setJumpingMultiplier(1);
	    		}
	    	}

	  }
}
