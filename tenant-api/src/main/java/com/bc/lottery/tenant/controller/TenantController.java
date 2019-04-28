package com.bc.lottery.tenant.controller;

import com.bc.lottery.common.dto.JsonResultModel;
import com.bc.lottery.common.service.tenant.TenantService;
import com.bc.lottery.tenant.vo.RegisterVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/mappers/tenant/admin")
public class TenantController {
    @Resource
    TenantService tenantService;


    @PostMapping(value="/login")
    public JsonResultModel login(RegisterVo registerVo) {
        if (!"123".equalsIgnoreCase(registerVo.getCaptcha())) {
            return JsonResultModel.fail();
        }

        boolean flag = tenantService.login(registerVo.userName, registerVo.password);
        if (flag) {
            return JsonResultModel.sucess();
        }
        return JsonResultModel.fail();

    }

}
