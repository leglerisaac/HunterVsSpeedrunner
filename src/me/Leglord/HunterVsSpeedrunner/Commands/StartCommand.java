package me.Leglord.HunterVsSpeedrunner.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.Leglord.HunterVsSpeedrunner.Main;

public class StartCommand implements CommandExecutor {
		
	@SuppressWarnings("unused")
	private Main plugin;
	boolean exists = false;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player) sender;
		int argnum = args.length;
		Player target = Bukkit.getPlayerExact(args[0]);
		ItemStack compass = new ItemStack(Material.COMPASS);
	
		if (!(sender instanceof Player)) {
			sender.sendMessage("This command is for players only");
			return true;	
		}else if (argnum == 0){
			p.sendMessage(ChatColor.RED + "Incorrect usage. Please insert player to track.");
			return false;
		}else if (argnum > 1){
			p.sendMessage(ChatColor.RED + "Incorrect usage. Can only track 1 player at a time.");
			return false;
		}else if (argnum == 1){
			Location location = target.getLocation();
			for(ItemStack item : p.getInventory().getContents()){
				if(item.isSimilar(compass)){
					exists = true;
				}
			}
			p.getInventory().addItem(compass);
			p.setCompassTarget(location);
			p.sendMessage("compass is now tracking " + target);
			while (exists = true) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
				location = target.getLocation();
				p.setCompassTarget(location);
			}	
			return true;
		} else {
			p.sendMessage("You can't use this command");
		}
	return false;
	}
}

