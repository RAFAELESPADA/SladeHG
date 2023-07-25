package me.VideoSRC.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.VideoSRC.Main;

public class CMDTell implements Listener, CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("Comandos apenas no servidor!");
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("tell")) {
			if (Main.Watch.contains(p.getName())) {
				p.sendMessage("§eVoce nao pode falar!");
				return true;
			}
			if (args.length == 0) {
				p.sendMessage("§eUse /tell <jogador> <menssagem>");
			} else if (args.length == 1) {
				p.sendMessage("§eUse /tell <jogador> <menssagem>");
			} else if (args.length > 1) {
				String message = "";
				for (int i = 1; i < args.length; i++) {
					message = message + args[i] + " ";
				}
				Player targetPlayer = p.getServer().getPlayer(args[0]);
				if (targetPlayer == null) {
					p.sendMessage("§eJogador offline ou invalido!");
				} else {
					targetPlayer.sendMessage("§cTELL§7, " + p.getDisplayName() + "§7: " + message);
					p.sendMessage("§cTELL§7, " + targetPlayer.getDisplayName() + "§7: " + message);
				}
			}
			return true;
		}
		return true;
	}
}
