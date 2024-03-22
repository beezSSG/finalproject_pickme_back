package com.pickme.beeze;

import java.util.Date;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource("classpath:/application.properties") // 기본 경로에 있는 application.properties 를 불러들여라
public class DatabaseConfig {

	@Bean // 자동 생성해라!
	@ConfigurationProperties(prefix = "spring.datasource.hikari")	
	public HikariConfig hikariConfig() {	// HikariConfig 함수 생성
		return new HikariConfig();
	}
	
	@Bean
	public DataSource dataSource() {
		DataSource dataSource = new HikariDataSource(hikariConfig());
		System.out.println("DataSource 정상 실행! : " + dataSource);
		return dataSource;
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource datasource) throws Exception {
		System.out.println("SqlSessionFactory 정상 실행!");
		
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(datasource);
		
		Resource[] arrResource = new PathMatchingResourcePatternResolver().getResources("classpath:sqls/*.xml");
		sqlSessionFactoryBean.setMapperLocations(arrResource);
		
		// @alias 설정시 위치는 여기!
		// 아래에 alias를 설정할 dto 위치를 , 를 통하여 이어줘야 에러가 나지 않는다.
		sqlSessionFactoryBean.setTypeAliasesPackage("com.pickme.beeze.mypage.dto, com.pickme.beeze.login.dto, com.pickme.beeze.customer.dto");	
//		sqlSessionFactoryBean.setTypeAliasesPackage("com.pickme.beeze.login.dto");	// 이렇게 여러개 설정시 에러가 난다		
		sqlSessionFactoryBean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
		
		return (SqlSessionFactory)sqlSessionFactoryBean.getObject();
	}
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		System.out.println("DatabaseConfig sqlSessionTemplate " + new Date());
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	
	// callback function : 자동으로 실행되는 함수
}
