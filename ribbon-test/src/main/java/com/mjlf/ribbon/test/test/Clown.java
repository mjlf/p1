package com.mjlf.ribbon.test.test;

import java.util.Observable;
import java.util.Random;

/**
 * @ClassName Clown
 * @Author mjlft
 * @Date 2020/9/15 22:02
 * @Version 1.0
 * @Description 被观察者
 */
public class Clown extends Observable {

    /** 表演的精彩 */
    public static final int PERFORM_GOOD = 0;
    /** 表演的糟糕 */
    public static final int PERFORM_BAD = 1;
    /** 表演完毕 */
    public static final int PERFORM_COMPLETE = 2;

    public void platform(){
        System.out.println("**小丑开始表演**");
        int state = new Random().nextInt(2);
        switch (state){
            case PERFORM_GOOD:
                System.out.println("**小丑状态很好，表演的很精彩！**");
                break;
            case PERFORM_BAD:
                System.out.println("**小丑状态不好，出了点篓子！**");
                break;
        }

        setChanged();

        //通知观察者
        notifyObservers(state);
    }

    public void exit(){
        System.out.println("**小丑表演结束**");
        setChanged();
        notifyObservers(PERFORM_COMPLETE);
    }
}
