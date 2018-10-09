package com.bc.lottery.common.configuration.mybatis;

import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.util.Properties;

abstract class AbstractBaseDataSourceConfig {

    public SqlSessionFactory sqlSessionFactory(DataSource dataSource, String domainPackage,
                                               String mapperLocation) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setTypeAliasesPackage(domainPackage);
        //分页插件设置
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("returnPageInfo", "check");
        properties.setProperty("params", "count=countSql");
        pageHelper.setProperties(properties);
        //添加分页插件
        bean.setPlugins(new Interceptor[]{pageHelper});
        bean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);

        //添加XML目录
        //ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            //bean.setMapperLocations(resolver.getResources(mapperLocation));
            return bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
