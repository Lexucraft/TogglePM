package com.eveningmc.tpm.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.eveningmc.lcore.utils.Message;
import com.eveningmc.tpm.TogglePM;

public class TogglePMCommand implements CommandExecutor
{
	
	
	public TogglePMCommand()
    {   
    }
	
    public boolean onCommand(CommandSender sender, Command command, String label, String args[])
    {
    	
		if(sender.hasPermission("togglepm.toggle"))
		{
			
			if(!(sender instanceof Player))
			{
				
				sender.sendMessage(Message.format("&9TogglePM > &cYou must be an ingame player to execute this command!"));
				return false;
				
			} else
			{
				
				Player player = (Player) sender;
				
				if(!(TogglePM.toggle.contains(player.getName())))
				{
					
					player.sendMessage(Message.format("&9TogglePM > &aPrivate messages toggled off!"));
					TogglePM.toggle.add(sender.getName());
					return true;
					
				} else
				{
					
					player.sendMessage(Message.format("&9TogglePM > &aPrivate messages toggled on!"));
					TogglePM.toggle.remove(sender.getName());
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
