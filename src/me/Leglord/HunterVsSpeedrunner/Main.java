package me.Leglord.HunterVsSpeedrunner;

import org.bukkit.plugin.java.JavaPlugin;
import me.Leglord.HunterVsSpeedrunner.Commands.StartCommand;

public class Main extends JavaPlugin {
		@Override
		public void onEnable() {
			getCommand("compass").setExecutor(new StartCommand());
			
		}
		
		@Override
		public void onDisable() {
			
		}
}