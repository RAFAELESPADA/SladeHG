package me.VideoSRC.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.VideoSRC.Main;
import me.VideoSRC.api.Strings;
import me.VideoSRC.feasteminifeast.FeastManager;

public class CMDFeast implements Listener, CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(Strings.server);
			return true;
		}
		Player p = (Player) sender;
		if ((cmd.getName().equalsIgnoreCase("feast")) && (Main.Andamento >= 300)) {
			if (FeastManager.getMainBlock().getLocation() != null) {
			p.setCompassTarget(FeastManager.getMainBlock().getLocation());
			p.sendMessage("§eBussola apontando para o §aFeast!");
			} else {
				p.sendMessage("§cO Feast ainda não nasceu!");
			}
		} else {
			p.sendMessage("§eO Feast ainda nao foi anunciado!");
		}
		return true;
	}
}
