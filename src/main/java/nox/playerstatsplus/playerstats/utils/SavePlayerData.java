package nox.playerstatsplus.playerstats.utils;

import nox.playerstatsplus.playerstats.PlayerStats;

import static nox.playerstatsplus.playerstats.utils.PlayerFileManager.getPlayerData;
import static nox.playerstatsplus.playerstats.utils.PlayerFileManager.getPlayerDataFile;

import java.io.IOException;
import java.util.UUID;

public class SavePlayerData {

    public static void saveData(UUID uuid) {

        // FIXME: 7/25/2022 

        try {
            getPlayerData().save(getPlayerDataFile());
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
