package main.niche;

import main.Main;
import main.utility.BotUtils;
import net.dean.jraw.models.Submission;
import net.dean.jraw.models.Subreddit;
import net.dean.jraw.pagination.DefaultPaginator;

import java.util.ArrayList;
import java.util.List;

public class Wallpapers {
    List<Subreddit> subs;

    public Wallpapers(List<Subreddit> subs) {
        this.subs = subs;
    }

    public List<String> getWallpapers() {
        DefaultPaginator<Submission> picSubs = Main.reddit.subreddits("EarthPorn", "SpacePorn", "ImaginarySliceOfLife").posts().build();
        List<String> imageUrls = new ArrayList<>();

        for (Submission s : picSubs.next()) {
            if (!s.isSelfPost() && BotUtils.validUrl(s)) {
                imageUrls.add(s.getUrl());
            }
        }

        return imageUrls;
    }


}
