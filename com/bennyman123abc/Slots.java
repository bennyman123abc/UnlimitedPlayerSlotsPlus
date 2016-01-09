package com.bennyman123abc;
 
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.permissions.Permission;
 
public class Slots extends org.bukkit.plugin.java.JavaPlugin implements Listener
{
//	Boolean for Feature #0001
	
	public boolean joinFull = getConfig().getBoolean("joinOnFull");
	
//  Permission for Feature #0002
	public Permission fullJoin = new Permission("upsp.join");
	
	@Override
    public void onEnable()
    {
//      getLogger().info("Plugin Made by bennyman123abc");
      org.bukkit.Bukkit.getServer().getPluginManager().registerEvents(this, this);
      getConfig().addDefault("joinOnFull", true);
      Bukkit.getServer().getPluginManager().addPermission(fullJoin);
    }
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
//		Command for Feature #0001
		
		if(cmd.getName().equalsIgnoreCase("togglejoinonfull")) {
			if(joinFull == false) {
				sender.sendMessage("Players who have permission can now join when the server is full");
				getConfig().set("joinOnFull", true);
			}
			else if(joinFull == true) {
				sender.sendMessage("Players cannot join when the server is full");
				getConfig().set("joinOnFull", false);
			}
		}
		
		return false;
	}
  
    @EventHandler
    public void playerLogin(PlayerLoginEvent event) {
      if (event.getResult() == PlayerLoginEvent.Result.KICK_FULL) {
    	  
//    	Feature #0001 and Feature #0002
    	  
        Player player = event.getPlayer();
        
        if(player.hasPermission(fullJoin) && joinFull == true) {
        	event.allow();
        }
        
        
      }
   }
}