package com.bc.lottery.spider.job.kuaisan;

import com.bc.lottery.spider.SpiderBoot;
import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.dangdang.elasticjob.lite.annotation.ElasticSimpleJob;
import org.springframework.stereotype.Component;

@ElasticSimpleJob(cron = "0/30 * * * * ?", jobName = "kuaisan", shardingTotalCount = 1)
@Component
public class HubeiKSJob implements SimpleJob {

    @Override
    public void execute(ShardingContext shardingContext) {
        SpiderBoot.getInstance().kuaisanStart();
    }
}