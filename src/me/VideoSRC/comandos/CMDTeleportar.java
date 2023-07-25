package me.VideoSRC.comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.VideoSRC.api.Strings;

public class CMDTeleportar implements CommandExecutor, Listener {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(Strings.server);
			return true;
		}
		Player player = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("tp")) {
			if (!player.hasPermission("kombo.cmd.report")) {
				player.sendMessage(Strings.perm);
				return true;
			}
			if (args.length == 0) {
				player.sendMessage("§eUse /tp <jogador> ou /s <jogador>");
				return true;
			}
			if (args.length == 1) {
				Player target = Bukkit.getPlayerExact(args[0]);
				if ((target == null) || (!(target instanceof Player))) {
					player.sendMessage("§eJogador offline ou invalido!");
					return true;
				}
				player.teleport(target);
				player.sendMessage("§eTeleportado para: §c" + target.getName());
				return true;
			}
			if (args.length > 1) {
				player.sendMessage("§eUse /tp <jogador> ou /s <jogador>");
				return true;
			}
		} else if (cmd.getName().equalsIgnoreCase("s")) {
			if (!player.hasPermission("tag.ajudante")) {
				player.sendMessage(Strings.perm);
				return true;
			}
			if (args.length == 0) {
				player.sendMessage("§eUse /tp <jogador> ou /s <jogador>");
				return true;
			}
			if (args.length == 1) {
				Player target = Bukkit.getPlayerExact(args[0]);
				if ((target == null) || (!(target instanceof Player))) {
					player.sendMessage("§eJogador offline ou invalido!");
					return true;
				}
				target.teleport(player);
				player.sendMessage("§eVoce teleportou §c" + target.getName() + "§7 para sua posicao!");
				return true;
			}
			if (args.length > 1) {
				player.sendMessage("§eUse /tp <jogador> ou /s <jogador>");
				return true;
			}
		}
		return false;
	}
}
