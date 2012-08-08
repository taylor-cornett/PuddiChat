package com.FriedTaco.taco.PuddiChat;

//import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LeetFilter implements CommandExecutor
{
    private Player player;
    @SuppressWarnings("unused")
    private final PuddiChat plugin;
    public LeetFilter(PuddiChat instance) 
    {
        plugin = instance;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if(sender instanceof Player)
        {
            player = (Player) sender;
            if(player.hasPermission("PuddiChat.leetspeak"))
            {
                if(args.length==0)
                {
                    if(PuddiChat.currentFilter.equalsIgnoreCase("leet"))
                    {
                        player.sendMessage("N0 M04R 1337 4 U N00B");
                        PuddiChat.currentFilter = "";
                    }
                    else
                    {
                        player.sendMessage("13375P34K F7\\/\\/");
                        PuddiChat.currentFilter = "leet";
                    }
                    return true;
                }
                else
                {
                    player.sendMessage("Too many parameters! Just use /leetspeak");
                    return true;
                }
            }
            else
            {
                player.sendMessage("No 1337 for you!");
                 return true;
            }
        }       
        return false;
    }
}
