package nox.playerstatsplus.playerstats.modules;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.UUID;

public class ChatMessages implements Listener {

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e){
        Player player = e.getPlayer();
        String message = e.getMessage();
        
    }
}