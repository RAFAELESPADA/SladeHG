package me.VideoSRC.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.VideoSRC.Main;
import me.VideoSRC.api.Strings;

public class CMDDano implements Listener, CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(Strings.server);
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("dano")) {
			if (args.length == 0) {
				p.sendMessage("§eUse /dano on ou /dano off");
				return true;
			}
			if ((p.hasPermission("kombo.cmd.report")) && (args[0].equalsIgnoreCase("on"))) {
				p.sendMessage("§eO dano foi ativado!");
				Main.Dano = false;
			}
			if ((p.hasPermission("kombo.cmd.report")) && (args[0].equalsIgnoreCase("off"))) {
				p.sendMessage("§cDANO§7, O dano foi desativado!");
				Main.Dano = true;
			}
			return true;
		}
		return false;
	}
}
