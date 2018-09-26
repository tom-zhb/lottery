package com.bc.lottery.configuration.mybatis;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@SuppressWarnings("All")
@Configuration
@EnableTransactionManagement
public class ScalperDataSourceConfig extends  AbstractBaseDataSourceConfig{
    // 精确到  目录，以便跟其他数据源隔离
    static final String PACKAGE = "com.sayabc.onlineclassroom.classroom.domain.scalper";
    static final String BASE_PACKAGE = "com.sayabc.onlineclassroom.classroom.mapper.scalper";
    static final String MAPPER_LOCATION = "classpath:mappers/scalper/*.xml";



    @Value("${spring.datasource.scalper.url}")
    private String url;

    @Value("${spring.datasource.scalper.username}")
    private String user;

    @Value("${spring.datasource.scalper.password}")
    private String password;

    @Value("${spring.datasource.scalper.driverClassName}")
    private String driverClass;
    @Primary
    @Bean(name = "scalperDataSource")
    public DataSource scalperDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }
    @Primary
    @Bean(name = "scalperTransactionManager")
    public DataSourceTransactionManager scalperTransactionManager() {
        return new DataSourceTransactionManager(scalperDataSource());
    }
    @Primary
    @Bean(name = "scalperSqlSessionFactory")
    public SqlSessionFactory scalperSqlSessionFactory(@Qualifier("scalperDataSource") DataSource scalperDataSource) throws Exception{
        return super.sqlSessionFactory(scalperDataSource, PACKAGE, MAPPER_LOCATION);
    }

}
