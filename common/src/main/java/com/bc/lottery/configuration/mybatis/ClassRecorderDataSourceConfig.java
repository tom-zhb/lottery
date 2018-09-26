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
public class ClassRecorderDataSourceConfig extends AbstractBaseDataSourceConfig {

    // 精确到  目录，以便跟其他数据源隔离
    static final String PACKAGE = "com.sayabc.onlineclassroom.classroom.domain.classrecorder";
    static final String BASE_PACKAGE = "com.sayabc.onlineclassroom.classroom.mapper.classrecorder";
    static final String MAPPER_LOCATION = "classpath:mappers/classrecorder/*.xml";

    @Value("${spring.datasource.classrecorder.url}")
    private String url;

    @Value("${spring.datasource.classrecorder.username}")
    private String user;

    @Value("${spring.datasource.classrecorder.password}")
    private String password;

    @Value("${spring.datasource.classrecorder.driverClassName}")
    private String driverClass;

    @Bean(name = "classRecorderDataSource")
    public DataSource classRecorderDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "classRecorderTransactionManager")
    public DataSourceTransactionManager classRecorderTransactionManager() {
        return new DataSourceTransactionManager(classRecorderDataSource());
    }

    @Bean(name = "classRecorderSqlSessionFactory")
    public SqlSessionFactory classRecorderSqlSessionFactory(@Qualifier("classRecorderDataSource") DataSource classRecorderDataSource) throws Exception{
        return super.sqlSessionFactory(classRecorderDataSource, PACKAGE, MAPPER_LOCATION);
    }

}
