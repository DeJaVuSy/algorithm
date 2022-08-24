package com.demo.algorithm.monitor;

import java.util.EventObject;

public class PercentEvent extends EventObject {
    private Object source;

    private int  percent;

    /**
     * 构造方法
     * @param source 监听的对象
     * @param percent 监听的变量
     */
    public PercentEvent(Object source, int percent) {
        super(source);
        this.source=source;
        this.percent=percent;
    }
    public int getPercent(){
        return percent;
    }
}
