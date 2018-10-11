package main;

import net.dean.jraw.RedditClient;
import net.dean.jraw.http.NetworkAdapter;
import net.dean.jraw.http.OkHttpNetworkAdapter;
import net.dean.jraw.http.UserAgent;
import net.dean.jraw.oauth.Credentials;
import net.dean.jraw.oauth.OAuthHelper;

public class Main {
    public static RedditClient reddit;

    public static void main(String[] args) {
        if (args.length != 4) {
            System.out.println("need 4 input params");
            return;
        }
        UserAgent userAgent = new UserAgent("Reddistics", "com.github.phaserush", "v1.0-SNAPSHOT", "u/Positivelectron0");
        Credentials credentials = Credentials.script(args[0], args[1], args[2], args[3]);
        NetworkAdapter adapter = new OkHttpNetworkAdapter(userAgent);
        reddit = OAuthHelper.automatic(adapter, credentials);
    }
}
