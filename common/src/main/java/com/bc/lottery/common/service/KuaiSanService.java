package com.bc.lottery.common.service;

import com.bc.lottery.common.domain.lottery.AnhuiKS;
import com.bc.lottery.common.domain.lottery.HubeiKS;
import com.bc.lottery.common.domain.lottery.KuaiSan;
import com.bc.lottery.common.enums.LotteryTypeEnum;
import com.bc.lottery.common.mapper.lottery.HubeiKSMapper;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

    public int save(LotteryTypeEnum typeEnum, List<Map<String, Object>> maplist) {
        try {
            List kuaiSanList = convertKuaisan(maplist);
            if (CollectionUtils.isNotEmpty(kuaiSanList)) {
                if (typeEnum.equals(LotteryTypeEnum.KuaiSan.HUBEI)) {
                    hubeiKSMapper.insertList((List<HubeiKS>)kuaiSanList);
                }
            }
        } catch (ParseException e) {
            logger.error("save kuaisan error", e);
        }
        return 0;
    }

    private List convertKuaisan(List<Map<String, Object>> maplist) throws ParseException {
        List<KuaiSan> kuaiSanList = null;
        if (CollectionUtils.isNotEmpty(maplist)) {
            kuaiSanList = new ArrayList<>();
            for (Map<String, Object> map : maplist) {
                if (map != null) {
                    KuaiSan kuaiSan = new KuaiSan();
                    kuaiSan.setIssue(map.get("issue") + "");
                    kuaiSan.setOpenTime(DateUtils.parseDate(map.get("openTime") + "", "yyyy-MM-dd HH:mm:ss"));
                    kuaiSan.setCreateTime(new Date());
                    kuaiSanList.add(kuaiSan);
                }
            }
        }
        return kuaiSanList;
    }

    private KuaiSan trim(KuaiSan kuaiSan) {
        kuaiSan.setIssue(StringUtils.trim(kuaiSan.getIssue()));
        kuaiSan.setNumber(StringUtils.trim(kuaiSan.getNumber()));
        kuaiSan.setOpenTime(kuaiSan.getOpenTime());
        return kuaiSan;
    }
}
