package com.mjlf.design.midia;

/**
 * @ClassName TvCollege
 * @Author mjlft
 * @Date 2020/11/26 18:44
 * @Version 1.0
 * @Description TODO
 */
public class CvCollege implements College {
    private Media media;

    public CvCollege(Media media, String name) {
        this.media = media;
        this.media.registry(name, this);
    }

    @Override
    public void getMessage() {
        System.out.println("CV 工作");
    }
}
