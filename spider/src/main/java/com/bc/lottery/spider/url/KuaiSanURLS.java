package com.bc.lottery.spider.url;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ConfigurationProperties(prefix = "site.kuaisan")
public class KuaiSanURLS {

    private String hubei;

    private String anhui;

    private String jiangsu;

    private String guangxi;

    private String neimenggu;

    private String beijing;

    private String hebei;

    private String shagnhai;

    private String gansu;

    private String jilin;

}
