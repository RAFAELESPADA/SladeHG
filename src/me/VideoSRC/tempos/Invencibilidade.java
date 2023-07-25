package me.VideoSRC.tempos;

import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import me.VideoSRC.Main;
import me.VideoSRC.outros.ChecarVitoria;
import me.VideoSRC.pontos.SistemaPontos;

public class Invencibilidade {
	private static Integer shed_id;

	public static Scoreboard getScoreBoard() {
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard board = manager.getNewScoreboard();
		return board;
	}

	public static void resetScoreboard(Player p) {
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		p.setScoreboard(manager.getNewScoreboard());
	}

	public static String Rank(Player p) {

		double a = SistemaPontos.MostrarDinheiroPlayer(p);
		if (a <= 500.0D) {
			return "§7Bronze";
		}
		if (a <= 1500.0D) {
			return "§6Ouro";
		}
		if (a <= 2500.0D) {
			return "§fPlatina";
		}
		if (a <= 3500.0D) {
			return "§bDiamante";
		}
		if (a <= 5000.0D) {
			return "§cRuby";
		}
		return "§cRuby";
	}

	public Invencibilidade() {
		shed_id = Integer
				.valueOf(Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.instance, new Runnable() {
					public void run() {
						if (Main.TimerInvencibilidade.intValue() > 0) {
							Main.TimerInvencibilidade--;
							if (((Main.TimerInvencibilidade.intValue() >= 10 ? 1 : 0)
									& (Main.TimerInvencibilidade.intValue() % 10 == 0 ? 1 : 0)) != 0) {
								if ((Main.PreInvencibilidade) && (Main.TimerInvencibilidade.intValue() == 60)) {
									((World) Bukkit.getServer().getWorlds().get(0)).setDifficulty(Difficulty.PEACEFUL);
									Bukkit.broadcastMessage("§eTermina em: §c01:00");
								}
								if ((Main.PreInvencibilidade) && (Main.TimerInvencibilidade.intValue() == 30)) {
									Bukkit.broadcastMessage("§eTermina em: §c00:30");
								}
								if ((Main.PreInvencibilidade) && (Main.TimerInvencibilidade.intValue() == 10)) {
									Bukkit.broadcastMessage("§eTermina em: §c00:10");
								}
							} else if ((Main.PreInvencibilidade) && (Main.TimerInvencibilidade.intValue() < 6)) {
								Bukkit.broadcastMessage("§eTermina em: §c"
										+ StringTimer.TimerGame(Integer.valueOf(Main.TimerInvencibilidade.intValue())));
								for (Player pl : Bukkit.getOnlinePlayers()) {
									pl.playSound(pl.getLocation(), Sound.CLICK, 1.0F, 1.0F);
								}
							}
						}	else {
							EmJogo.Iniciar(120);
							Invencibilidade.cancel();
							Bukkit.broadcastMessage("§eTerminou!");
							Bukkit.getServer().getWorld("world").setDifficulty(Difficulty.NORMAL);
							Main.PreInvencibilidade = false;
							Main.Partida = true;
							ChecarVitoria.verificaWin();
							for (Player pl : Bukkit.getOnlinePlayers()) {

								pl.playSound(pl.getLocation(), Sound.ANVIL_LAND, 30.0F, 30.0F);
							}
							if (Main.Partida) {
								new EmJogo();
								Invencibilidade.cancel();
							}
							}
						
					}
					}, 0L, 20L));
	}

	public static void cancel() {
		if (shed_id != null) {
			Bukkit.getServer().getScheduler().cancelTask(shed_id.intValue());
			shed_id = null;
		}
	
	}
}