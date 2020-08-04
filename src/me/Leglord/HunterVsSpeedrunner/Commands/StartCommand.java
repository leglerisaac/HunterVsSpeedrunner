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
import me.Leglord.HunterVsSpeedrunner.Data;

public class StartCommand extends StopCommand implements CommandExecutor {

	@SuppressWarnings("unused")
	private Main plugin;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player) sender;
		Data.setHunter(p.getUniqueId(), true);
		int argnum = args.length;
		Player target = Bukkit.getPlayerExact(args[0]);
		ItemStack compass = new ItemStack(Material.COMPASS);
		boolean exists = false;
		
		if (!(sender instanceof Player)) {
			sender.sendMessage("This command is for players only");
			return true;	
		}else if (argnum == 0){
			p.sendMessage(ChatColor.RED + "Incorrect usage. Please insert player to track.");
			return false;
		}else if (argnum > 1){
			p.sendMessage(ChatColor.RED + "Incorrect usage. Can only track 1 player at a time.");
			return false;
		}else if (target == p){
			p.sendMessage(ChatColor.RED + "Incorrect usage. Please enter a player that is not yourself.");
			return false;
		}else if (target == null){
			p.sendMessage(ChatColor.RED + "Incorrect usage. Please enter a player that is online.");
			return false;
		}else if (argnum == 1){
			for(ItemStack item : p.getInventory().getContents()){
				if(item == compass){
					exists = true;
				}
			}
			if (exists == false){ 
				p.getInventory().addItem(compass);
			}
			
			p.sendMessage("compass is now tracking " + args[0]);
			new Thread (new Runnable() {
				public void run() {
					while (Data.getHunter(p.getUniqueId())) {
						if (p.getLocation().getWorld().getName().endsWith("world")) {
							try {
								Thread.sleep(50);
							} catch (InterruptedException e) {
							}
							Location location = target.getLocation();
							p.setCompassTarget(location); 
						}
					}
				}
			}).start();
			return true;
		} else {
			p.sendMessage("You can't use this command");
		}
	return false;
	}
}
