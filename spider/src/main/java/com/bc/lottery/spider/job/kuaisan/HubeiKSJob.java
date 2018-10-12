package com.bc.lottery.spider.job.kuaisan;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.dangdang.elasticjob.lite.annotation.ElasticSimpleJob;
import org.springframework.stereotype.Component;

@ElasticSimpleJob(cron = "0/5 * * * * ?", jobName = "test123", shardingTotalCount = 2,
                  jobParameter = "测试参数", shardingItemParameters = "0=A,1=B")
@Component
public class HubeiKSJob implements SimpleJob {

    @Override
    public void execute(ShardingContext shardingContext) {
        System.out.println("=================================");
        System.out.println("=================================");
        System.out.println("=================================");
        System.out.println("=================================");
    }
}