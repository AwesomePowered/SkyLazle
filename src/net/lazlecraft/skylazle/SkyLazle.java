package net.lazlecraft.skylazle;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class SkyLazle extends JavaPlugin {
	
	public void onEnable() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new voidsickness(), this);
		getConfig().options().copyDefaults(true);
		this.saveConfig();
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("You may not use any SkyLazle commands, Console!");
            return false;
        }    
        
    	Player p = (Player)sender;
        if ((commandLabel.equalsIgnoreCase("setvsspawn")) && (sender.hasPermission("skylazle.set.vsspawn.doesnt.really.freaking.matter.what.i.put.in.here.trolololollololo"))) {
        	Location l = p.getLocation();
        	getConfig().set("vX", Double.valueOf(l.getBlockX() + 0.5));
        	getConfig().set("vY", Double.valueOf(l.getBlockY() + 0.5));
        	getConfig().set("vZ", Double.valueOf(l.getBlockZ() + 0.5));
        	getConfig().set("vYaw", Float.valueOf(l.getYaw()));
        	getConfig().set("vPitch", Float.valueOf(l.getPitch()));
        	getConfig().set("vWorld", String.valueOf(l.getWorld().getName()));
        	this.saveConfig();
        	this.reloadConfig();
        	p.sendMessage(ChatColor.GREEN + "Void Spawn set!");
        }
        return false;
	}
}
