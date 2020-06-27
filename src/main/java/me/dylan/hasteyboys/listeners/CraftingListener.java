package me.dylan.hasteyboys.listeners;

import me.dylan.hasteyboys.HasteyBoys;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CraftingListener implements Listener {

    private final HasteyBoys hb;

    public CraftingListener(HasteyBoys hb) {
        this.hb = hb;
    }

    @EventHandler
    public void on(PrepareItemCraftEvent event) {
        if (!hb.isEnabled()) return;
        if (event.getRecipe() == null) return;

        CraftingInventory craftingInventory = event.getInventory();
        ItemStack item = event.getRecipe().getResult();
        String name = item.getType().name();

        if (!(name.contains("SPADE") || name.contains("AXE") || name.contains("PICKAXE"))) return;

        ItemMeta meta = item.getItemMeta();
        if (meta == null) return;

        meta.addEnchant(Enchantment.DIG_SPEED, 3, true);
        meta.addEnchant(Enchantment.DURABILITY, 3, true);
        item.setItemMeta(meta);

        craftingInventory.setResult(item);
    }


}
