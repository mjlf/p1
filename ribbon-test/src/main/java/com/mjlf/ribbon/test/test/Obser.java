package com.mjlf.ribbon.test.test;

import java.util.Observable;
import java.util.Observer;

/**
 * @ClassName Obser
 * @Author mjlft
 * @Date 2020/9/15 22:08
 * @Version 1.0
 * @Description 观察者
 */
public class Obser implements Observer  {

    private int no;

    public Obser(int no) {
        System.out.println(no  + " 号观众入场");
        this.no = no;
    }

    @Override
    public void update(Observable o, Object arg) {
        int state = (int)arg;
        if(state == 0){
            System.out.println(no + "号观众叫好");
        }else if(state == 1){
            System.out.println(no + "号观众喝倒彩");
        }else {
            exit();
        }
    }

    private void exit() {
        System.out.println(no + "号观众退场！");
    }
}
