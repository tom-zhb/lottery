package com.bc.lottery.configuration.mybatis;


import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

@Configuration
//TODO 注意，由于MapperScannerConfigurer执行的比较早，所以必须有下面的注解
@AutoConfigureAfter(PlaybackDataSourceConfig.class)
public class PlaybackMapperScannerConfig extends AbstracBaseMapperScannerConfig {

    @Bean
    public MapperScannerConfigurer playbackDataSourceConfiger() {
        return super.dataSourceConfiger(PlaybackDataSourceConfig.BASE_PACKAGE, "playbackSqlSessionFactory");
    }
}
