package com.bc.lottery.common.configuration.mybatis;

import com.bc.lottery.common.core.mapper.BaseMapper;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import java.util.Properties;

abstract class AbstracBaseMapperScannerConfig {

    public MapperScannerConfigurer dataSourceConfiger(String basePackage, String sqlSessionFactoryBeanName) {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName(sqlSessionFactoryBeanName);
        mapperScannerConfigurer.setBasePackage(basePackage);
        Properties properties = new Properties();
        // 这里要特别注意，不要把BaseMapper放到 basePackage 中，也就是不能同其他Mapper一样被扫描到。
        properties.setProperty("mappers", BaseMapper.class.getName());
        properties.setProperty("notEmpty", "false");
        properties.setProperty("IDENTITY", "MYSQL");
        mapperScannerConfigurer.setProperties(properties);
        return mapperScannerConfigurer;
    }
}
