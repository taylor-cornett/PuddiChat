package com.FriedTaco.taco.PuddiChat;



	import java.io.File;
	import java.io.FileReader;
	import java.util.logging.Level;
	import java.util.logging.Logger;
	import java.util.HashMap;
	import java.util.Map;
	import org.bukkit.entity.Player;
	import org.bukkit.event.Event.Priority;
	import org.bukkit.event.Event;
	import org.bukkit.event.player.PlayerLoginEvent;
	import org.bukkit.plugin.PluginDescriptionFile;
	import org.bukkit.plugin.java.JavaPlugin;
	import org.bukkit.plugin.PluginManager;
	import com.nijiko.permissions.PermissionHandler;
	import com.nijikokun.bukkit.Permissions.Permissions;
	import org.bukkit.plugin.Plugin;
	import org.bukkit.util.config.Configuration;
	import org.yaml.snakeyaml.*;
	import org.yaml.snakeyaml.constructor.SafeConstructor;




	public class PuddiChat extends JavaPlugin {
		private Logger log;
	    private final PuddiChatPlayerListener playerListener  = new PuddiChatPlayerListener(this);
	    private final HashMap<Player, Boolean> debugees = new HashMap<Player, Boolean>();  
		public static PermissionHandler Permissions;
		public Configuration config = null;
		private static Yaml yaml = new Yaml(new SafeConstructor());
		public static String currentFilter;

	   
		 private void setupPermissions() {
		      Plugin test = this.getServer().getPluginManager().getPlugin("Permissions");

		      if (PuddiChat.Permissions == null) 
		      {
		          if (test != null) {
		              PuddiChat.Permissions = ((Permissions)test).getHandler();
		              System.out.println("Puddichat has detected Permissions!");
		          } else {
		             System.out.println("Puddichat has not detected Permissions. Giving command permission to OP.");
		          }
		      }
		  }
		 
	    public void loadSettings() throws Exception {
	    	if (!this.getDataFolder().exists())
	    	{
	    		this.getDataFolder().mkdirs();
	    	}
	    	final String dir = "plugins";
	    	File puddi = new File(this.getDataFolder(), "PuddiChat.yml");
	        if (!puddi.exists())
	        	puddi.createNewFile();
	        config = new Configuration(puddi);
	        @SuppressWarnings("unchecked")
			Map<String, Object> data = (Map<String, Object>)yaml.load(new FileReader(puddi));
	        //Add config later on.
	        }
	    
	    public void onDisable() {
	    }
	    @Override
	    public void onEnable() {
	    	getCommand("puddi").setExecutor(new PuddiFilter(this));
	    	getCommand("leetspeak").setExecutor(new LeetFilter(this));
	    	try {
				loadSettings();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Loaded " + this.getDescription().getName() + " build " + this.getDescription().getVersion() + " by Taco");
	    	currentFilter = "";
	        PluginManager pm = getServer().getPluginManager();
	        pm.registerEvent(Event.Type.PLAYER_CHAT, playerListener, Priority.Normal, this);
	        PluginDescriptionFile pdfFile = this.getDescription();
	        System.out.println(pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled!" );
	        setupPermissions();
	    }

	    public boolean isDebugging(final Player player) {
	        if (debugees.containsKey(player)) {
	            return debugees.get(player);
	        } else {
	            return false;
	        }
	    }

	    public void setDebugging(final Player player, final boolean value) {
	        debugees.put(player, value);
	    }

	
		public void recordEvent(PlayerLoginEvent event) {
			// TODO Auto-generated method stub
			
		}
	}




