package me.VideoSRC.kits;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import me.VideoSRC.api.Habilidade;
import me.VideoSRC.comandos.CMDPvP;
import net.helix.core.util.CooldownFinishEvent;
import net.helix.core.util.CooldownStartEvent;
import net.helix.core.util.HelixCooldown2;
import net.helix.core.util.HelixCooldownAPI;
import net.helix.core.util.ItemCooldown;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;

public class Flash extends CMDPvP {


@SuppressWarnings("deprecation")
@EventHandler(priority = EventPriority.LOWEST)
public void onInteract(PlayerInteractEvent event) {
	Player p = event.getPlayer();
	if (p.getNearbyEntities(5, 5, 5).size() > 2 && p.getNearbyEntities(5, 5, 5) instanceof Player) {
		p.sendMessage("§cVocê não pode usar o Flash aqui!");
		return;
	}
	ItemStack currentItem = event.getItem();
	 if ((currentItem != null) && (currentItem.getType() != Material.AIR) && (currentItem.getType() == Material.REDSTONE_TORCH_ON)
				&& (Habilidade.getAbility(p).equalsIgnoreCase("flash"))) {
		if (!event.getAction().toString().contains("RIGHT")) 
		return;
		{
			event.setCancelled(true);
			if (!inCooldown(event.getPlayer())) {
				Block target = p.getTargetBlock((HashSet<Byte>) null, 200);
				if (target.getType() != Material.AIR) {
					addCooldown(p, 35);
					p.getWorld().strikeLightningEffect(p.getLocation());
					p.teleport(target.getRelative(BlockFace.UP).getLocation());
				}
			} else {
				sendMessageCooldown(event.getPlayer());
				event.setCancelled(true);
			}
		}
	}
}
@EventHandler
public void onUpdate(ServerTimerEvent event) {
	if (event.getCurrentTick() % 2 > 0)
		return;

	for (UUID uuid : net.helix.core.util.HelixCooldown2.map.keySet()) {
		Player player = Bukkit.getPlayer(uuid);
		if (player != null) {
			List<HelixCooldownAPI> list = HelixCooldown2.map.get(uuid);
			Iterator<HelixCooldownAPI> it = list.iterator();

			HelixCooldownAPI found = null;
			while (it.hasNext()) {
				HelixCooldownAPI cooldown = it.next();
				if (!cooldown.expired()) {
					if (cooldown instanceof ItemCooldown) {
						ItemStack hand = player.getEquipment().getItemInHand();
						if (hand != null && hand.getType() != Material.AIR) {
							ItemCooldown item = (ItemCooldown) cooldown;
							if (hand.equals(item.getItem())) {
								item.setSelected(true);
								found = item;
								break;
							}
						}
						continue;
					}
					found = cooldown;
					continue;
				}
				it.remove();
				Bukkit.getServer().getPluginManager().callEvent(new CooldownFinishEvent(player, cooldown));
				 player.playSound(player.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
			}

			if (found != null) {
				CooldownStartEvent e = new CooldownStartEvent(player, found);
				Bukkit.getPluginManager().callEvent(e);
				if (!e.isCancelled()) {
					HelixCooldown2.display(player, found);
				}
			} else if (list.isEmpty()) {
				sendActionBarWithoutCheck(player, " ");
				HelixCooldown2.map.remove(uuid);
			} else {
				HelixCooldownAPI cooldown = list.get(0);
				if (cooldown instanceof ItemCooldown) {
					ItemCooldown item = (ItemCooldown) cooldown;
					if (item.isSelected()) {
						item.setSelected(false);
						sendActionBarWithoutCheck(player, " ");
					}
					
				}
			}
		}}
			}
				public static void sendActionBarWithoutCheck(Player player, String rawMessage) {
			        CraftPlayer craftPlayer = (CraftPlayer) player;
			        IChatBaseComponent cbc = ChatSerializer.a("{\"text\": \"" + rawMessage + "\"}");
			        PacketPlayOutChat packetPlayOutChat = new PacketPlayOutChat(cbc, (byte) 2);
			        craftPlayer.getHandle().playerConnection.sendPacket(packetPlayOutChat);
			    }
			
	
}
