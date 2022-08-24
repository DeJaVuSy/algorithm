package com.demo.algorithm.monitor;

public class testListenerExecuter {


    PercentListener percentListener;
    public  int percent=0;

    public void addPercentListener(PercentListener percentListener){
        this.percentListener=percentListener;
    }

    public void innerExcuter(){
        for (int i=0;i<100;i++){
            percent=i;
            System.out.println("我是percent 我改变成了="+percent);
            //这一步必须在改变事件中加入对percent的监听 updateEvent是变量改变之后的执行事件
            //这个event里面也不是非要监听percent，你也可以监听其他变量
            percentListener.updateEvent(new PercentEvent(this,percent));
        }
    }


    public static void main(String[] grgs){
        testListenerExecuter test= new testListenerExecuter();
        PercentListener listener = new PercentListener() {
            @Override
            public void updateEvent(PercentEvent dm) {
                // System.out.println("我是获取到事件改变之后的执行的方法");
                System.out.println("我知道percent改变为="+dm.getPercent());
            }
        };
        //将监听器添加给该变量
        test.addPercentListener(listener);
        test.innerExcuter();
    }

}
