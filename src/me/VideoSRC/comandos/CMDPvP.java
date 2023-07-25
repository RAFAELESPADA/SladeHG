package me.VideoSRC.comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import me.VideoSRC.api.Strings;
import net.helix.core.util.HelixCooldown2;

public class CMDPvP implements Listener, CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(Strings.server);
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("pvp")) {
			if (p.hasPermission("kombo.cmd.report")) {
				if (args.length == 0) {
					p.sendMessage("§eUse: /pvp on ou /pvp off");
					return true;
				}
				if (args[0].equalsIgnoreCase("on")) {
					Bukkit.getServer().getWorld("world").setPVP(true);
					Bukkit.broadcastMessage("§ePvp global foi ativado!");
				}
				if (args[0].equalsIgnoreCase("off")) {
					Bukkit.getServer().getWorld("world").setPVP(false);
					Bukkit.broadcastMessage("§ePvp global foi desativado!");
				}
			} else {
				p.sendMessage(Strings.perm);
				return true;
			}
		}
		return true;
	}


protected boolean hasCooldown(Player player) {
    return HelixCooldown2.hasCooldown(player, "Kit");
}

protected boolean hasCooldown(Player player, String cooldown) {
    return HelixCooldown2.hasCooldown(player, cooldown);
}

protected boolean inCooldown(Player player, String cooldown) {
    return HelixCooldown2.inCooldown(player, cooldown);
}

protected boolean inCooldown(Player player) {
    return HelixCooldown2.inCooldown(player, "Kit");
}

protected void sendMessageCooldown(Player player) {
	HelixCooldown2.sendMessage(player, "Kit");
}

protected void sendMessageCooldown(Player player, String cooldown) {
	HelixCooldown2.sendMessage(player, cooldown);
}

protected void addCooldown(Player player, String cooldownName, long time) {
    if (HelixCooldown2.hasCooldown(player, cooldownName)) {
        HelixCooldown2.removeCooldown(player, cooldownName);
    }
    HelixCooldown2.addCooldown(player, new net.helix.core.util.HelixCooldownAPI(cooldownName, time));
}

protected void addCooldown(Player player, long time) {
    if (HelixCooldown2.hasCooldown(player, "Kit")) {
        HelixCooldown2.removeCooldown(player, "Kit");
    }
    HelixCooldown2.addCooldown(player, new net.helix.core.util.HelixCooldownAPI("Kit", time));
}

protected void addItemCooldown(Player player, ItemStack item, String cooldownName, long time) {
    if (HelixCooldown2.hasCooldown(player, cooldownName)) {
        HelixCooldown2.removeCooldown(player, cooldownName);
    }
    HelixCooldown2.addCooldown(player, new net.helix.core.util.ItemCooldown(item, cooldownName, time));
}
}
