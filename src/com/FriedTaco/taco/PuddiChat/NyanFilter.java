package com.FriedTaco.taco.PuddiChat;

//import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NyanFilter implements CommandExecutor
{
    private Player player;
    @SuppressWarnings("unused")
    private final PuddiChat plugin;
    public NyanFilter(PuddiChat instance) 
    {
        plugin = instance;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if(sender instanceof Player)
        {
            player = (Player) sender;
            if(player.hasPermission("PuddiChat.nyan"))
            {
                if(args.length==0)
                {
                    if(PuddiChat.currentFilter.equalsIgnoreCase("nyan"))
                    {
                        player.sendMessage("Nyan... >:(");
                        PuddiChat.currentFilter = "";
                    }
                    else
                    {
                        player.sendMessage("NYAN NYAN! O_O");
                        PuddiChat.currentFilter = "nyan";
                    }
                    return true;
                }
                else
                {
                    player.sendMessage("Too many parameters! Just use /nyan");
                    return true;
                }
            }
            else
            {
                player.sendMessage("No nyan for you!");
                 return true;
            }
        }       
        return false;
    }
}
