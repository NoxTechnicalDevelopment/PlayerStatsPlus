package nox.playerstatsplus.playerstats.modules;

import org.bukkit.Chunk;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.UUID;

public class ChunkTracer implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        if (e != null && !e.isCancelled() && e.getTo() != null) {

            // Get the previous and current chunks
            Chunk from = e.getFrom().getChunk();
            Chunk to = e.getTo().getChunk();

            // Make sure the player moved into a new chunk
            if (from.getX() != to.getX() || from.getZ() != to.getZ()) {
                System.out.println(to.getX()+" "+to.getZ());
            }
        }
    }
}
