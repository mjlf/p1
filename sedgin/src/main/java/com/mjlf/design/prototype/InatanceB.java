package com.mjlf.design.prototype;

import io.netty.buffer.ByteBufOutputStream;

import java.io.*;

/**
 * @ClassName InatanceB
 * @Author mjlft
 * @Date 2020/11/20 12:32
 * @Version 1.0
 * @Description TODO
 */
public class InatanceB implements Serializable, Cloneable {
    private int a;
    private Instance instance;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        InatanceB inatanceB = (InatanceB) super.clone();
        Instance instance = (Instance) this.instance.clone();
        inatanceB.setInstance(instance);
        return inatanceB;
    }

    public InatanceB copyInstanceB() {
        ByteArrayOutputStream byteArrayOutputStream = null;
        ObjectOutputStream objectOutputStream = null;

        ByteArrayInputStream byteArrayInputStream = null;
        ObjectInputStream objectInputStream = null;

        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);

            objectOutputStream.writeObject(this);

            byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            objectInputStream = new ObjectInputStream(byteArrayInputStream);

            InatanceB inatanceB = (InatanceB) objectInputStream.readObject();
            return inatanceB;
        } catch (Exception e) {
            return null;
        } finally {
            try {
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if(objectOutputStream != null){
                    objectOutputStream.close();
                }
                if(byteArrayInputStream != null){
                    byteArrayInputStream.close();
                }
                if(objectInputStream != null){
                    objectInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public Instance getInstance() {
        return instance;
    }

    public void setInstance(Instance instance) {
        this.instance = instance;
    }

    @Override
    public String toString() {
        return "InatanceB{" +
                "a=" + a +
                ", instance=" + instance +
                '}';
    }
}
