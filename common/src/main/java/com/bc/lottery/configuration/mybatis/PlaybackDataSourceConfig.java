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
public class PlaybackDataSourceConfig extends AbstractBaseDataSourceConfig {
    // 精确到  目录，以便跟其他数据源隔离
    static final String PACKAGE = "com.sayabc.onlineclassroom.classroom.domain.playback";
    static final String BASE_PACKAGE = "com.sayabc.onlineclassroom.classroom.mapper.playback";
    static final String MAPPER_LOCATION = "classpath:mappers/playback/*.xml";


    @Value("${spring.datasource.playback.url}")
    private String url;

    @Value("${spring.datasource.playback.username}")
    private String user;

    @Value("${spring.datasource.playback.password}")
    private String password;

    @Value("${spring.datasource.playback.driverClassName}")
    private String driverClass;

    @Bean(name = "playbackDataSource")
    public DataSource playbackDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "playbackTransactionManager")
    public DataSourceTransactionManager playbackTransactionManager() {
        return new DataSourceTransactionManager(playbackDataSource());
    }

    @Bean(name = "playbackSqlSessionFactory")
    public SqlSessionFactory playbackSqlSessionFactory(@Qualifier("playbackDataSource") DataSource playbackDataSource) throws Exception{
        return super.sqlSessionFactory(playbackDataSource, PACKAGE, MAPPER_LOCATION);
    }
}
