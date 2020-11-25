package com.mjlf.design.componment;

/**
 * @ClassName Client
 * @Author mjlft
 * @Date 2020/11/25 15:04
 * @Version 1.0
 * @Description TODO
 */
public class Client {
    public static void main(String[] args) {
        Scheel scheel = new Scheel("a", "b");

        Unity unity = new Unity("aa", "aa");
        Stu stu11 = new Stu("aaa", "aaa");
        Stu stu12 = new Stu("aab", "aaa");
        Stu stu13 = new Stu("aab", "aaa");
        unity.add(stu11);
        unity.add(stu12);
        unity.add(stu13);

        Unity unity1 = new Unity("ba", "ba");
        Stu stu21 = new Stu("baa", "aaa");
        Stu stu22 = new Stu("bab", "aaa");
        Stu stu23 = new Stu("bab", "aaa");
        unity1.add(stu21);
        unity1.add(stu22);
        unity1.add(stu23);

        Unity unity2 = new Unity("ca", "ba");
        Stu stu31 = new Stu("caa", "aaa");
        Stu stu32 = new Stu("cab", "aaa");
        Stu stu33 = new Stu("cab", "aaa");
        unity2.add(stu31);
        unity2.add(stu32);
        unity2.add(stu33);

        scheel.add(unity);
        scheel.add(unity1);
        scheel.add(unity2);

        scheel.show();
    }

}
