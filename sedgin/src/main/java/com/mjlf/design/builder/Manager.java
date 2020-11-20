package com.mjlf.design.builder;

/**
 * @ClassName Manager
 * @Author mjlft
 * @Date 2020/11/20 17:01
 * @Version 1.0
 * @Description TODO
 */
public class Manager {
    private HouserBuilder houserBuilder;

    public HouserBuilder getHouserBuilder() {
        return houserBuilder;
    }

    public void setHouserBuilder(HouserBuilder houserBuilder) {
        this.houserBuilder = houserBuilder;
    }

    public void buildhouser(Hourse hourse){
        houserBuilder.flow1(hourse);
        houserBuilder.flow2(hourse);
        houserBuilder.flow3(hourse);
    }
}
