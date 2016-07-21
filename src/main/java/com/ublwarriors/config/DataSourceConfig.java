package com.ublwarriors.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.github.pagehelper.PageHelper;
@Configuration
@EnableTransactionManagement
public class DataSourceConfig {
	@Value("${spring.datasource.driver-class-name}")
	private String DB_DRIVER;
	
	@Value("${spring.datasource.username}")
	private String DB_USERNAME;
	
	@Value("${spring.datasource.password}")
	private String DB_PASSWORD;
	
	@Value("${spring.datasource.url}")
	private String DB_URL;
	
	@Bean(name="dataSource")
	@Primary
	public DataSource registerDataSource()
	{
		DriverManagerDataSource dataSource = null;
		try{
			dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName(DB_DRIVER);
			dataSource.setUsername(DB_USERNAME);
			dataSource.setPassword(DB_PASSWORD);
			dataSource.setUrl(DB_URL);
		}catch(Exception e)
		{
			e.getMessage();
		}
		return dataSource;
	}
	
	@Bean
	public PlatformTransactionManager txManager()
	{
		return new DataSourceTransactionManager(registerDataSource());
	}
	
	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactoryBean() throws Exception
	{
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(registerDataSource());;
        sqlSessionFactoryBean.setTypeAliasesPackage("com.ublwarriors.guacamole.model");
        
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("returnPageInfo", "check");
        properties.setProperty("params", "count=countSql");
        pageHelper.setProperties(properties);
        
      //添加插件
        sqlSessionFactoryBean.setPlugins(new Interceptor[]{pageHelper});
 
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
 
        sqlSessionFactoryBean.setMapperLocations(resolver
                .getResources("classpath:com/ublwarriors/guacamole/mapper/*.xml"));
        return sqlSessionFactoryBean.getObject();
	}
	
	
	
	
	@Bean (name="sqlSession")
	public SqlSessionTemplate getSqlSession() throws Exception
	{
		SqlSessionTemplate sqlSession = new SqlSessionTemplate(sqlSessionFactoryBean(), ExecutorType.BATCH);
		return sqlSession;
	}
}
