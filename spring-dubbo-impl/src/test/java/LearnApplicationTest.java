import com.pupu.search.learn.impl.LearnApplication;
import com.pupu.search.learn.impl.demo.InjectBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LearnApplication.class)
public class LearnApplicationTest {

    @Resource(name = "ddd")
    InjectBean myBean1;

    @Autowired
    InjectBean myBean2;

    @Test
    public void contextLoads() {
        System.err.println(myBean1);
        System.err.println(myBean2);

    }
}
