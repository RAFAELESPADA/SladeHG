package me.VideoSRC.comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.VideoSRC.api.Strings;

public class CMDInv implements Listener, CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(Strings.server);
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("inv")) {
			if (sender.hasPermission("kombo.cmd.report")) {
				sender.sendMessage("§eUse: /inv <jogador>");
				if (args.length > 0) {
					Player player = Bukkit.getPlayer(args[0]);
					if (player == null) {
						sender.sendMessage("§eJogador offline ou invalido!");
						return true;
					}
					sender.sendMessage("§eVoce esta vendo o inventario de: §c" + player.getName());
					p.openInventory(player.getInventory());
				}
			} else {
				p.sendMessage(Strings.perm);
			}
			return true;
		}
		return true;
	}
}
