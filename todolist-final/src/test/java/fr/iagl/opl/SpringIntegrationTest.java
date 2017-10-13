package fr.iagl.opl;

import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringBootWebApplication.class, loader = SpringApplicationContextLoader.class)
@WebAppConfiguration
@IntegrationTest
public class SpringIntegrationTest {

}
