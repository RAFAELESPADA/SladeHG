package me.VideoSRC.comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.VideoSRC.Main;
import me.VideoSRC.api.Strings;
import me.VideoSRC.tempos.StringTimer;

public class CMDTimer implements CommandExecutor {
	public static boolean isNumeric(String str) {
		try {
			Integer.parseInt(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("Comandos apenas no servidor!");
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("tpall")) {
			if (sender.hasPermission("kombo.cmd.report")) {
				p.sendMessage("§eVoce teleportou todos os players!");
				for (Player pl : Bukkit.getOnlinePlayers()) {
					pl.teleport(p.getLocation());
				}
			} else {
				p.sendMessage(Strings.perm);
				return true;
			}
		}
		if (cmd.getName().equalsIgnoreCase("invencibilidade")) {
			if (p.hasPermission("kombo.cmd.report")) {
				if (args.length > 0) {
					if (isNumeric(args[0])) {
						int newTime = Integer.parseInt(args[0]);
						if ((newTime == 0) && (Main.TimerInvencibilidade.intValue() != 0)) {
							Main.IniciarPartida();
						} else {
							Main.TimerInvencibilidade = Integer.valueOf(newTime);
						}
						Bukkit.broadcastMessage(
								"§eTempo alterado para: " + StringTimer.TimerGame(Integer.valueOf(newTime)));
					} else {
						sender.sendMessage("§eVoce nao pode alterar para tanto tempo!");
					}
				} else {
					sender.sendMessage("§eUse /inv time");
				}
			} else {
				p.sendMessage(Strings.perm);
				return true;
			}
		}
		if (cmd.getName().equalsIgnoreCase("tempo")) {
			if (p.hasPermission("kombo.cmd.report")) {
				if (args.length > 0) {
					if (isNumeric(args[0])) {
						int newTime = Integer.parseInt(args[0]);
						if ((newTime == 0) && (Main.Andamento != 0)) {
							Main.IniciarPartida();
						} else {
							Main.Andamento = newTime;
						}
						Bukkit.broadcastMessage(
								"§eTempo alterado para: " + StringTimer.TimerGame(Integer.valueOf(newTime)));
					} else {
						sender.sendMessage("§eVoce nao pode alterar para tanto tempo!");
					}
				} else {
					sender.sendMessage("§eUse /tempo time");
				}
			} else {
				p.sendMessage(Strings.perm);
				return true;
			}
		}
		if (cmd.getName().equalsIgnoreCase("pregame")) {
			if (p.hasPermission("kombo.cmd.report")) {
				if (args.length > 0) {
					if (isNumeric(args[0])) {
						int newTime = Integer.parseInt(args[0]);
						if ((newTime == 0) && (Main.TimerIniciando.intValue() != 0)) {
							Main.IniciarPartida();
						} else {
							Main.TimerIniciando = Integer.valueOf(newTime);
						}
						Bukkit.broadcastMessage(
								"§eTempo alterado para: " + StringTimer.TimerGame(Integer.valueOf(newTime)));
					} else {
						sender.sendMessage("§eVoce nao pode alterar para tanto tempo!");
					}
				} else {
					sender.sendMessage("§eUse /pregame time");
				}
			} else {
				p.sendMessage(Strings.perm);
				return true;
			}
		}
		return false;
	}
}
