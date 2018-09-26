package com.bc.lottery.service;

import com.bc.lottery.domain.lottery.AnhuiKS;
import com.bc.lottery.domain.lottery.HubeiKS;
import com.bc.lottery.domain.lottery.KuaiSan;
import com.bc.lottery.mapper.lottery.HubeiKSMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class KuaiSanService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private HubeiKSMapper hubeiKSMapper;

    public int save(KuaiSan kuaiSan) {
        if (kuaiSan instanceof HubeiKS) {
            hubeiKSMapper.insert((HubeiKS) kuaiSan);
        } else if (kuaiSan instanceof AnhuiKS) {
            System.out.println("AnhuiKSAnhuiKSAnhuiKS");
        }
        return 0;
    }
}
