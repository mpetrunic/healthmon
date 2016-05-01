package hr.fer.zpr.marinpetrunic.healthmon;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HealthmonApplication.class)
@WebAppConfiguration
public class HealthmonApplicationTests {

	@Test
	public void contextLoads() {
	}

}
