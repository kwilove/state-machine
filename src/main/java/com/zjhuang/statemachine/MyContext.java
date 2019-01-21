package com.zjhuang.statemachine;

/**
 * @author zjhuang
 * @create 2019/1/12 18:27
 **/
public class MyContext {
    private String desc;

    public MyContext(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "MyContext{" +
                "desc='" + desc + '\'' +
                '}';
    }
}
