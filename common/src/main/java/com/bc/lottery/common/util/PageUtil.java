package com.bc.lottery.common.util;

import com.alibaba.fastjson.JSONObject;
import com.bc.lottery.common.core.api.R;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageUtil {

    public enum CNT {
        total,
        res
    }

    public static <E> Page<E> pageStart(HttpServletRequest request) {
        return pageStart(request, null);
    }

    /**
     * @param request
     * @param orderBy  写入 需要排序的 字段名 如： product_id desc
     * @return
     */
    public static <E> Page<E> pageStart(HttpServletRequest request, String orderBy) {

        int pageon = getPageon(request);
        int pageSize = getpageSize(request);
        Page<E> page = PageHelper.startPage(pageon, pageSize);
        if (!StringUtils.isEmpty(orderBy)) {
            PageHelper.orderBy(orderBy);
        }

        return page;
    }

    private static int getPageon(HttpServletRequest request) {
        String pageonStr = request.getParameter("pageon");
        int pageon;
        if (StringUtils.isEmpty(pageonStr)) {
            pageon = 1;
        } else {
            pageon = Integer.parseInt(pageonStr);
        }
        return pageon;
    }

    private static int getpageSize(HttpServletRequest request) {
        String pageSizeStr = request.getParameter("pageSize");
        int pageSize;
        if (StringUtils.isEmpty(pageSizeStr)) {
            pageSize = 1;
        } else {
            pageSize = Integer.parseInt(pageSizeStr);
        }
        return pageSize;
    }

    /**
     * @param request
     * @param page
     * @param list
     */
    public static R<Map> pageEnd(HttpServletRequest request, Page<?> page, List<?> list) {
       /* JSONObject rstPage = new JSONObject();
        rstPage.put(CNT.total.toString(), page.getTotal());
        rstPage.put(CNT.res.toString(), list);*/
        Map<String, Object> map = new HashMap<>();
        map.put(CNT.total.toString(), page.getTotal());
        map.put(CNT.res.toString(), list);
        return R.data(map);
    }


}
