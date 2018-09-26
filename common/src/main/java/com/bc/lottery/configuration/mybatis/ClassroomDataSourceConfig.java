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
public class ClassroomDataSourceConfig extends AbstractBaseDataSourceConfig{
    // 精确到  目录，以便跟其他数据源隔离
    static final String PACKAGE = "com.sayabc.onlineclassroom.classroom.domain.classroom";
    static final String BASE_PACKAGE = "com.sayabc.onlineclassroom.classroom.mapper.classroom";
    static final String MAPPER_LOCATION = "classpath:mappers/classroom/*.xml";



    @Value("${spring.datasource.classroom.url}")
    private String url;

    @Value("${spring.datasource.classroom.username}")
    private String user;

    @Value("${spring.datasource.classroom.password}")
    private String password;

    @Value("${spring.datasource.classroom.driverClassName}")
    private String driverClass;

    @Bean(name = "classroomDataSource")
    public DataSource classroomDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "classroomTransactionManager")
    public DataSourceTransactionManager classroomTransactionManager() {
        return new DataSourceTransactionManager(classroomDataSource());
    }

    @Bean(name = "classroomSqlSessionFactory")
    public SqlSessionFactory classroomSqlSessionFactory(@Qualifier("classroomDataSource") DataSource classroomDataSource) throws Exception{
        return super.sqlSessionFactory(classroomDataSource, PACKAGE, MAPPER_LOCATION);
    }

}
