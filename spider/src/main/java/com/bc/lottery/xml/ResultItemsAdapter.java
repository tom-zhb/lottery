package com.bc.lottery.xml;

import us.codecraft.webmagic.ResultItems;

import java.util.List;

public interface ResultItemsAdapter<T> {

    List<ResultItems> convertResultItems(T t);
}
