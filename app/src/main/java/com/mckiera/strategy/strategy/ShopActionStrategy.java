package com.mckiera.strategy.strategy;

/**
 * author by Mckiera
 * time: 2016-03-28  10:50
 * description: 商城活动策略
 * updateTime:
 * update description:
 */
public interface ShopActionStrategy {
    /**
     * 现金折扣
     * @param money 现金
     * @return 折扣后的价格.
     */
    double cashDis(double money);
}
