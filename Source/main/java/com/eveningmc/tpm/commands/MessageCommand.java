package com.eveningmc.tpm.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.eveningmc.lcore.Lexucraft_Core;
import com.eveningmc.lcore.utils.Message;
import com.eveningmc.tpm.TogglePM;

public class MessageCommand implements CommandExecutor
{
	
	
	public MessageCommand()
    {   
    }
	
    public boolean onCommand(CommandSender sender, Command command, String label, String args[])
    {
    	
		if(sender.hasPermission("lcore.message"))
		{
			
			Player player = Bukkit.getPlayerExact(args[0]);
			
			StringBuilder message = new StringBuilder();

            for (int i = 1; i < args.length; i++)
            {
            	
                if (i > 1) message.append(" ");
                message.append(args[i]);
                
            }
			
			if(args[0].equalsIgnoreCase(""))
			{
				
				sender.sendMessage(Message.format("&9LCore > &cYou have not provided enough arguments!"));
				
			} else if(args[0].equalsIgnoreCase(player.getName()))
			{
				
				if(TogglePM.toggle.contains(player.getName()))
				{
					
					sender.sendMessage(Message.format("&9LCore > &cThis player does not have messages enabled!"));
					
				} else
				{
					
					sender.sendMessage(Message.format("&9Me" + " > " + sender.getName() +"&7 " + Message.toString(args)));
					player.sendMessage(Message.format("&9" + player.getName() + " > Me&7 " + Message.toString(args)));
					return true;
					
				}
				
			}
			
		}
		
		return true;
		
    }	
	
}
