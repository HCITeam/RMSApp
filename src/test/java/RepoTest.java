import dao.RepoDAO;
import dao.UserDAO;
import entity.Repo;
import entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import util.Constant;
import util.enums.RepoSortType;

import java.util.*;

/**
 * Created by chenm on 2016/5/10.
 */
public class RepoTest extends BaseTest {
    @Autowired
    RepoDAO repoDAO;

    @Test
    public void test() {
        List<Repo> ger = repoDAO.getRepoList("", RepoSortType.GENERAL, 1);
        ger.forEach(repo -> System.out.println(repo.getFullName()));
//        System.out.println(repoDAO.getCounts());
    }

    @Test
    public void repoTest() {
        List<Repo> repos = repoDAO.getRepoList("", RepoSortType.GENERAL, 1);
        System.out.println(repos);
    }

}