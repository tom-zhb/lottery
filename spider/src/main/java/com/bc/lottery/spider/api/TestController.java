package com.bc.lottery.spider.api;

import com.bc.lottery.common.domain.lottery.kuaisan.HubeiKS;
import com.bc.lottery.common.service.KuaiSanService;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@CrossOrigin(maxAge = 86400)
@RestController
@RequestMapping(value = "/test")
public class TestController {
    @Autowired
    KuaiSanService kuaiSanService;

    @RequestMapping(value = "/service", method = {RequestMethod.POST, RequestMethod.GET})
    public String enter() {
        System.out.println("============================");
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
        } catch (ParseException e) {
            e.printStackTrace();
        }
        kuaiSanService.save(hubeiKS);
        return "sss";
    }
}
