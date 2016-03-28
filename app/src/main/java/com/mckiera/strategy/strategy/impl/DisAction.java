package com.mckiera.strategy.strategy.impl;

import com.mckiera.strategy.strategy.ShopActionStrategy;

/**
 * author by Mckiera
 * time: 2016-03-28  11:26
 * description:折扣活动
 * updateTime:
 * update description:
 */
public class DisAction implements ShopActionStrategy {
    private double dis;//折扣  1折就输入1,  5.5折就输入5.5
    public DisAction(double dis){
        this.dis = dis;
    }
    @Override
    public double cashDis(double money) {
        return money * (dis / 10d);
    }
}
