package cz.xfabian.topicso;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LauncherTests {

	@Autowired
	private DataFillerTests dataFiller;

	@Test
	void contextLoads() {
		dataFiller.fillData();
	}
}
