package com.FriedTaco.taco.PuddiChat;

import java.util.Arrays;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerListener;

public class PuddiChatPlayerListener extends PlayerListener {

    
    final PuddiChat plugin;
    

    public PuddiChatPlayerListener(PuddiChat instance) 
    {
        plugin = instance;
    }
    public void onPlayerChat(PlayerChatEvent event)
    {
        Player player = event.getPlayer();
        boolean isExempt = false;
        if((player.isOp()))
            isExempt = true;
        else if(player.hasPermission("PuddiChat.exempt"))
            isExempt = true;
        if(!isExempt)
        {
            String temp = event.getMessage();
            if(PuddiChat.currentFilter.equalsIgnoreCase("Puddi"))
            {
                /*
                temp = temp.replaceAll(",", "");
                temp = temp.replaceAll(".", "");
                temp = temp.replaceAll("!", "");
                temp = temp.replaceAll("^", "");
                temp = temp.replaceAll(":", "");
                temp = temp.replaceAll(";", "");
                */
                String[] message = temp.split(" ");
                List<String> gigaWords = Arrays.asList(new String[] {"i","or","if","you","u","troll","umad","umadbro","minecraft","tomato","notch","and","noob","food","diamond","but"});
                    //new ArrayList<String>();
                String puddify = "";
                if(message != null)
                {
                    if(!gigaWords.contains(message[0].toLowerCase()))
                        puddify += "Puddi";
                    else
                        puddify += "Giga";
                    if(message.length >= 2)
                        for(int i=1; i<message.length; i++){
                            if(!gigaWords.contains(message[i].toLowerCase()))
                                puddify += " puddi";
                            else
                                puddify += " Giga";
                            if(i == message.length-1)
                                puddify += ".";
                        }
                }
                else
                {
                    puddify = "Puddi.";
                }
                event.setMessage(puddify);
            }
            else if(PuddiChat.currentFilter.equalsIgnoreCase("leet"))
            {
                temp = temp.toUpperCase();
                temp = temp.replaceAll("A", "4");
                temp = temp.replaceAll("B", "8");
                temp = temp.replaceAll("C", "(");
                temp = temp.replaceAll("D", "[)");
                temp = temp.replaceAll("E", "3");
                temp = temp.replaceAll("H", "|-|");
                temp = temp.replaceAll("I", "!");
                temp = temp.replaceAll("K", "|<");
                temp = temp.replaceAll("L", "|_");
                temp = temp.replaceAll("O", "0");
                temp = temp.replaceAll("S", "5");
                temp = temp.replaceAll("T", "7");
                temp = temp.replaceAll("U", "|_|");
                System.out.println(temp);
                event.setMessage(temp);
            }
            else if (PuddiChat.currentFilter.equalsIgnoreCase("nyan"))
            {
            	String[] message = temp.split(" ");
                List<String> gigaWords = Arrays.asList(new String[] {"i","or","if","you","u","troll","umad","umadbro","minecraft","tomato","notch","and","noob","food","diamond","but"});
                    //new ArrayList<String>();
                String puddify = "";
                if(message != null)
                {
                    if(!gigaWords.contains(message[0].toLowerCase()))
                        puddify += "Nyan";
                    else
                        puddify += "Nyan";
                    if(message.length >= 2)
                        for(int i=1; i<message.length; i++){
                            if(!gigaWords.contains(message[i].toLowerCase()))
                                puddify += " nyan";
                            else
                                puddify += " Nyan";
                            if(i == message.length-1)
                                puddify += "!";
                        }
                    else
                    {
                        puddify = "Nyan! O_O";
                    }
                    event.setMessage(puddify);
                }
            }
        }
    }
}


