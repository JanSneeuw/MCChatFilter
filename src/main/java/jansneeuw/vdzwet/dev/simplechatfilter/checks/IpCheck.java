package jansneeuw.vdzwet.dev.simplechatfilter.checks;

import org.bukkit.ChatColor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IpCheck {

    private Pattern pattern;
    private Matcher matcher;

    private static final String IPADDRESS_PATTERN =
            "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

    public IpCheck(){
        pattern = Pattern.compile(IPADDRESS_PATTERN);
    }

    public boolean messageContainsIp(String message){
        for (String messagesub : ChatColor.stripColor(message).split(" ")){
            if (pattern.matcher(messagesub).matches()){
                return true;
            }
        }
        return false;
    }

}
