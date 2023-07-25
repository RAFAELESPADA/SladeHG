package me.VideoSRC.eventos;

import java.text.SimpleDateFormat;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.server.ServerListPingEvent;

import me.VideoSRC.Main;
import me.VideoSRC.api.Strings;
import me.VideoSRC.tempos.StringTimer;

public class IniciandoEvt implements Listener {
	public static boolean Teleportar;

	@EventHandler
	public void onTeleport(PlayerTeleportEvent e) {
		if (Teleportar) {
			e.setCancelled(true);
		}
	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void onPing(ServerListPingEvent e) {
		if (Main.PreGame) {
			e.setMotd(Strings.nomeserver + " §7- §eHardcoreGames!" + "\n§aTorneio iniciando em: §7[§a"
					+ StringTimer.TimerGame(Main.TimerIniciando) + "§7]");
		}
		if (Main.PreInvencibilidade) {
			e.setMotd(Strings.nomeserver + " §7- §eHardcoreGames!" + "\n§aTorneio na invencibilidade: §7[§e"
					+ StringTimer.TimerGame(Main.TimerInvencibilidade) + "§7]");
		}
		if (Main.Partida) {
			int millis = Main.Andamento * 1000;
			SimpleDateFormat df = new SimpleDateFormat("mm:ss");
			String time = df.format(Integer.valueOf(millis));
			e.setMotd(Strings.nomeserver + " §7- §eHardcoreGames!" + "\n§aTorneio em andamento: §7[§c" + time + "§7]");
		}
		if (Main.Finalizando) {
			e.setMotd(Strings.nomeserver + " §7- §eHardcoreGames!" + "\n§aTorneio terminou, §bReiniciando!");
		}
	}
}
