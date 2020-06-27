package me.dylan.hasteyboys;

import lombok.Getter;
import lombok.Setter;
import me.dylan.hasteyboys.commands.HasteyBoysCommand;
import me.dylan.hasteyboys.listeners.CraftingListener;
import me.dylan.hasteyboys.locale.Locale;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class HasteyBoys extends JavaPlugin {

    @Getter
    @Setter
    private boolean hasteyBoys;

    @Override
    public void onEnable() {
        saveDefaultConfig();

        registerCommands();
        registerListeners();

        new Locale(this);

        getLogger().info("");
    }

    private void registerCommands() {
        getCommand("hasteyboys").setExecutor(new HasteyBoysCommand(this));
    }

    private void registerListeners() {
        PluginManager pluginManager = this.getServer().getPluginManager();

        pluginManager.registerEvents(new CraftingListener(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
