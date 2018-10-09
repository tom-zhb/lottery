package com.bc.lottery.spider.api;

import com.bc.lottery.common.service.KuaiSanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(maxAge = 86400)
@RestController
@RequestMapping(value = "/test")
public class TestController {
    @Autowired
    KuaiSanService kuaiSanService;

    @RequestMapping(value = "/service", method = {RequestMethod.POST, RequestMethod.GET})
    public String enter() {
        System.out.println("============================");
        kuaiSanService.save(null);
        return "sss";
    }
}
