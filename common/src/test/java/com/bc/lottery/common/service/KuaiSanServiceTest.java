package com.bc.lottery.common.service;

import com.bc.lottery.common.domain.lottery.HubeiKS;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;


@RunWith(SpringRunner.class)
@SpringBootTest
public class KuaiSanServiceTest {
    @Autowired
    KuaiSanService kuaiSanService;

    @Test
    public void saveTest() {
        HubeiKS hubeiKS = new HubeiKS();
        //AnhuiKS anhuiKS = new AnhuiKS();
        /*<row expect="180918078" opencode="6,4,3" opentime="2018-09-18 22:00:00"/>
        <row expect="180918077" opencode="1,2,3" opentime="2018-09-18 21:50:00"/>
        <row expect="180918076" opencode="4,3,3" opentime="2018-09-18 21:40:00"/>*/
        hubeiKS.setIssue("180918078");
        hubeiKS.setNumber("6,4,3");
        try {
            hubeiKS.setOpenTime(DateUtils.parseDate("2018-09-18 22:00:00",
                    "yyyy-MM-dd HH:mm:ss"));
            kuaiSanService.save(hubeiKS);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
