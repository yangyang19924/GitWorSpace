package concurrent;

import com.yangyang.concurrent.Thread1;
import com.yangyang.concurrent.Thread2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by yangyang on 2018/8/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
public class TestConcurrentHashMap {

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Test
    public void testConcurrent() {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();

        threadPoolTaskExecutor.execute(thread1);
        threadPoolTaskExecutor.execute(thread2);

    }
}
