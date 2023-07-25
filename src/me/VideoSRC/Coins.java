package me.VideoSRC;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

public class Coins
{
  @SuppressWarnings({ "unchecked", "rawtypes" })
public static HashMap<String, Double> bal = new HashMap();
  public static Economy econ = null;
  public static Permission perms = null;
  
  public static HashMap<String, Double> getCoinsMap()
  {
    return bal;
  }
  public static boolean setupEconomy() {
      if (Bukkit.getServer().getPluginManager().getPlugin("Vault") == null) {
          return false;
      }
      RegisteredServiceProvider<Economy> rsp = Bukkit.getServer().getServicesManager().getRegistration(Economy.class);
      if (rsp == null) {
          return false;
      }
      econ = rsp.getProvider();
      return econ != null;
  }
  public static boolean setupPermissions() {
      RegisteredServiceProvider<Permission> rsp = Bukkit.getServer().getServicesManager().getRegistration(Permission.class);
      perms = rsp.getProvider();
      return perms != null;
  }
}