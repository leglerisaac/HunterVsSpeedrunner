package me.Leglord.HunterVsSpeedrunner;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Data {
	private static Map<UUID, Boolean> trackers = new HashMap<>();
	
	public static boolean getHunter(UUID uuid){
		return trackers.get(uuid);
	}
	
	public static void setHunter(UUID uuid, boolean tracking) {
		trackers.put(uuid, tracking);
	}
	
}
