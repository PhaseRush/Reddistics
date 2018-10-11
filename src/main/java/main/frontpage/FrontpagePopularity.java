package main.frontpage;

import main.Main;
import net.dean.jraw.models.Submission;
import net.dean.jraw.models.SubredditSort;
import net.dean.jraw.models.TimePeriod;
import net.dean.jraw.pagination.DefaultPaginator;

import java.util.List;

public class FrontpagePopularity {
    private int totalUpVotes = 0;
    private int totalComments = 0;

    public FrontpagePopularity() {

    }

    public void scrape() {
        DefaultPaginator<Submission> frontPage = Main.reddit.frontPage()
                .sorting(SubredditSort.TOP)
                .timePeriod(TimePeriod.ALL)
                .limit(100)
                .build();

        List<Submission> subs = frontPage.next();
        for (Submission s : subs) {
            totalComments += s.getCommentCount();
        }
    }
}
