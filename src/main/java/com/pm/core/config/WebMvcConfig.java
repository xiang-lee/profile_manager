package com.pm.core.config;

import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.http.MediaType;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.accept.ContentNegotiationManagerFactoryBean;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.pm.aspect.LoggingAspect;
import com.pm.core.dao.GroupDao;
import com.pm.core.dao.UserDao;
import com.pm.core.dao.impl.GroupDaoImpl;
import com.pm.core.dao.impl.UserDaoImpl;
import com.pm.core.service.GroupService;
import com.pm.core.service.UserService;
import com.pm.core.service.impl.GroupServiceImpl;
import com.pm.core.service.impl.UserServiceImpl;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Bean
	public UserService userService() {
		return new UserServiceImpl();
	}

	@Bean
	public LoggingAspect loggingAspect() {
		return new LoggingAspect();
	}

	//use autowire type : byname, need to use function name in @Qualifier("createUserDao") in UserServiceImpl.java
	@Bean
	public UserDao userDao() {
		return new UserDaoImpl();
	}

	
	@Bean
	public GroupDao groupDao() {
		return new GroupDaoImpl();
	}

	@Bean
	public GroupService groupService() {
		return new GroupServiceImpl();
	}

	/*
	 * multipartResolver
	 */
	// @Bean
	// public MultipartResolver multipartResolver() {
	// CommonsMultipartResolver resolver = new CommonsMultipartResolver();
	// resolver.setMaxUploadSize(10000000); //10MB
	// return resolver;
	// }

	/*
	 * Spring MVC 3.1.x request mapping to URLs with a trailing .xxx (in a path
	 * vari able)
	 */
	@Bean
	public static BeanPostProcessor beanPostProcessor() {
		return new DoNotTruncateMyUrls();
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public SessionFactory sessionFactory() throws PropertyVetoException,
			SQLException {
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(
				dataSource());
		builder.scanPackages("com.pm.core.model").addProperties(
				getHibernateProperties());
		return builder.buildSessionFactory();
	}

	private Properties getHibernateProperties() {
		Properties prop = new Properties();
		prop.put("hibernate.format_sql", "true");
		prop.put("hibernate.show_sql", "true");
		prop.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		prop.put("hibernate.connection.useUnicode", "true");
		prop.put("hibernate.connection.characterEncoding", "true");
		prop.put("hibernate.connection.charSet", "true");

		return prop;
	}

	@Bean(name = "dataSource")
	public ComboPooledDataSource dataSource() throws PropertyVetoException,
			SQLException {

		ComboPooledDataSource cpd = new ComboPooledDataSource();
		cpd.setDriverClass("com.mysql.jdbc.Driver");

		// local host
		cpd.setJdbcUrl("jdbc:mysql://localhost:3306/profilemanager");
		cpd.setUser("root");
		cpd.setPassword("xiang55");

		// configure c3p0
		cpd.setMinPoolSize(5);
		cpd.setMaxPoolSize(20);
		cpd.setLoginTimeout(600);
		cpd.setMaxStatements(0);
		cpd.setIdleConnectionTestPeriod(300);
		cpd.setAcquireIncrement(1);

		// cpd.setMaxStatementsPerConnection(100);
		// cpd.setMaxIdleTime(60);

		return cpd;
	}

	@Bean
	public HibernateTransactionManager txManager()
			throws PropertyVetoException, SQLException {
		return new HibernateTransactionManager(sessionFactory());
	}

	@Bean
	public ContentNegotiatingViewResolver contentViewResolver()
			throws Exception {
		ContentNegotiationManagerFactoryBean contentNegotiationManager = new ContentNegotiationManagerFactoryBean();
		contentNegotiationManager.addMediaType("json",
				MediaType.APPLICATION_JSON);

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");

		MappingJackson2JsonView defaultView = new MappingJackson2JsonView();
		defaultView.setExtractValueFromSingleKeyModel(true);

		ContentNegotiatingViewResolver contentViewResolver = new ContentNegotiatingViewResolver();
		contentViewResolver
				.setContentNegotiationManager(contentNegotiationManager
						.getObject());
		contentViewResolver.setViewResolvers(Arrays
				.<ViewResolver> asList(viewResolver));
		contentViewResolver.setDefaultViews(Arrays.<View> asList(defaultView));
		return contentViewResolver;
	}

	@Override
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
}
