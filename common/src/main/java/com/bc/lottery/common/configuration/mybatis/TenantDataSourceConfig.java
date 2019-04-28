package com.bc.lottery.common.configuration.mybatis;

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
public class TenantDataSourceConfig extends AbstractBaseDataSourceConfig{
    // 精确到  目录，以便跟其他数据源隔离
    static final String PACKAGE = "com.bc.lottery.common.domain.tenant";
    static final String BASE_PACKAGE = "com.bc.lottery.common.mapper.tenant";
    static final String MAPPER_LOCATION = "classpath:mappers/tenant/*.xml";



    @Value("${spring.datasource.tenant.url}")
    private String url;

    @Value("${spring.datasource.tenant.username}")
    private String user;

    @Value("${spring.datasource.tenant.password}")
    private String password;

    @Value("${spring.datasource.tenant.driverClassName}")
    private String driverClass;

    @Bean(name = "tenantDataSource")
    @Primary
    public DataSource tenantDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "tenantTransactionManager")
    @Primary
    public DataSourceTransactionManager tenantTransactionManager() {
        return new DataSourceTransactionManager(tenantDataSource());
    }

    @Bean(name = "tenantSqlSessionFactory")
    @Primary
    public SqlSessionFactory tenantSqlSessionFactory(@Qualifier("tenantDataSource") DataSource tenantDataSource) throws Exception{
        return super.sqlSessionFactory(tenantDataSource, PACKAGE, MAPPER_LOCATION);
    }

}
