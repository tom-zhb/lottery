/*
package com.bc.lottery.spider.job;

import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.lite.spring.api.SpringJobScheduler;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


public class JobConfig {

    //@Autowired
    //private JobRegistryCenterConfig jobRegistryCenterConfig;

    public SpringJobScheduler configJob(final SimpleJob simpleJob,
                                        //@Value("${elasticJob.stockJob.cron}")
                                        final String cron,
                                        //@Value("${elasticJob.stockJob.shardingTotalCount}")
                                        final int shardingTotalCount,
                                        //@Value("${elasticJob.stockJob.shardingItemParameters}")
                                        final String shardingItemParameters,
                                        final ZookeeperRegistryCenter regCenter) {
        return new SpringJobScheduler(simpleJob, regCenter,
                getLiteJobConfiguration(simpleJob.getClass(), cron,
                        shardingTotalCount,
                        shardingItemParameters));
    }

    */
/**
     * @Description 任务配置类
     *//*

    private LiteJobConfiguration getLiteJobConfiguration(final Class<? extends SimpleJob> jobClass,
                                                         final String cron,
                                                         final int shardingTotalCount,
                                                         final String shardingItemParameters) {

        return LiteJobConfiguration.newBuilder(
                new SimpleJobConfiguration(
                        JobCoreConfiguration.newBuilder(
                                jobClass.getName(), cron, shardingTotalCount)
                                .shardingItemParameters(shardingItemParameters)
                                .build()
                        , jobClass.getCanonicalName()
                )
        ).overwrite(true).build();

    }
}*/
