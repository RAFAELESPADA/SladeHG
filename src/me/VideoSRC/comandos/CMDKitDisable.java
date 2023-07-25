package me.VideoSRC.comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import me.VideoSRC.api.Habilidade;
import me.VideoSRC.api.Strings;

public final class CMDKitDisable implements Listener, CommandExecutor {
	public static boolean KitsDisable;

	@EventHandler
	public void NoKitDisable(PlayerCommandPreprocessEvent event) {
		Player p = event.getPlayer();
		if ((KitsDisable) && (event.getMessage().toLowerCase().startsWith("/kit "))) {
			p.sendMessage("§eos kits foram desativados!");
			event.setCancelled(true);
			return;
		}
	}

	public final boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(Strings.server);
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("togglekit")) {
			if (p.hasPermission("kombo.cmd.report")) {
				if (args.length == 0) {
					sender.sendMessage("§eUse: /togglekit <jogador>");
					return true;
				}
				Player target = Bukkit.getServer().getPlayer(args[0]);
				if (target == null) {
					p.sendMessage("§eJogador offline ou invalido!");
					return true;
				}
				if (args[0].equalsIgnoreCase(target.getName())) {
					Habilidade.removeAbility(target);
					p.sendMessage("§eVoce desativou o kit de: §e" + target.getName());
					target.sendMessage("§eSeu kit foi desativado!");
				}
			} else {
				p.sendMessage(Strings.perm);
				return true;
			}
		}
		return true;
	}
}
