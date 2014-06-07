package com.eveningmc.tpm.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.eveningmc.lcore.utils.Message;
import com.eveningmc.tpm.TogglePM;

public class MessageCommand implements CommandExecutor
{
	
	
	public MessageCommand()
    {   
    }
	
    public boolean onCommand(CommandSender sender, Command command, String label, String args[])
    {
    	
		if(sender.hasPermission("togglepm.message"))
		{
			
			StringBuilder message = new StringBuilder();

            for (int i = 1; i < args.length; i++)
            {
            	
                if (i > 1) message.append(" ");
                message.append(args[i]);
                
            }
			
			if(args.length <= 1)
			{
				
				sender.sendMessage(Message.format("&9TogglePM > &cYou have not provided enough arguments!"));
				
			} else if(args[0].equalsIgnoreCase(Bukkit.getPlayerExact(args[0]).getName()))
			{
				
				if(TogglePM.toggle.contains(Bukkit.getPlayerExact(args[0]).getName()) && !sender.hasPermission("togglepm.bypass"))
				{
					
					sender.sendMessage(Message.format("&9TogglePM > &cThis player does not have messages enabled!"));
					
				} else
				{
					
					sender.sendMessage(Message.format("&9Me" + " > " + sender.getName() +"&7 " + Message.toString(args)));
					Bukkit.getPlayerExact(args[0]).sendMessage(Message.format("&9" + Bukkit.getPlayerExact(args[0]).getName() + " > Me&7 " + Message.toString(args)));
					return true;
					
				}
				
			}
			
		} else
		{
			
			sender.sendMessage(Message.format("&9TogglePM > &cYou do not have the required permissions for this command!"));
			
		}
		
		return true;
		
    }	
	
}
