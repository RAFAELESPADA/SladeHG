package me.VideoSRC.comandos;

import java.util.ArrayList;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.VideoSRC.Main;
import me.VideoSRC.api.Habilidade;
import me.VideoSRC.api.Strings;
import me.VideoSRC.menus.MenuKits1;

public class CMDKit implements Listener, CommandExecutor {
	public static void onKitChest(Player p) {
		if (Main.PreGame) {
			MenuKits1.InventarioKitsGui(p);
		}
	}

	public static ArrayList<String> CopyCat = new ArrayList();

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(Strings.server);
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("kit")) {
			if (args.length == 0) {
				onKitChest(p);
				return true;
			}
			if ((p.hasPermission("tag.membro")) && (args[0].equalsIgnoreCase("kangaroo"))) {
				p.sendMessage("§eVoce escolheu o kit: §cKangaroo");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Kangaroo");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.vip")  || p.hasPermission("hg.kit.crafter")) && (args[0].equalsIgnoreCase("crafter"))) {
				p.sendMessage("§eVoce escolheu o kit: §cCrafter");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Crafter");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.membro")) && (args[0].equalsIgnoreCase("launcher"))) {
				p.sendMessage("§eVoce escolheu o kit: §cLauncher");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Launcher");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.membro")) && (args[0].equalsIgnoreCase("madman"))) {
				p.sendMessage("§eVoce escolheu o kit: §cMadman");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Madman");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.vip") || p.hasPermission("hg.kit.enderman")) && (args[0].equalsIgnoreCase("enderman"))) {
				p.sendMessage("§eVoce escolheu o kit: §cEnderman");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Enderman");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.membro")) && (args[0].equalsIgnoreCase("grandpa"))) {
				p.sendMessage("§eVoce escolheu o kit: §cGrandpa");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Grandpa");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.vip") || p.hasPermission("hg.kit.copycat")) && (args[0].equalsIgnoreCase("Copycat"))) {
				p.sendMessage("§eVoce escolheu o kit: §cCopyCat");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "CopyCat");
				CopyCat.add(p.getName());
			}
			if ((p.hasPermission("tag.membro")) && (args[0].equalsIgnoreCase("Surprise"))) {
				p.sendMessage("§eVoce escolheu o kit: §cSurprise");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Surprise");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.vip") || p.hasPermission("hg.kit.cultivator")) && (args[0].equalsIgnoreCase("cultivator"))) {
				p.sendMessage("§eVoce escolheu o kit: §cCultivator");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Cultivator");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.vip") || p.hasPermission("hg.kit.anchor")) && (args[0].equalsIgnoreCase("anchor"))) {
				p.sendMessage("§eVoce escolheu o kit: §cAnchor");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Anchor");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.membro")) && (args[0].equalsIgnoreCase("hulk"))) {
				p.sendMessage("§eVoce escolheu o kit: §cHulk");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Hulk");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.vip") || p.hasPermission("hg.kit.demoman")) && (args[0].equalsIgnoreCase("Demoman"))) {
				p.sendMessage("§eVoce escolheu o kit: §cDemoman");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Demoman");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.membro")) && (args[0].equalsIgnoreCase("endermage"))) {
				p.sendMessage("§eVoce escolheu o kit: §cEndermage");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Endermage");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.vip") || p.hasPermission("hg.kit.tower")) && (args[0].equalsIgnoreCase("tower"))) {
				p.sendMessage("§eVoce escolheu o kit: §cTower");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Tower");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.membro")) && (args[0].equalsIgnoreCase("Fisherman"))) {
				p.sendMessage("§eVoce escolheu o kit: §cFisherman");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Fisherman");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.membro")) && (args[0].equalsIgnoreCase("forger"))) {
				p.sendMessage("§eVoce escolheu o kit: §cForger");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Forger");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.vip") || p.hasPermission("hg.kit.gladiator")) && (args[0].equalsIgnoreCase("gladiator"))) {
				p.sendMessage("§eVoce escolheu o kit: §cGladiator");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Gladiator");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.vip") || p.hasPermission("hg.kit.grappler")) && (args[0].equalsIgnoreCase("grappler"))) {
				p.sendMessage("§eVoce escolheu o kit: §cGrappler");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "grappler");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.vip") || p.hasPermission("hg.kit.jellyfish")) && (args[0].equalsIgnoreCase("jellyfish"))) {
				p.sendMessage("§eVoce escolheu o kit: §cJellyfish");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Jellyfish");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.vip") || p.hasPermission("hg.kit.flash")) && (args[0].equalsIgnoreCase("flash"))) {
				p.sendMessage("§eVoce escolheu o kit: §cFlash");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Flash");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.membro")) && (args[0].equalsIgnoreCase("lumberjack"))) {
				p.sendMessage("§eVoce escolheu o kit: §cLumberjack");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Lumberjack");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.membro")) && (args[0].equalsIgnoreCase("cannibal"))) {
				p.sendMessage("§eVoce escolheu o kit: §cCannibal");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Cannibal");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.membro")) && (args[0].equalsIgnoreCase("miner"))) {
				p.sendMessage("§eVoce escolheu o kit: §cMiner");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Miner");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.membro")) && (args[0].equalsIgnoreCase("monk"))) {
				p.sendMessage("§eVoce escolheu o kit: §cMonk");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Monk");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.membro")) && (args[0].equalsIgnoreCase("fireman"))) {
				p.sendMessage("§eVoce escolheu o kit: §cFireman");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Fireman");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.vip") || p.hasPermission("hg.kit.viking")) && (args[0].equalsIgnoreCase("viking"))) {
				p.sendMessage("§eVoce escolheu o kit: §cViking");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Viking");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.membro")) && (args[0].equalsIgnoreCase("ninja"))) {
				p.sendMessage("§eVoce escolheu o kit: §cNinja");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Ninja");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.vip") || p.hasPermission("hg.kit.poseidon")) && (args[0].equalsIgnoreCase("poseidon"))) {
				p.sendMessage("§eVoce escolheu o kit: §cPoseidon");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Poseidon");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.vip") || p.hasPermission("hg.kit.reaper")) && (args[0].equalsIgnoreCase("reaper"))) {
				p.sendMessage("§eVoce escolheu o kit: §cReaper");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Reaper");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.vip") || p.hasPermission("hg.kit.snail")) && (args[0].equalsIgnoreCase("snail"))) {
				p.sendMessage("§eVoce escolheu o kit: §cSnail");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Snail");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.vip") || p.hasPermission("hg.kit.specialist")) && (args[0].equalsIgnoreCase("specialist"))) {
				p.sendMessage("§eVoce escolheu o kit: §cSpecialist");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Specialist");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.membro")) && (args[0].equalsIgnoreCase("stomper"))) {
				p.sendMessage("§eVoce escolheu o kit: §cStomper");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Stomper");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.membro")) && (args[0].equalsIgnoreCase("Switcher"))) {
				p.sendMessage("§eVoce escolheu o kit: §cSwitcher");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Switcher");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.membro")) && (args[0].equalsIgnoreCase("tank"))) {
				p.sendMessage("§eVoce escolheu o kit: §cTank");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Tank");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.membro")) && (args[0].equalsIgnoreCase("thor"))) {
				p.sendMessage("§eVoce escolheu o kit: §cThor");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Thor");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.vip") || p.hasPermission("hg.kit.timelord")) && (args[0].equalsIgnoreCase("timelord"))) {
				p.sendMessage("§eVoce escolheu o kit: §cTimelord");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Timelord");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.membro")) && (args[0].equalsIgnoreCase("turtle"))) {
				p.sendMessage("§eVoce escolheu o kit: §cTurtle");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Turtle");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.membro")) && (args[0].equalsIgnoreCase("Viper"))) {
				p.sendMessage("§eVoce escolheu o kit: §cViper");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Viper");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.vip") || p.hasPermission("hg.kit.worm")) && (args[0].equalsIgnoreCase("worm"))) {
				p.sendMessage("§eVoce escolheu o kit: §cWorm");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Worm");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.vip") || p.hasPermission("hg.kit.achilles")) && (args[0].equalsIgnoreCase("Achilles"))) {
				p.sendMessage("§eVoce escolheu o kit: §cAchilles");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Achilles");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.vip")  || p.hasPermission("hg.kit.pyro")) && (args[0].equalsIgnoreCase("Pyro"))) {
				p.sendMessage("§eVoce escolheu o kit: §cPyro");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Pyro");
				CopyCat.remove(p.getName());
			}
			return true;
		}
		return false;
	}
}
