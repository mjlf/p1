package com.mjlf.design.midia;

/**
 * @ClassName TvCollege
 * @Author mjlft
 * @Date 2020/11/26 18:44
 * @Version 1.0
 * @Description TODO
 */
public class TvCollege implements College {
    private Media media;

    public TvCollege(Media media, String name) {
        this.media = media;
        this.media.registry(name, this);
    }

    @Override
    public void getMessage() {
        System.out.println("TV 工作");
        this.media.sendMessage("cv");
    }
}
