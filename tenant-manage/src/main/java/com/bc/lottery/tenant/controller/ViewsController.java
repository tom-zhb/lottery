package com.bc.lottery.tenant.controller;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/views")
public class ViewsController {

    @RequestMapping("/{path}")
    public String index11(@PathVariable String path) {
        String[] pathDirArr = StringUtils.split(path, "-");
        StringBuilder sb = new StringBuilder();
        if (ArrayUtils.isNotEmpty(pathDirArr)) {
            for (String pathDir : pathDirArr) {
                sb.append(pathDir).append("/");
            }
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}
