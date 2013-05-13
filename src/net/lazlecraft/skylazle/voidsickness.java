package net.lazlecraft.skylazle;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

//idea from http://forums.bukkit.org/threads/void-sickness.104709/

public class voidsickness implements Listener {
	public static SkyLazle plugin;
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
	    Player p = e.getPlayer();
	    if (p.getLocation().getBlockY() < 0) {
	      spawn(p);
	      p.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 1200, 0));
	      p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 2400, 0));
	      p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 1200, 1));
	      p.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 2400, 1));
	      p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 600, 0));
	      p.sendMessage(ChatColor.DARK_PURPLE + "You fell of the void and has been punished!!");
	    }
	}
	
	public void spawn(Player p) {
    	Location SpawnLoc = new Location(Bukkit.getServer().getWorld(
    			plugin.getConfig().getString("vWorld")), 
    			plugin.getConfig().getDouble("vX"), 
    			plugin.getConfig().getDouble("vY"), 
    			plugin.getConfig().getDouble("vz"), 
    			plugin.getConfig().getInt("vYaw"),
    			plugin.getConfig().getInt("vPitch"));
    	p.teleport(SpawnLoc);
  }
}
