package com.bc.lottery.tenant.controller;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/views")
public class ViewsController {

    @RequestMapping("/**")
    public String index1(HttpServletRequest request) {
        return request.getRequestURI().replace(request.getContextPath()+"/views/", "");
    }
}
