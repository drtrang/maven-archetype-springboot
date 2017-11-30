package ${package}.test;

import ${package}.Application;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * SpringBaseTest
 *
 * @author trang
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = WebEnvironment.DEFINED_PORT)
public abstract class SpringBaseTest {

    protected static final Logger log = LoggerFactory.getLogger(SpringBaseTest.class);

}