import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2018/7/21.
 */
public class TestJava {

    private static final Logger logger = LoggerFactory.getLogger(TestJava.class);
    public static void main(String[] args) {
        logger.debug("test print out debug");
        logger.info("test print out info");
        logger.error("test print out error");
        logger.warn("test print out warning");

    }
}
