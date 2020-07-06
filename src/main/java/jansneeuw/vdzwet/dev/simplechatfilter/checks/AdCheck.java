package jansneeuw.vdzwet.dev.simplechatfilter.checks;

import jansneeuw.vdzwet.dev.simplechatfilter.SimpleChatFilter;
import jansneeuw.vdzwet.dev.simplechatfilter.converters.SymbolConverter;

public class AdCheck {

    private SimpleChatFilter plugin;
    public AdCheck(SimpleChatFilter plugin){
        this.plugin = plugin;
    }

    public String[] blockedDomains;

    public boolean messageContainsAd(String message){
        blockedDomains = plugin.getConfig().getStringList("blocked-domains").toArray(new String[0]);
        String message_x = message.replace("dot", ".")
                .replace("(.)", ".");
        String message_d = SymbolConverter.deobfuscateSymbols(message_x);
        for (String submessage : message_d.split(" ")){
            if (submessage.length() - submessage.replace(".", "").length() >= 1){
                for (String b_domains : blockedDomains){
                    if (submessage.contains(b_domains)){
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
