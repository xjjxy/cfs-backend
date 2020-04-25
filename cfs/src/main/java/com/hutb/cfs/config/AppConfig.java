package com.hutb.cfs.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.VersionResourceResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.hutb.cfs.basedao.BaseDao;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = { "com.hutb.cfs" })
@EnableWebMvc
@PropertySource("classpath:admin.properties")
@PropertySources({ @PropertySource("classpath:admin.properties"), 
    @PropertySource("classpath:jdbc.properties") })
@MapperScan(basePackages = {"com.hutb.cfs"},markerInterface=BaseDao.class)
public class AppConfig implements WebMvcConfigurer {

//	
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.username}")
	private String username;
	@Value("${jdbc.className}")
	private String driverClass;
	@Value("${jdbc.password}")
	private String password;

	public AppConfig() {
		System.out.println("AppConfig()----");
	}
	
	@Bean
	public DataSource dataSource() {
		System.out.println("dataSource");
		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setJdbcUrl(url);
		dataSource.setUsername(username);
		dataSource.setDriverClassName(driverClass);
		dataSource.setPassword(password);
		return dataSource;
	}
//	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception{
		System.out.println("sqlSessionFactory");
		SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
		ssfb.setDataSource(dataSource());
		return ssfb.getObject();
	}

	// 静态资源
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		System.out.println("addResourceHandlers");
		registry.addResourceHandler("/htmls/**").addResourceLocations("/htmls/").resourceChain(true)
				.addResolver(new VersionResourceResolver().addContentVersionStrategy("/**"));
		registry.addResourceHandler("/**").addResourceLocations("/static/").resourceChain(true)
		.addResolver(new VersionResourceResolver().addContentVersionStrategy("/**"));
	}

	@Bean
	public CommonsMultipartResolver multipartResolver() {
		System.out.println("CommonsMultipartResolver--");
		return new CommonsMultipartResolver();
	}
	
	// 视图转发
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// TODO Auto-generated method stub
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");
		registry.viewResolver(viewResolver);
	}

}
