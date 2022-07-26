package nox.playerstatsplus.playerstats;

import org.bukkit.plugin.java.JavaPlugin;

import nox.playerstatsplus.playerstats.modules.ItemLogger;
import nox.playerstatsplus.playerstats.modules.ChunkTracer;
import nox.playerstatsplus.playerstats.modules.ChatMessages;
import nox.playerstatsplus.playerstats.utils.PlayerFileManager;

import java.io.IOException;

public final class PlayerStats extends JavaPlugin {

    private static PlayerStats plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        startModules();

        plugin = this;

        try {
            PlayerFileManager.initiateFiles();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void startModules() {
        // Register all modules
        getServer().getPluginManager().registerEvents(new ChunkTracer(), this);
        getServer().getPluginManager().registerEvents(new ChatMessages(), this);
        getServer().getPluginManager().registerEvents(new ItemLogger(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

    }

    public static PlayerStats getPlugin() {
        return plugin;
    }

}
