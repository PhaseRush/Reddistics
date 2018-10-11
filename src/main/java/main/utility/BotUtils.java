package main.utility;

import net.dean.jraw.models.Submission;

public class BotUtils {
    public static boolean validUrl(Submission s) {
        String url = s.getUrl();

        return url.contains("i.imgur.com") || url.contains("i.redd.it") || url.contains("artstation.com") || url.contains("deviantart.net");
    }
}
