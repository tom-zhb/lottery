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
public class LotteryDataSourceConfig extends AbstractBaseDataSourceConfig{
    // 精确到  目录，以便跟其他数据源隔离
    static final String PACKAGE = "com.bc.lottery.domain.lottery";
    static final String BASE_PACKAGE = "com.bc.lottery.mapper.lottery";
    static final String MAPPER_LOCATION = "classpath:mappers/lottery/*.xml";



    @Value("${spring.datasource.lottery.url}")
    private String url;

    @Value("${spring.datasource.lottery.username}")
    private String user;

    @Value("${spring.datasource.lottery.password}")
    private String password;

    @Value("${spring.datasource.lottery.driverClassName}")
    private String driverClass;

    @Bean(name = "lotteryDataSource")
    public DataSource lotteryDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "lotteryTransactionManager")
    public DataSourceTransactionManager lotteryTransactionManager() {
        return new DataSourceTransactionManager(lotteryDataSource());
    }

    @Bean(name = "lotterySqlSessionFactory")
    public SqlSessionFactory lotterySqlSessionFactory(@Qualifier("lotteryDataSource") DataSource lotteryDataSource) throws Exception{
        return super.sqlSessionFactory(lotteryDataSource, PACKAGE, MAPPER_LOCATION);
    }

}
