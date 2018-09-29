package com.bc.lottery.service;

import com.bc.lottery.domain.lottery.AnhuiKS;
import com.bc.lottery.domain.lottery.HubeiKS;
import com.bc.lottery.domain.lottery.KuaiSan;
import com.bc.lottery.mapper.lottery.HubeiKSMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class KuaiSanService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private HubeiKSMapper hubeiKSMapper;

    public int save(KuaiSan kuaiSan) {
        final KuaiSan useKuaiSan = trim(kuaiSan);
        if (kuaiSan instanceof HubeiKS) {
            hubeiKSMapper.insert((HubeiKS) useKuaiSan);
        } else if (kuaiSan instanceof AnhuiKS) {
        }
        return 0;
    }

    private KuaiSan trim(KuaiSan kuaiSan) {
        kuaiSan.setIssue(StringUtils.trim(kuaiSan.getIssue()));
        kuaiSan.setNumber(StringUtils.trim(kuaiSan.getNumber()));
        kuaiSan.setOpenTime(kuaiSan.getOpenTime());
        return kuaiSan;
    }
}
