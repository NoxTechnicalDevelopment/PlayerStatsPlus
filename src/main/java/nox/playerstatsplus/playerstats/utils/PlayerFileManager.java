package nox.playerstatsplus.playerstats.utils;

import nox.playerstatsplus.playerstats.PlayerStats;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class PlayerFileManager {

    /**
     *Code from https://github.com/Orf1/Anti-Xray-Plus Main.java
     */
    private static YamlConfiguration modifyPlayerData;
    private static File playerDataFile;

    public static void initiateFiles() throws IOException {
        playerDataFile = new File(PlayerStats.getPlugin().getDataFolder(), "playerdata.yml");

        if (!playerDataFile.exists()) {
            playerDataFile.createNewFile();
        }
        modifyPlayerData = YamlConfiguration.loadConfiguration(playerDataFile);

    }

    public static YamlConfiguration getPlayerData() { return modifyPlayerData; }

    public static File getPlayerDataFile() { return playerDataFile; }

}
