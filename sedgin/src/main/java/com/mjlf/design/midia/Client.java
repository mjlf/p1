package com.mjlf.design.midia;

/**
 * @ClassName Client
 * @Author mjlft
 * @Date 2020/11/26 18:49
 * @Version 1.0
 * @Description TODO
 */
public class Client {
    public static void main(String[] args) {
        Media media = new WorkMedia();
        CvCollege cvCollege = new CvCollege(media, "cv");
        TvCollege tvCollege = new TvCollege(media, "tv");

        media.getMessage("tv");
    }
}
