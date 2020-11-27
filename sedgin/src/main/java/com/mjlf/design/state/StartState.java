package com.mjlf.design.state;

/**
 * @ClassName State
 * @Author mjlft
 * @Date 2020/11/27 12:35
 * @Version 1.0
 * @Description TODO
 */
public class StartState extends State {
    public StartState(Actity actity) {
        super(actity);
    }

    public boolean disCount(){
        System.out.println("准备完成");
        return true;
    }

    public  void doInvoke(){
        disCount();
        this.actity.setState(new DoState(this.actity));
    }

    public void callback(){
        this.actity.setState(new StartState(this.actity));
    }
}
