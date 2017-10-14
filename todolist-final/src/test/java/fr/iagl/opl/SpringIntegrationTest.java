package fr.iagl.opl;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = SpringBootWebApplication.class, loader = SpringApplicationContextLoader.class)
@SpringBootTest(classes = SpringBootWebApplication.class)
@WebAppConfiguration
//@IntegrationTest
@TestPropertySource(locations="classpath:test.properties")
public class SpringIntegrationTest {

}
