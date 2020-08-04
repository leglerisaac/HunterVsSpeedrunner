package me.Leglord.HunterVsSpeedrunner.Commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.Leglord.HunterVsSpeedrunner.Data;
import me.Leglord.HunterVsSpeedrunner.Main;

public class StopCommand implements CommandExecutor {
	
	@SuppressWarnings("unused")
	private Main plugin;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("This command is for players only");
			return true;
		}
		Player p = (Player) sender;
		
		if(p.hasPermission("untrack.use")){
			Data.setHunter(p.getUniqueId(), false);
			for(ItemStack item : p.getInventory().getContents()){
				if(item == new ItemStack(Material.COMPASS)){
					p.getInventory().setItem(1, new ItemStack(Material.AIR));
				}	
			}
			return true;
		} else {
			p.sendMessage("You can't use this command");
		}
		return false;
	}
}
