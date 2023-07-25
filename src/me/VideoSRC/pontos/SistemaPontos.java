package me.VideoSRC.pontos;

import org.bukkit.entity.Player;

import me.VideoSRC.utils.MyConfig;
import me.VideoSRC.utils.MyConfigManager;

public class SistemaPontos {
	public static MyConfig money;
	public static int defaultmoney = 0;
	public static MyConfigManager manager;
	public static String MostrarDinheiroPlayer;

	public static void CarregarDinheiro() {
		money = manager.getNewConfig("pontos.yml");
	}

	public static int MostrarDinheiroPlayer(Player p) {
		return money.getInt(p.getUniqueId().toString());
	}

	public static void darDinheiro(Player p, int quantia) {
		money.set(p.getUniqueId().toString(), Integer.valueOf(MostrarDinheiroPlayer(p) + quantia));
		money.saveConfig();
	}

	public static void TirarDinheiro(Player p, int quantia) {
		money.set(p.getUniqueId().toString(), Integer.valueOf(MostrarDinheiroPlayer(p) - quantia));
		money.saveConfig();
	}

	public static boolean contains(String name) {
		return false;
	}
}
