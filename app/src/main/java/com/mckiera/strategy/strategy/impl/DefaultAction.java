package com.mckiera.strategy.strategy.impl;

import com.mckiera.strategy.strategy.ShopActionStrategy;

/**
 * author by Mckiera
 * time: 2016-03-28  11:00
 * description:默认折扣. 即 无折扣
 * updateTime:
 * update description:
 */
public class DefaultAction implements ShopActionStrategy {
    @Override
    public double cashDis(double money) {
        return money;
    }
}
