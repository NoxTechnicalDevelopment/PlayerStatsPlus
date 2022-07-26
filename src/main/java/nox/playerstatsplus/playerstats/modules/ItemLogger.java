package nox.playerstatsplus.playerstats.modules;

import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemStack;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.event.player.PlayerDropItemEvent;
import nox.playerstatsplus.playerstats.PlayerStats;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.persistence.PersistentDataContainer;

import java.util.UUID;

import static org.bukkit.Bukkit.getServer;

public class ItemLogger implements Listener {

    @EventHandler
    public void onItemDrop(PlayerDropItemEvent e){
        Player player = e.getPlayer();
        Item item = e.getItemDrop();

        UUID uuid = player.getUniqueId();

        ItemStack itemstack = item.getItemStack();
        ItemMeta meta = itemstack.getItemMeta();
        PersistentDataContainer data = meta.getPersistentDataContainer();

        data.set(new NamespacedKey(PlayerStats.getPlugin(), "player"), PersistentDataType.STRING, uuid.toString());
        itemstack.setItemMeta(meta);

        getServer().broadcastMessage("Player "+player.getDisplayName()+" Dropped "+item.getName());
    }

    @EventHandler
    public void onItemPickup(EntityPickupItemEvent e){
        LivingEntity entity = e.getEntity();
        Item item = e.getItem();

        ItemStack itemstack = item.getItemStack();
        ItemMeta meta = itemstack.getItemMeta();
        PersistentDataContainer data = meta.getPersistentDataContainer();

        if (entity instanceof Player && data.has(new NamespacedKey(PlayerStats.getPlugin(), "player"), PersistentDataType.STRING)) {
            String player = entity.getName();
            String dropper = data.get(new NamespacedKey(PlayerStats.getPlugin(), "player"), PersistentDataType.STRING);

            getServer().broadcastMessage("Player "+player+" Picked Up "+item.getName()+" From "+dropper);
        }

    }

}