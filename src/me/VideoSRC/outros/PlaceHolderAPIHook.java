package me.VideoSRC.outros;




import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.VideoSRC.Main;
import me.VideoSRC.api.Habilidade;
import me.VideoSRC.comandos.CMDListener;
import me.VideoSRC.tempos.Iniciando;
import me.VideoSRC.tempos.StringTimer;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import net.helix.core.bukkit.HelixBukkit;
import net.helix.core.bukkit.account.HelixPlayer;


/**
 * This class will be registered through the register-method in the 
 * plugins onEnable-method.
 */
 public class PlaceHolderAPIHook extends PlaceholderExpansion {

	 /*    */   
	 /*    */   static Main plugin;

    /**
     * Since we register the expansion inside our own plugin, we
     * can simply use this method here to get an instance of our
     * plugin.
     *
     * @param plugin
     *        The instance of our plugin.
     */
    /*    */   public PlaceHolderAPIHook(Main main)
    /*    */   {
    /* 20 */     this.plugin = main;
    /* 21 */     plugin = main;
    /*    */   }
    /*    */   

    /**
     * Because this is an internal class,
     * you must override this method to let PlaceholderAPI know to not unregister your expansion class when
     * PlaceholderAPI is reloaded
     *
     * @return true to persist through reloads
     */
    @Override
    public boolean persist(){
        return true;
    }

    /**
     * Because this is a internal class, this check is not needed
     * and we can simply return {@code true}
     *
     * @return Always true since it's an internal class.
     */
    @Override
    public boolean canRegister(){
        return true;
    }

    /**
     * The name of the person who created this expansion should go here.
     * <br>For convienience do we return the author from the plugin.yml
     * 
     * @return The name of the author as a String.
     */
    @Override
    public String getAuthor(){
        return plugin.getDescription().getAuthors().toString();
    }

    /**
     * The placeholder identifier should go here.
     * <br>This is what tells PlaceholderAPI to call our onRequest 
     * method to obtain a value if a placeholder starts with our 
     * identifier.
     * <br>This must be unique and can not contain % or _
     *
     * @return The identifier in {@code %<identifier>_<value>%} as String.
     */
    @Override
    public String getIdentifier(){
        return "hg";
    }

    /**
     * This is the version of the expansion.
     * <br>You don't have to use numbers, since it is set as a String.
     *
     * For convienience do we return the version from the plugin.yml
     *
     * @return The version as a String.
     */
    @Override
    public String getVersion(){
        return plugin.getDescription().getVersion();
    }

    /**
     * This is the method called when a placeholder with our identifier 
     * is found and needs a value.
     * <br>We specify the value identifier in this method.
     * <br>Since version 2.9.1 can you use OfflinePlayers in your requests.
     *
     * @param  player
     *         A {@link org.bukkit.Player Player}.
     * @param  identifier
     *         A String containing the identifier/value.
     *
     * @return possibly-null String of the requested identifier.
     */


    public String onPlaceholderRequest(Player helixPlayer, String indentifier)
  {
    	String kit = Habilidade.NomeDoKit(Habilidade.getAbility(helixPlayer));
    	 if (helixPlayer == null) {
    		    return "";
    		  }
    	HelixPlayer pinto = HelixBukkit.getInstance().getPlayerManager().getPlayer(helixPlayer.getName());
    if (indentifier.equals("kills")) {
      return String.valueOf(CMDListener.getKs(helixPlayer));
    }
    if (indentifier.equals("coins")) {
        return String.valueOf(pinto.getPvp().getCoins());
      }
    if (indentifier.equals("players")) {
    	return Main.Jogadores.size() + "/"
    			+ Bukkit.getServer().getMaxPlayers();
    }
    if (indentifier.equals("rank")) {
	      return String.valueOf(Iniciando.Rank(helixPlayer));
	    }
  if (indentifier.equals("kit")) {
	      return String.valueOf(kit);
	    }
    if (indentifier.equals("tempo")) {
	      if (Main.PreGame); {
	    	  return StringTimer.TimerGame(Main.TimerIniciando);
	      }
    } else if (Main.PreInvencibilidade) {
    	return StringTimer.TimerGame(Main.TimerInvencibilidade);
	      }
  else if (Main.Partida)
	  return StringTimer.TimerGame(Main.Andamento);
    {
	return null;
 }
 }
 }
 


