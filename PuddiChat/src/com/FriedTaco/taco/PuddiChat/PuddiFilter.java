package com.FriedTaco.taco.PuddiChat;

//import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PuddiFilter implements CommandExecutor
{
	private Player player;
	@SuppressWarnings("unused")
	private final PuddiChat plugin;
    public PuddiFilter(PuddiChat instance) 
    {
        plugin = instance;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
    	if(sender instanceof Player)
    	{
    		player = (Player) sender;
    		if((PuddiChat.Permissions == null && player.isOp()) || (PuddiChat.Permissions != null && PuddiChat.Permissions.has(player, "PuddiChat.puddi")))
    		{
	    		if(args.length==0)
				{
	    			if(PuddiChat.currentFilter.equalsIgnoreCase("puddi"))
	    			{
	    				player.sendMessage("Puddi.. :(");
	        			PuddiChat.currentFilter = "";
	    			}
	    			else
	    			{
	    				player.sendMessage("Puddi puddi!");
	        			PuddiChat.currentFilter = "puddi";
	    			}
	        		return true;
				}
	        	else
	        	{
	        		player.sendMessage("Too many parameters! Just use /puddi");
					return true;
	        	}
    		}
    		else
    		{
    			player.sendMessage("No puddi for you!");
     			return true;
    		}
    	}       
        return false;
    }
}
