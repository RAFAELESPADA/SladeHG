package me.VideoSRC.comandos;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class CMDListener implements Listener {
	public static String Vencedor = "";
	public static ArrayList<Player> chat = new ArrayList();

	public static String getShortStr(String name) {
		if (name.length() == 16) {
			String shorts = name.substring(0, name.length() - 5);
			return shorts;
		}
		if (name.length() == 15) {
			String shorts = name.substring(0, name.length() - 4);
			return shorts;
		}
		return name;
	}

	public static String getMod(String name) {
		if (name.length() == 16) {
			String shorts = name.substring(0, name.length() - 4);
			return shorts;
		}
		if (name.length() == 15) {
			String shorts = name.substring(0, name.length() - 3);
			return shorts;
		}
		if (name.length() == 14) {
			String shorts = name.substring(0, name.length() - 2);
			return shorts;
		}
		if (name.length() == 13) {
			String shorts = name.substring(0, name.length() - 1);
			return shorts;
		}
		return name;
	}

	private static HashMap<String, Integer> kills = new HashMap();
	private static HashMap<String, Integer> ks = new HashMap();

	public static int getKs(Player p) {
		return ks.containsKey(p.getName()) ? ((Integer) ks.get(p.getName())).intValue() : 0;
	}

	public static void setStreaks(Player p) {
		ks.put(p.getName(),
				Integer.valueOf(ks.containsKey(p.getName()) ? ((Integer) ks.get(p.getName())).intValue() + 1 : 1));
	}

	public static int getKills(Player p) {
		return kills.containsKey(p.getName()) ? ((Integer) kills.get(p.getName())).intValue() : 0;
	}

	public static void setKills(Player p) {
		kills.put(p.getName(), Integer
				.valueOf(kills.containsKey(p.getName()) ? ((Integer) kills.get(p.getName())).intValue() + 1 : 1));
	}

	@EventHandler
	public void Death(PlayerDeathEvent e) {
		Player p = e.getEntity().getPlayer();
		if ((p.getKiller() != null) && ((p.getKiller() instanceof Player))) {
			Player k = p.getKiller();
			setStreaks(k);
		}
	}

	@EventHandler
	public void onMaxBuildBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		Block b = e.getBlock();
		if (b.getLocation().getY() >= 300.0D) {
			p.sendMessage("�eVoce esta no limite de altura!");
			e.setCancelled(true);
			return;
		}
	}

	@EventHandler
	public void onMaxBuildPlace(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		Block b = e.getBlock();
		if (b.getLocation().getY() >= 300.0D) {
			p.sendMessage("�eVoce esta no limite de altura!");
			e.setCancelled(true);
			return;
		}
	}
}
