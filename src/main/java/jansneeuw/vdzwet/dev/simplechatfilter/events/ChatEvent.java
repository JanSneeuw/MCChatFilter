package jansneeuw.vdzwet.dev.simplechatfilter.events;

import jansneeuw.vdzwet.dev.simplechatfilter.SimpleChatFilter;
import jansneeuw.vdzwet.dev.simplechatfilter.checks.AdCheck;
import jansneeuw.vdzwet.dev.simplechatfilter.checks.CurseCheck;
import jansneeuw.vdzwet.dev.simplechatfilter.checks.IpCheck;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatEvent implements Listener {

    private SimpleChatFilter plugin;
    public ChatEvent(SimpleChatFilter plugin){
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onChat(AsyncPlayerChatEvent event){
        //Check for ads
        AdCheck adCheck = new AdCheck(plugin);
        if (adCheck.messageContainsAd(event.getMessage()) && !event.getPlayer().hasPermission("SCF.BYPASSADFILTER")){
            event.setCancelled(true);
            return;
        }

        //Check for curse words
        CurseCheck curseCheck = new CurseCheck(plugin);
        if (curseCheck.messageContainsCurses(event.getMessage())){
            event.setCancelled(true);
            return;
        }

        //Check for Ips
        IpCheck ipCheck = new IpCheck();
        if (ipCheck.messageContainsIp(event.getMessage()) && !event.getPlayer().hasPermission("SCF.BYPASSIPFILTER")){
            event.setCancelled(true);
            return;
        }
    }
}
