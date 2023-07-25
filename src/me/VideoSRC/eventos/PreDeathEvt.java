package me.VideoSRC.eventos;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.VideoSRC.Main;
import me.VideoSRC.api.EspectadoresManager;
import me.VideoSRC.api.Habilidade;
import me.VideoSRC.kits.BungeeAPI;
import me.VideoSRC.outros.ChecarVitoria;
import me.VideoSRC.outros.Manager;
import net.minecraft.server.v1_8_R3.PacketPlayInClientCommand;
import net.minecraft.server.v1_8_R3.PacketPlayInClientCommand.EnumClientCommand;

public class PreDeathEvt implements Listener {
	@EventHandler
	public void onRespawnRenove(PlayerDeathEvent e) {
		final Player p = e.getEntity();
		if (p.isDead()) {
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
				public void run() {
					((CraftPlayer) p).getHandle().playerConnection
							.a(new PacketPlayInClientCommand(EnumClientCommand.PERFORM_RESPAWN));
				}
			}, 15L);
		}
	}

	@EventHandler
	public void onDeathCheck(PlayerDeathEvent e) {
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			public void run() {
				e.getEntity().getWorld().strikeLightning(e.getEntity().getLocation().add(2.0D, 0.0D, 4.0D));
			}
		}, 35L);
	}

	@EventHandler
	public void Respawn(PlayerRespawnEvent e) {
		final Player p = e.getPlayer();
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			public void run() {
				Bukkit.getServer().getWorld("world");
				Random random = new Random();
				Location teleportLocation = null;
				int x = random.nextInt(350) + 1;
				int y = 150;
				int z = random.nextInt(350) + 1;
				boolean isOnLand = false;
				while (!isOnLand) {
					teleportLocation = new Location(p.getWorld(), x, y, z);
					if (teleportLocation.getBlock().getType() != Material.AIR) {
						isOnLand = true;
					} else {
						y--;
					}
				}
				p.teleport(new Location(p.getWorld(), teleportLocation.getX(), teleportLocation.getY() + 1.0D,
						teleportLocation.getZ()));
				p.setHealth(20.0D);
				p.setFoodLevel(20);
				p.setSaturation(75.0F);
				p.setNoDamageTicks(160);
				p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 120, 3));
				p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.COMPASS) });
			}
		}, 10L);
	}

	@EventHandler
	public void onRespawn(PlayerDeathEvent e) {
		final Player p = e.getEntity();
		if ((p.hasPermission("role.vip")) && (Main.Andamento <= 300 )) {
			ChecarVitoria.verificaWin();
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().clear();
			Manager.darBussola(p);
		} else if ((p.hasPermission("kombo.cmd.report")) && (Main.Andamento >= 300)) {
			Main.Jogadores.remove(p.getName());

			p.getInventory().clear();
			p.sendMessage("§cSPEC§7, Voce entrou no modo espectador!");
			p.sendMessage("§cSPEC§7, Use /ir para se teleportar a algum jogador!");
			p.setGameMode(GameMode.CREATIVE);

			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
				public void run() {
					ItemStack kit = new ItemStack(Material.SLIME_BALL);
					ItemMeta rkit = kit.getItemMeta();
					rkit.setDisplayName("§aMenu De Transporte.");
					kit.setItemMeta(rkit);
					p.getInventory().setItem(4, kit);
				}
			}, 5L);
			ChecarVitoria.verificaWin();
			Habilidade.removeAbility(p);
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
				public void run() {
					for (Player hids : Bukkit.getOnlinePlayers()) {

						hids.hidePlayer(p);
						p.setAllowFlight(true);
						p.setFlying(true);
					}
				}
			}, 5L);
		} else if ((Main.Andamento >= 300) && (p.hasPermission("role.vip"))) {
			Main.Watch.add(p.getName());
			EspectadoresManager.DamageMobs.add(p);
			Main.Jogadores.remove(p.getName());

			p.getInventory().clear();
			p.sendMessage("§cSPEC§7, Voce entrou no modo espectador!");
			p.sendMessage("§cSPEC§7, Use /ir para se teleportar a algum jogador!");
			p.setGameMode(GameMode.CREATIVE);

			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
				public void run() {
					ItemStack kit = new ItemStack(Material.SLIME_BALL);
					ItemMeta rkit = kit.getItemMeta();
					rkit.setDisplayName("§aMenu De Transporte.");
					kit.setItemMeta(rkit);
					p.getInventory().setItem(4, kit);
				}
			}, 5L);
			ChecarVitoria.verificaWin();
			Habilidade.removeAbility(p);
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
				public void run() {
					for (Player hids : Bukkit.getOnlinePlayers()) {

						hids.hidePlayer(p);
						p.setAllowFlight(true);
						p.setFlying(true);
					}
				}
			}, 5L);
		} else {
			BungeeAPI.send(p, "lobby");
			Main.mortos.add(p.getName());
			Main.Jogadores.remove(p.getName());
			ChecarVitoria.verificaWin();
		}
	}
}
