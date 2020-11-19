package com.mjlf.ribbon.test.test;

/**
 * @ClassName Test
 * @Author mjlft
 * @Date 2020/9/15 22:15
 * @Version 1.0
 * @Description 观察者模式测试
 */
public class Test {

    public static void main(String[] args) {
        Clown clown = new Clown();
        for( int i = 0; i < 5; i ++){
            Obser obser = new Obser(i);
            clown.addObserver(obser);
        }

        clown.platform();
        clown.exit();
    }
}
