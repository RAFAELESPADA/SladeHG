package me.VideoSRC.comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.VideoSRC.api.EspectadoresManager;
import me.VideoSRC.api.Strings;

public final class CMDSpec implements Listener, CommandExecutor {
	public final boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if ((cmd.getName().equalsIgnoreCase("specs")) && (p.hasPermission("kombo.cmd.report"))) {
			if (args.length == 0) {
				sender.sendMessage("§eUse: /specs on - off");
				return true;
			}
			int j;
			if (args[0].equalsIgnoreCase("on")) {
				sender.sendMessage("§eTodos ficaram visiveis!");
				for (Player Invisiveis : Bukkit.getOnlinePlayers()) {
					p.showPlayer(Invisiveis);
				}
			} else if (args[0].equalsIgnoreCase("off")) {
				sender.sendMessage("§eTodos ficaram invisiveis!");
				for (Player p2 : EspectadoresManager.DamageMobs) {
					p.hidePlayer(p2);
				}
			} else {
				sender.sendMessage("§eUse: /specs on-off");
			}
		} else {
			p.sendMessage(Strings.perm);
			return true;
		}
		return true;
	}
}
