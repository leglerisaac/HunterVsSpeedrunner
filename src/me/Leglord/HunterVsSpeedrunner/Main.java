package me.Leglord.HunterVsSpeedrunner;

import org.bukkit.plugin.java.JavaPlugin;
import me.Leglord.HunterVsSpeedrunner.Commands.StartCommand;
import me.Leglord.HunterVsSpeedrunner.Commands.StopCommand;

public class Main extends JavaPlugin {
		@Override
		public void onEnable() {
			getCommand("compass").setExecutor(new StartCommand());
			getCommand("untrack").setExecutor(new StopCommand());
			
		}
		
		@Override
		public void onDisable() {
			
		}
}