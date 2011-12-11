package com.colorcc.user.register.mapper;


import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAbstract {
	private static final Logger logger = LoggerFactory.getLogger(UserMapperTest.class);

	String configFile;
	ApplicationContext context;

	@Before
	public void init() {
		configFile = "WEB-INF/config/applicationContext.xml";
		logger.debug(configFile);
		context = new ClassPathXmlApplicationContext(new String[] {configFile});
	}
}
