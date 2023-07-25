package me.VideoSRC.comandos;


import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import me.VideoSRC.Main;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
public class VanishUtil {
	  private static final List<String> players = new ArrayList<>();
	  
	  public static List<String> getPlayers() {
	    return players;
	  }
static {

          new BukkitRunnable() {
              @Override
              public void run() {
                  players.stream().filter(
                          player -> Bukkit.getPlayer(player) != null
                  ).forEach(username ->  {
                      Player player = Bukkit.getPlayer(username);
                      sendActionBarWithoutCheck(player, "§aVocê está invisível para os jogadores. §f(§a" + players.size() + " §fstaffs no modo Vanish)");
                          Bukkit.getOnlinePlayers().forEach(online -> {
                              if (!online.hasPermission("kombo.cmd.report")) {
                                  online.hidePlayer(player);
                              }

                          });
                  });

              };
          }.runTaskTimer(Main.plugin, 0, 2 * 20L);
      };
      
      public static void sendActionBarWithoutCheck(Player player, String rawMessage) {
          CraftPlayer craftPlayer = (CraftPlayer) player;
          IChatBaseComponent cbc = ChatSerializer.a("{\"text\": \"" + rawMessage + "\"}");
          PacketPlayOutChat packetPlayOutChat = new PacketPlayOutChat(cbc, (byte) 2);
          craftPlayer.getHandle().playerConnection.sendPacket(packetPlayOutChat);
      }
  
  

		  
public static boolean has(String username) {
    return players.contains(username);
  }
  
  public static void add(String username) {
    if (!has(username))
      players.add(username); 
  }
  
  public static void remove(String username) {
    players.remove(username);
  }
}