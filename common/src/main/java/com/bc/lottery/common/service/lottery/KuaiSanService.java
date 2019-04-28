package com.bc.lottery.common.service.lottery;

import com.bc.lottery.common.domain.lottery.kuaisan.HebeiKS;
import com.bc.lottery.common.domain.lottery.kuaisan.HubeiKS;
import com.bc.lottery.common.domain.lottery.kuaisan.KuaiSan;
import com.bc.lottery.common.enums.LotteryTypeEnum;
import com.bc.lottery.common.mapper.lottery.HebeiKSMapper;
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

    @Resource
    HebeiKSMapper hebeiKSMapper;

    public int save(KuaiSan kuaiSan) {
        if (kuaiSan instanceof HubeiKS) {
            hubeiKSMapper.insert((HubeiKS) kuaiSan);
        } else if (kuaiSan instanceof HebeiKS) {
            hebeiKSMapper.insert((HebeiKS) kuaiSan);
        }
        return 0;
    }

    public int save(LotteryTypeEnum typeEnum, List<Map<String, Object>> maplist) {
        try {
            if (CollectionUtils.isNotEmpty(maplist)) {
                if (typeEnum.equals(LotteryTypeEnum.KuaiSan.HUBEI)) {
                    hubeiKSMapper.insert((HubeiKS) buildKuaiSan(maplist.get(0), new HubeiKS()));
                } else if (typeEnum.equals(LotteryTypeEnum.KuaiSan.HEBEI)) {
                    hebeiKSMapper.insert((HebeiKS) buildKuaiSan(maplist.get(0), new HebeiKS()));
                }
            }
        } catch (ParseException e) {
            logger.error("save kuaisan error", e);
        }
        return 0;
    }

    private List buildKuaiSanList(List<Map<String, Object>> maplist, KuaiSan kuaiSan) throws ParseException {
        List<KuaiSan> kuaiSanList = null;
        if (CollectionUtils.isNotEmpty(maplist)) {
            kuaiSanList = new ArrayList<>();
            for (Map<String, Object> map : maplist) {
                if (map != null) {
                    kuaiSanList.add(buildKuaiSan(map, kuaiSan));
                }
            }
        }
        return kuaiSanList;
    }

    private KuaiSan buildKuaiSan(Map<String, Object> map, KuaiSan kuaiSan) throws ParseException {
        kuaiSan.setIssue(StringUtils.trim(map.get("issue") + ""));
        kuaiSan.setOpenTime(DateUtils.parseDate(StringUtils.trim(map.get("openTime") + ""), "yyyy-MM-dd HH:mm:ss"));
        kuaiSan.setNumber(StringUtils.trim(map.get("number") + ""));
        kuaiSan.setCreateTime(new Date());
        return kuaiSan;
    }

}
