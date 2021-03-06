package com.bc.lottery.common.configuration.mybatis;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

@Configuration
//TODO 注意，由于MapperScannerConfigurer执行的比较早，所以必须有下面的注解
@AutoConfigureAfter(LotteryDataSourceConfig.class)
public class LotteryMapperScannerConfig extends AbstracBaseMapperScannerConfig {
    @Bean
    public MapperScannerConfigurer lotteryDataSourceConfiger() {
        return super.dataSourceConfiger(LotteryDataSourceConfig.BASE_PACKAGE, "lotterySqlSessionFactory");
    }
}
