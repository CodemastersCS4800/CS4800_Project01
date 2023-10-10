package com.javaguides.springboot;

import static org.junit.jupiter.api.Assertions.assertTrue; 
import static org.assertj.core.api.Assertions.assertThat;
import com.javaguides.springboot.WelcomeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = SpringbootFirstAppApplication.class)
class SpringbootFirstAppApplicationTests {

	@Autowired
	private WelcomeController wc;

	@Test
	public void contextLoads() throws Exception{
		 assertThat(wc).isNotNull();
	}
}
