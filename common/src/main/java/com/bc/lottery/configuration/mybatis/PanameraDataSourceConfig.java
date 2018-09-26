package com.bc.lottery.configuration.mybatis;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@SuppressWarnings("All")
@Configuration
@EnableTransactionManagement
public class PanameraDataSourceConfig  extends AbstractBaseDataSourceConfig{
    // 精确到  目录，以便跟其他数据源隔离
    static final String PACKAGE = "com.sayabc.onlineclassroom.classroom.domain.panamera";
    static final String BASE_PACKAGE = "com.sayabc.onlineclassroom.classroom.mapper.panamera";
    static final String MAPPER_LOCATION = "classpath:mappers/panamera/*.xml";



    @Value("${spring.datasource.oauth.url}")
    private String url;

    @Value("${spring.datasource.oauth.username}")
    private String user;

    @Value("${spring.datasource.oauth.password}")
    private String password;

    @Value("${spring.datasource.oauth.driverClassName}")
    private String driverClass;

    @Bean(name = "panameraDataSource")
    public DataSource panameraDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "panameraTransactionManager")
    public DataSourceTransactionManager panameraTransactionManager() {
        return new DataSourceTransactionManager(panameraDataSource());
    }

    @Bean(name = "panameraSqlSessionFactory")
    public SqlSessionFactory panameraSqlSessionFactory(@Qualifier("panameraDataSource") DataSource panameraDataSource) throws Exception{
        return super.sqlSessionFactory(panameraDataSource, PACKAGE, MAPPER_LOCATION);
    }

}
