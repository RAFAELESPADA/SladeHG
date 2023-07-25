package me.VideoSRC.comandos;

/*     */ 
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.helix.core.bukkit.HelixBukkit;
import net.helix.core.bukkit.account.HelixPlayer;



@SuppressWarnings("unused")
public class GiveCoins implements CommandExecutor {
	public static boolean isNumeric(String str) {
		try {
			Integer.parseInt(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("givecoins")) {
			if (!sender.hasPermission("kitpvp.coins")) {
				sender.sendMessage("You dont have permission");
			} else {
				if (args.length == 0) {
					sender.sendMessage( "�c�l/givecoins [player] [amount]");
					return true;
				}
				Player target = Bukkit.getPlayerExact(args[0]);
				if ((target == null) || (!(target instanceof Player))) {
					sender.sendMessage( "�c�lThe Player is offline");
					return true;
				}
				if (isNumeric(args[1])) {
					Integer coins = Integer.parseInt(args[1]);
					HelixPlayer p1 = HelixBukkit.getInstance().getPlayerManager().getPlayer(target.getName());
				     p1.getPvp().addCoins(coins);
					sender.sendMessage( "�eVoc� deu ao player " + target.getName() + "" + coins
							+ "�bCoins");
					target.sendMessage( "�eVoc� recebeu do player " + coins
							+ " �bCoins");
					target.sendMessage( "�6Seus coins foi atualizado!");
				}
			}
		}
		return false;
	}
}

		


/* Location:              D:\Desktop\video\Minhas Coisas do Desktop\KP-PVPvB12 (1).jar!\me\RafaelAulerDeMeloAraujo\Coins\Commands.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */

