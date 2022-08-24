package com.demo.algorithm.monitor;

import java.util.EventListener;

public interface PercentListener extends EventListener {

    /**
     *  事件变化后执行的方法,自己定义的
     * @param dm
     */
    public void updateEvent(PercentEvent dm);
}
