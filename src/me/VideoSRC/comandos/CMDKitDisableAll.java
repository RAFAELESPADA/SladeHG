package me.VideoSRC.comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.VideoSRC.api.Habilidade;
import me.VideoSRC.api.Strings;

public class CMDKitDisableAll implements Listener, CommandExecutor {
	public final boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(Strings.server);
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("toggle")) {
			if (p.hasPermission("kombo.cmd.report")) {
				if (args.length == 0) {
					sender.sendMessage("§eUse: /toggle <true-false>");
					return true;
				}
				if (args[0].equalsIgnoreCase("true")) {
					sender.sendMessage("§eVoce ativou os kits!");
					Bukkit.broadcastMessage("§eOs Kits foram ativados!");
					CMDKitDisable.KitsDisable = false;
				} else if (args[0].equalsIgnoreCase("false")) {
					sender.sendMessage("§eVoce desativou os kits!");
					Bukkit.broadcastMessage("§eOs Kits foram ativados!");
					CMDKitDisable.KitsDisable = true;
					for (Player Jogadores : Bukkit.getOnlinePlayers()) {
						Habilidade.removeAbility(Jogadores);
					}
				} else {
					sender.sendMessage("§eUse: /toggle <true-false>");
				}
			} else {
				p.sendMessage(Strings.perm);
				return true;
			}
		}
		return true;
	}
}
