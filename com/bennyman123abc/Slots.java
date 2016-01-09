package com.bennyman123abc;
 
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
 
public class Slots extends org.bukkit.plugin.java.JavaPlugin implements Listener
{
	@Override
    public void onEnable()
    {
//      getLogger().info("Plugin Made by bennyman123abc");
      org.bukkit.Bukkit.getServer().getPluginManager().registerEvents(this, this);
    }
  
    @EventHandler
    public void playerLogin(PlayerLoginEvent event) {
      if (event.getResult() == PlayerLoginEvent.Result.KICK_FULL) {
        event.allow();
      }
   }
}