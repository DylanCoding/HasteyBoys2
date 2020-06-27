package me.dylan.hasteyboys.locale;

import me.dylan.hasteyboys.HasteyBoys;
import org.bukkit.configuration.Configuration;

public class Locale {
    public static String PREFIX;

    public static String WRONG_ARGS;
    public static String HASTEYBOYS_ENABLE;
    public static String HASTEYBOYS_DISABLE;

    public Locale(HasteyBoys hb) {
        Configuration configuration = hb.getConfig();

        PREFIX = configuration.getString("messages.prefix", "&4UHC &8>>&7 ");

        WRONG_ARGS = configuration.getString("messages.args", "&cWrong Arguments! /hasteyboys <enable/disable/toggle>");
        HASTEYBOYS_ENABLE = configuration.getString("messages.enabled", "&aHasteyBoys &7has been &aenabled&7!");
        HASTEYBOYS_DISABLE = configuration.getString("messages.disabled", "&aHasteyBoys &7has been &cdisabled&7!");
    }
}
