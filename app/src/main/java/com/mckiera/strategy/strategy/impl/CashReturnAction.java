package com.mckiera.strategy.strategy.impl;

import com.mckiera.strategy.strategy.ShopActionStrategy;

/**
 * author by Mckiera
 * time: 2016-03-28  11:13
 * description:满减活动  满300减50;
 * updateTime:
 * update description:
 */
public class CashReturnAction implements ShopActionStrategy {
    @Override
    public double cashDis(double money) {
        int count = (int)(money / 300);
        return money - count * 50;
    }
}
