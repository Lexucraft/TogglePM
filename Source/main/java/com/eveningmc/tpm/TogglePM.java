package com.eveningmc.tpm;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.eveningmc.lcore.Lexucraft_Core;
import com.eveningmc.tpm.commands.MessageCommand;
import com.eveningmc.tpm.commands.TogglePMCommand;

public class TogglePM extends JavaPlugin
{
	
	private static TogglePM instance;
	private PluginManager pluginManager;
	private Lexucraft_Core lcore;
	public static List<String> toggle = new ArrayList<String>();
	
	public void load()
	{
		
		this.setInstance(this);
		this.setPluginManager(this.getServer().getPluginManager());
		
		setupLCore();
		
	}
	
	public void onDisable()
	{
		
	}
	
	public void onEnable()
	{
		
		getCommand("msg").setExecutor(new MessageCommand());
		getCommand("tpm").setExecutor(new TogglePMCommand());
		
	}
	
	public static TogglePM getInstance()
	{
		
		return instance;
		
	}
	
	private void setInstance(TogglePM lcore)
	{
		
		lcore = instance;
		
	}

	public PluginManager getPluginManager()
	{

		return pluginManager;

	}

	private void setPluginManager(PluginManager pluginManager)
	{

		this.pluginManager = pluginManager;

	}
	
	private boolean setupLCore()
	{
		
		if(getServer().getPluginManager().getPlugin("LCore") == null)
		{
			
			getLogger().log(Level.WARNING, "LCore was not found, disabling!");
			return false;
			
		}
		
		return (lcore != null);
		
	}
	
}
