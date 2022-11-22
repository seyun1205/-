package com.elephant.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * projectName: plm
 *
 * @author: chenguoquan
 * @since: 2022/8/11 14:17
 * description:mybatis-plus配置
 */
@Configuration
public class MyBatisConfig {

	/**
	 * 手动配置session工厂
	 *
	 * @param dataSource
	 * @return
	 * @throws Exception
	 */
	@Bean("db1SqlSessionFactory")
	@Primary
	public SqlSessionFactory db1SqlSessionFactory(DataSource dataSource) throws Exception {
		MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
		//手动设置session工厂时，需要手动添加分页插件
		Interceptor[] plugins = new Interceptor[1];
		plugins[0] = mybatisPlusInterceptor();
		bean.setPlugins(plugins);
		return bean.getObject();
	}


	/**
	 * 添加分页插件拦截器
	 *
	 * @return
	 */
	@Bean("pageInterceptor")
	public MybatisPlusInterceptor mybatisPlusInterceptor() {
		MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
		interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
		return interceptor;
	}


}