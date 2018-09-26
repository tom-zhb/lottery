package com.bc.lottery.service;

import com.bc.lottery.domain.lottery.AnhuiKS;
import com.bc.lottery.domain.lottery.HubeiKS;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KuaiSanServiceTest {
    @Autowired
    KuaiSanService kuaiSanService;

    @Test
    public void saveTest() {
        //HubeiKS hubeiKS = new HubeiKS();
        AnhuiKS anhuiKS = new AnhuiKS();
        kuaiSanService.save(anhuiKS);
    }
}
