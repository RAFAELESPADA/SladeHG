package me.VideoSRC.tempos;

import java.text.DecimalFormat;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import me.VideoSRC.Main;
import me.VideoSRC.comandos.CMDArena;
import me.VideoSRC.eventos.TitleAPI;
import me.VideoSRC.feasteminifeast.BonusFeast;
import me.VideoSRC.feasteminifeast.FeastManager;
import me.VideoSRC.feasteminifeast.MiniFeast;
import me.VideoSRC.feasteminifeast.MiniFeast2;
import me.VideoSRC.outros.ChecarVitoria;
import me.VideoSRC.pontos.SistemaPontos;

public class EmJogo {
	private static Integer shed_id = null;

	public static void Checar() {
		ChecarVitoria.verificaWin();
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			public void run() {
			}
		}, 600L);
	}

	public static void Iniciar(int Contagem) {
		
		Main.Andamento = Contagem;
		shed_id = Integer
				.valueOf(Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.instance, new Runnable() {
					public void run() {
						Main.Andamento += 1;
						if (Main.Andamento == 300) {
							MiniFeast.announceFeast();
						}
						if (Main.Andamento == 500) {
							MiniFeast2.announceFeast();
						}
						if (Main.Andamento == 700) {
							FeastManager.announceFeast(Integer.valueOf(5));
						}
						if (Main.Andamento == 760) {
							FeastManager.announceFeast(Integer.valueOf(4));
						}
						if (Main.Andamento == 820) {
							FeastManager.announceFeast(Integer.valueOf(3));
						}
						if (Main.Andamento == 880) {
							FeastManager.announceFeast(Integer.valueOf(2));
						}
						if (Main.Andamento == 940) {
							FeastManager.announceFeast(Integer.valueOf(1));
						}
						if (Main.Andamento == 1000) {
							DecimalFormat df = new DecimalFormat("##.#");
							Bukkit.broadcastMessage("§eO Feast nascera nas coordenadas §f"
									+ df.format(FeastManager.mainBlock.getLocation().getX()) + "§7,§f "
									+ df.format(FeastManager.mainBlock.getLocation().getY()) + "§7,§f "
									+ df.format(FeastManager.mainBlock.getLocation().getZ()) + "§7 em §f5 §7segundos!");
						}
						if (Main.Andamento == 1001) {
							DecimalFormat df = new DecimalFormat("##.#");
							Bukkit.broadcastMessage("§eO Feast nascera nas coordenadas §f"
									+ df.format(FeastManager.mainBlock.getLocation().getX()) + "§7,§f "
									+ df.format(FeastManager.mainBlock.getLocation().getY()) + "§7,§f "
									+ df.format(FeastManager.mainBlock.getLocation().getZ()) + "§7 em §f4 §7segundos!");
						}
						if (Main.Andamento == 1002) {
							DecimalFormat df = new DecimalFormat("##.#");
							Bukkit.broadcastMessage("§eO Feast nascera nas coordenadas §f"
									+ df.format(FeastManager.mainBlock.getLocation().getX()) + "§7,§f "
									+ df.format(FeastManager.mainBlock.getLocation().getY()) + "§7,§f "
									+ df.format(FeastManager.mainBlock.getLocation().getZ()) + "§7 em §f3 §7segundos!");
						}
						if (Main.Andamento == 1003) {
							DecimalFormat df = new DecimalFormat("##.#");
							Bukkit.broadcastMessage("§eO Feast nascera nas coordenadas §f"
									+ df.format(FeastManager.mainBlock.getLocation().getX()) + "§7,§f "
									+ df.format(FeastManager.mainBlock.getLocation().getY()) + "§7,§f "
									+ df.format(FeastManager.mainBlock.getLocation().getZ()) + "§7 em §f2 §7segundos!");
						}
						if (Main.Andamento == 1004) {
							DecimalFormat df = new DecimalFormat("##.#");
							Bukkit.broadcastMessage("§eO Feast nascera nas coordenadas §f"
									+ df.format(FeastManager.mainBlock.getLocation().getX()) + "§7,§f "
									+ df.format(FeastManager.mainBlock.getLocation().getY()) + "§7,§f "
									+ df.format(FeastManager.mainBlock.getLocation().getZ()) + "§7 em §f1 §7segundo!");
						}
						if (Main.Andamento == 1005) {
							FeastManager.spawnFeast();
							  for (Player p1 : Bukkit.getOnlinePlayers()) {
				    	        	p1.playSound(p1.getLocation(), Sound.CHEST_OPEN, 10.0f, 1f);
				    	        	TitleAPI.sendTitle(p1, 20, 60 , 20,  "", "§eO FEAST NASCEU!");
				    	        }
						}
						if (Main.Andamento == 1200) {
							BonusFeast.announceFeast(Integer.valueOf(1));
							BonusFeast.spawnFeast();
						}
						if (Main.Andamento == 1600) {
							MiniFeast.announceFeast();
						}
						if (Main.Andamento == 1700) {
							MiniFeast2.announceFeast();
						}
						if (Main.Andamento == 2400) {
							CMDArena.criarAreaBatle();
							  for (Player p1 : Bukkit.getOnlinePlayers()) {
				    	        	p1.playSound(p1.getLocation(), Sound.ENDERDRAGON_GROWL, 10.0f, 1f);
				    	        	TitleAPI.sendTitle(p1, 20, 60 , 20,  "", "§eARENA FINAL GERADA!");
				    	        }
							Bukkit.broadcastMessage("§eArena final gerada!");
						}
						if (Main.Andamento == 3000) {
							Bukkit.shutdown();
						
					
						Bukkit.getPluginManager().callEvent(new Segundos());
					}
					}}, 0L, 20L));
				}
	


	public static void cancel() {
		if (shed_id != null) {
			Bukkit.getServer().getScheduler().cancelTask(shed_id.intValue());
			shed_id = null;
		}
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


	
}
