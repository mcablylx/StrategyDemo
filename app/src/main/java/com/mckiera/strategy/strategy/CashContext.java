package com.mckiera.strategy.strategy;

import com.mckiera.strategy.strategy.impl.CashReturnAction;
import com.mckiera.strategy.strategy.impl.DefaultAction;
import com.mckiera.strategy.strategy.impl.DisAction;

/**
 * author by Mckiera
 * time: 2016-03-28  11:16
 * description: 收银上下文类
 * updateTime:
 * update description:
 */
public class CashContext {
    //商场的活动策略
    private ShopActionStrategy strategy;
    public CashContext(String action){
        switch (action){
            case "无":
                strategy = new DefaultAction();
                break;
            case "9折":
                strategy = new DisAction(9);
                break;
            case "8折":
                strategy = new DisAction(8);
                break;
            case "7折":
                strategy = new DisAction(7);
                break;
            case "满300减50":
                strategy = new CashReturnAction();
                break;
        }
    }

    public double cashAction(double money){
        return strategy.cashDis(money);
    }
}
