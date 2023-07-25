package me.VideoSRC.eventos;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.help.HelpTopic;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import me.VideoSRC.Main;
import me.VideoSRC.api.Habilidade;
import me.VideoSRC.comandos.CMDListener;

public class EventosExtras implements Listener {
	private boolean First = false;

	@EventHandler
	public void nuncaFome(FoodLevelChangeEvent evento) {
		evento.setFoodLevel(20);
	}

	@EventHandler
	public void nuncaChover(WeatherChangeEvent evento) {
		evento.setCancelled(true);
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
		if (!event.isCancelled()) {
			Player player = event.getPlayer();
			String cmd = event.getMessage().split(" ")[0];
			HelpTopic topic = Bukkit.getServer().getHelpMap().getHelpTopic(cmd);
			if (topic == null) {
				player.sendMessage("§cERRO§7, Comando nao encontrado!");
				event.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void aoMorrer(PlayerDeathEvent e) {
		Player p = e.getEntity().getKiller();

		if (Main.Partida)
			if (First == false) {
				First = true;
				CMDListener.getKs(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 4.0F, 4.0F);
				p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
				p.sendMessage("§cFIRSTBLOOD§7, Voce fez a primeira kill e ganhou um premio!");

			}
	}

	@EventHandler
	public void NomeDoKitCoracao(EntityDamageByEntityEvent e) {
		if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player))) {
			final Player apanho = (Player) e.getEntity();
			final Player bateu = (Player) e.getDamager();

			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {

				public void run() {
					Scoreboard sb = bateu.getScoreboard();
					Objective ob = sb.getObjective("kills");
					if (ob != null) {
						ob.unregister();

					}
					ob = sb.registerNewObjective("kills", "health");
					ob.setDisplaySlot(DisplaySlot.BELOW_NAME);
					ob.setDisplayName(" §c" + Habilidade.getAbility(apanho));
				}
			}, 420L);
		}
	}

	@EventHandler
	public void aoDesativarchat(PlayerChatEvent e) {
		Player p = e.getPlayer();
		
		if (Main.PreInvencibilidade) {
			e.setCancelled(true);
			p.sendMessage("§c§lERRO§7, Chat desativado aguarde acabar a Invencibilidade...");
		}
	}
}
