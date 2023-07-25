package me.VideoSRC.tempos;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import me.VideoSRC.Main;
import me.VideoSRC.eventos.TitleAPI;
import me.VideoSRC.pontos.SistemaPontos;

public class Iniciando {
	public static Scoreboard getScoreBoard() {
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard board = manager.getNewScoreboard();
		return board;
	}


	public static Integer ReIniciando = Integer.valueOf(300);
	public static ArrayList<String> RelogPreGame = new ArrayList();
	private static Integer shed_id = null;
	public Objective o;

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

	public Iniciando() {
		if (Main.PreGame) {
			shed_id = Integer
					.valueOf(Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.instance, new Runnable() {
						public void run() {
							Objective o;
							if (Main.TimerIniciando.intValue() > 0) {
								if (((Main.TimerIniciando.intValue() >= 30 ? 1 : 0)
										& (Main.TimerIniciando.intValue() % 30 == 0 ? 1 : 0)) != 0) {
									for (Player pl : Bukkit.getOnlinePlayers()) {
										pl.setHealth(20.0D);
										pl.setFoodLevel(20);
										pl.setExp(0.0F);
										pl.setRemainingAir(20);
									}
									if ((Main.PreGame) && (Main.TimerIniciando.intValue() == 300)) {
										Bukkit.broadcastMessage("§eTorneio iniciando em: §c05:00");
										  for (Player p1 : Bukkit.getOnlinePlayers()) {
							    	        	p1.playSound(p1.getLocation(), Sound.CLICK, 10.0f, 1f);
							    	        	TitleAPI.sendTitle(p1, 20, 40 , 20,  "", "§eTorneio iniciando em: §c"
														+ "05:00");
							    	        }
									}
									if ((Main.PreGame) && (Main.TimerIniciando.intValue() == 240)) {
										Bukkit.broadcastMessage("§eTorneio iniciando em: §c04:00");
										  for (Player p1 : Bukkit.getOnlinePlayers()) {
							    	        	p1.playSound(p1.getLocation(), Sound.CLICK, 10.0f, 1f);
							    	        	TitleAPI.sendTitle(p1, 20, 40 , 20,  "", "§eTorneio iniciando em: §c"
														+ "04:00");
							    	        }
									}
									if ((Main.PreGame) && (Main.TimerIniciando.intValue() == 180)) {
										Bukkit.broadcastMessage("§eTorneio iniciando em: §c03:00");
										  for (Player p1 : Bukkit.getOnlinePlayers()) {
							    	        	p1.playSound(p1.getLocation(), Sound.CLICK, 10.0f, 1f);
							    	        	TitleAPI.sendTitle(p1, 20, 40 , 20,  "", "§eTorneio iniciando em: §c"
														+ "03:00");
							    	        }
									}
									if ((Main.PreGame) && (Main.TimerIniciando.intValue() == 120)) {
										Bukkit.broadcastMessage("§eTorneio iniciando em: §c02:00");
										  for (Player p1 : Bukkit.getOnlinePlayers()) {
							    	        	p1.playSound(p1.getLocation(), Sound.CLICK, 10.0f, 1f);
							    	        	TitleAPI.sendTitle(p1, 20, 40 , 20,  "", "§eTorneio iniciando em: §c"
														+ "02:00");
							    	        }
									}
									if ((Main.PreGame) && (Main.TimerIniciando.intValue() == 60)) {
										Bukkit.broadcastMessage("§eTorneio iniciando em: §c01:00");
										  for (Player p1 : Bukkit.getOnlinePlayers()) {
							    	        	p1.playSound(p1.getLocation(), Sound.CLICK, 10.0f, 1f);
							    	        	TitleAPI.sendTitle(p1, 20, 40 , 20,  "", "§eTorneio iniciando em: §c"
														+ "01:00");
							    	        }
									}
									if ((Main.PreGame) && (Main.TimerIniciando.intValue() == 30)) {
										Bukkit.broadcastMessage("§eTorneio iniciando em: §c00:30");
										  for (Player p1 : Bukkit.getOnlinePlayers()) {
							    	        	p1.playSound(p1.getLocation(), Sound.CLICK, 10.0f, 1f);
							    	        	TitleAPI.sendTitle(p1, 20, 40 , 20,  "", "§eTorneio iniciando em: §c"
														+ "00:30");
							    	        }
									}
									if ((Main.PreGame) && (Main.TimerIniciando.intValue() == 10)) {
										Bukkit.broadcastMessage("§eTorneio iniciando em: §c00:10");
										
										  for (Player p1 : Bukkit.getOnlinePlayers()) {
							    	        	p1.playSound(p1.getLocation(), Sound.CLICK, 10.0f, 1f);
							    	        	TitleAPI.sendTitle(p1, 20, 40 , 20,  "", "§eTorneio iniciando em: §c"
														+ "00:10");  
							    	        }
										Player[] arrayOfPlayerq;
										for (Player pl : Bukkit.getOnlinePlayers()) {
											if (Main.Jogadores.contains(pl.getName())) {
												int x = 0;
												int y = 100;
												int z = 0;
												Location loc = new Location(pl.getWorld(), x, y, z);
												pl.teleport(loc);
												pl.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 120, 50));
												pl.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 120, 1000));
											}
										}
									}
								}
								if ((Main.PreGame) && (Main.TimerIniciando.intValue() < 10)) {
									Bukkit.broadcastMessage("§eTorneio iniciando em: §c"
											+ StringTimer.TimerGame(Integer.valueOf(Main.TimerIniciando.intValue())));
									for (Player pl : Bukkit.getOnlinePlayers()) {
										if (Main.Jogadores.contains(pl.getName())) {
											pl.setAllowFlight(false);
											pl.setFlying(false);
											  
								    	        	pl.playSound(pl.getLocation(), Sound.CLICK, 10.0f, 1f);
								    	       
											me.VideoSRC.kits.KangarooPreGame.Kangaroo = false;
											TitleAPI.sendTitle(pl, 20, 40 , 20,  "", "§eTorneio iniciando em: §c"
													+ StringTimer.TimerGame(Integer.valueOf(Main.TimerIniciando.intValue())));
											Iniciando.RelogPreGame.add(pl.getName());
											pl.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 120, 50));
											pl.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 120, 1000));
										}
									}
								}
								Main.TimerIniciando = Integer.valueOf(Main.TimerIniciando.intValue() - 1);
								if (Main.PreGame) {
									for (Player p : Bukkit.getOnlinePlayers()) {

										
										
									}
								}
							} else if ((Main.PreGame) && (Main.Jogadores.size() < Main.MinimoJogadores.intValue())) {
								Main.TimerIniciando = Integer.valueOf(Iniciando.ReIniciando.intValue());
								me.VideoSRC.eventos.IniciandoEvt.Teleportar = false;
								me.VideoSRC.kits.KangarooPreGame.Kangaroo = true;
								for (Player pl : Bukkit.getOnlinePlayers()) {
									if (Main.Jogadores.contains(pl.getName())) {
										for (PotionEffect effect : pl.getActivePotionEffects()) {
											pl.removePotionEffect(effect.getType());
										}
									}
								}
							} else {
								Main.IniciarPartida();
							}
						}
					}, 0L, 20L));
		}
	}

	public static void cancel() {
		if (shed_id != null) {
			Bukkit.getServer().getScheduler().cancelTask(shed_id.intValue());
			shed_id = null;
		}
	}


	 

}
	            	  
	           

	         

