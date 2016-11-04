import dao.CommitDAO;
import dao.RepoDAO;
import dao.UserDAO;
import entity.Commit;
import entity.ContributorCommits;
import entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import service.RepoStatisticService;
import service.UserService;
import vo.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by raychen on 16/5/15.
 */
public class ServiceTest extends BaseTest{
    @Autowired
    private UserService userService;
    @Autowired
    private UserDAO userDao;
    @Autowired
    private RepoStatisticService repoStatService;
    @Autowired
    private CommitDAO commitDAO;

    @Test
    public void showUser() throws Exception {
        UserVO user = userService.showUser("sj26");
        System.out.println(user.name);
    }

    @Test
    public void repoRadar() throws Exception {
        List<RadarVO> radar = repoStatService.getRadar("mojombo/grit");
        System.out.println(radar.size());
        radar.forEach(e -> System.out.println(e.getValue()));
    }

    @Test
    public void languageRate() throws Exception {
        List<LanguageVO> rates = repoStatService.getRepoLanguage("jquery/jquery");
        rates.forEach(rate -> {
            System.out.println("language rates:"+rate.getLanguage_name()+" "+rate.getRate());
        });
    }

    @Test
    public void commits() throws Exception {
        List<ContributorCommitsVO> commits = repoStatService.getCommitsContributors("mojombo/grit");
        System.out.println("all size:"+commits.size());
        commits.forEach(commit -> {
            List<CommitVO> vos = commit.getCommits();
            System.out.println("--"+vos.size());
        });
    }

    @Test
    public void adtime() throws Exception {
        List<CommitVO> ads = repoStatService.getCommitsRepo("mojombo/grit");
//        List<Commit> addaos = commitDAO.getCommitsByRepo("mojombo/grit");
        ads.forEach(ad -> {
//            Date date = ad.time;
            Calendar cal = ad.time;
//            Date date = new Date(ad.getWeek()*1000);
            System.out.println(cal.get(Calendar.YEAR)+" "+cal.get(Calendar.DATE));
        });
    }
}
