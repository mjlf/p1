package com.mjlf.design.state;

/**
 * @ClassName State
 * @Author mjlft
 * @Date 2020/11/27 12:35
 * @Version 1.0
 * @Description TODO
 */
public class DoState extends State {

    public DoState(Actity actity) {
        super(actity);
    }

    public boolean disCount(){
        System.out.println("完成工作");
        return true;
    }

    public  void doInvoke(){
        if(disCount()){
            this.actity.setState(new DoState(this.actity));
        }else {
            callback();
        }
    }

    public void callback(){
        this.actity.setState(new StartState(this.actity));
    }
}
