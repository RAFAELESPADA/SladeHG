package me.VideoSRC.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.VideoSRC.Main;
import me.VideoSRC.api.Habilidade;
import me.VideoSRC.api.Strings;
import me.VideoSRC.tempos.StringTimer;

public class CMDJogo implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(Strings.perm);
			return true;
		}
		Player p = (Player) sender;
		String KitName = Habilidade.NomeDoKit(Habilidade.getAbility(p));
		if (cmd.getName().equalsIgnoreCase("jogo") && Main.Partida) {
			p.sendMessage("§7Kills: §c" + CMDListener.getKs(p));
			p.sendMessage("§fTempo: §7" + StringTimer.TimerGame(Main.Andamento));
			p.sendMessage("§7Jogadores: §c" + Main.Jogadores.size());
			p.sendMessage("§7IP: §c" + Main.instance.getConfig().getString("ip"));
		}
		return true;
	}
}
