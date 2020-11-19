package com.mjlf.reflect;

/**
 * @ClassName ReflectTest
 * @Author mjlft
 * @Date 2020/10/9 17:36
 * @Version 1.0
 * @Description TODO
 */
public class ReflectTest {

    private volatile Entity entity;

    private Entity getEntity(){
        if(this.entity == null){
            synchronized (this){
                if(this.entity == null){
                    this.entity = new Entity();
                    entity.setAbc("abc");
                    entity.setName("name");
                }
            }
        }
        return this.entity;
    }

    private String getName(){
        return this.entity.getName();
    }
}
