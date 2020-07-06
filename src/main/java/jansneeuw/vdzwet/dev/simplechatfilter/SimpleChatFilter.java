package jansneeuw.vdzwet.dev.simplechatfilter;

import jansneeuw.vdzwet.dev.simplechatfilter.events.ChatEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class SimpleChatFilter extends JavaPlugin {

    public static SimpleChatFilter plugin;

    @Override
    public void onEnable() {
        plugin = this;

        saveDefaultConfig();

        registerEvents(this, new ChatEvent(this));
    }

    @Override
    public void onDisable() {

    }

    public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
        for (Listener listener : listeners) {
            Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
        }
    }
}
