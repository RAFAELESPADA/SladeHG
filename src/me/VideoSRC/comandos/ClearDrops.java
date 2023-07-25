package me.VideoSRC.comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;

public class ClearDrops implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (!sender.hasPermission("kombo.cmd.report")) {
            sender.sendMessage("§cSem permissão.");
            return true;
        }

        Bukkit.getWorlds().forEach(world -> world.getEntities().stream().filter(
                entity -> entity instanceof Item
        ).forEach(Entity::remove));

        sender.sendMessage("§aDrops removidos");
        return true;
    }
}
