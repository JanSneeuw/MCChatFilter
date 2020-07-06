package jansneeuw.vdzwet.dev.simplechatfilter.checks;

import jansneeuw.vdzwet.dev.simplechatfilter.SimpleChatFilter;
import jansneeuw.vdzwet.dev.simplechatfilter.converters.SymbolConverter;

public class CurseCheck {

    private SimpleChatFilter plugin;
    public CurseCheck(SimpleChatFilter plugin){
        this.plugin = plugin;
    }

    public boolean messageContainsCurses(String message){
        String suspect = SymbolConverter.deobfuscateSymbols(message);
        String curse_word = null;
        for (String curses : plugin.getConfig().getStringList("curse_words")){
            if (suspect.contains(curses)){
                curse_word = curses;
            }
        }
        if (curse_word != null){
            if (plugin.getConfig().get("curse_bypass." + curse_word) != null){
                for (String curse_bypasses : plugin.getConfig().getStringList("curse_bypass." + curse_word)){
                    suspect = suspect.replaceAll(curse_bypasses, "");
                }
            }
            if (suspect.contains(curse_word)){
                return true;
            }
        }else{
            String no_space = suspect.replaceAll(" ", "");
            for (String curses : plugin.getConfig().getStringList("curse_words")){
                if (no_space.contains(curses)){
                    curse_word = curses;
                }
            }
            if (curse_word != null){
                if (plugin.getConfig().get("curse_bypass." + curse_word) != null){
                    for (String curse_bypasses : plugin.getConfig().getStringList("curse_bypass." + curse_word)){
                        no_space = no_space.replaceAll(curse_bypasses, "");
                    }
                }
                if (no_space.contains(curse_word)){
                    return true;
                }
            }
        }
        return false;
    }
}
