package com.zjhuang.statemachine;

import org.squirrelframework.foundation.fsm.annotation.*;
import org.squirrelframework.foundation.fsm.impl.AbstractUntypedStateMachine;

/**
 * 业务状态机
 *
 * @author zjhuang
 * @create 2019/1/12 18:24
 **/
// 定义状态机参数：
// eventType为触发状态切换的事件类型，
// stateType为状态机具有的所有状态类型，
// contextType为状态机上下文，可以携带自定义参数在状态之间转换。
@StateMachineParameters(eventType = MyEvent.class,
        stateType = MyState.class,
        contextType = MyContext.class)
// 定义流程中所有状态，以及每个状态进入/退出时执行的方法
// initialState = true表示将状态设置为流程初始状态
@States({
        @State(name = "A", entryCallMethod = "entryA", initialState = true),
        @State(name = "B", entryCallMethod = "entryB"),
        @State(name = "C", entryCallMethod = "entryC")
})
// 定义从状态from进入to的触发条件on，触发时执行callMethod方法
@Transitions({
        @Transit(from = "A", to = "B", on = "A2B", callMethod = "doA2BMethod"),
        @Transit(from = "B", to = "C", on = "B2C", callMethod = "doB2CMethod"),
        @Transit(from = "C", to = "A", on = "C2A", callMethod = "doC2AMethod")
})
public class MyyStateMachine extends AbstractUntypedStateMachine {

    // 当状态从A进入B时执行的方法
    public void doA2BMethod(MyState from, MyState to, MyEvent event, MyContext context) {
        System.out.println("状态切换：" + from + " -> " + to);
        System.out.println("context数据：" + context.getDesc());
    }

    // 当状态从B进入C时执行的方法
    public void doB2CMethod(MyState from, MyState to, MyEvent event, MyContext context) {
        System.out.println("状态切换：" + from + " -> " + to);
        System.out.println("context数据：" + context.getDesc());
    }

    // 当状态从B进入C时执行的方法
    public void doC2AMethod(MyState from, MyState to, MyEvent event, MyContext context) {
        System.out.println("状态切换：" + from + " -> " + to);
        System.out.println("context数据：" + context.getDesc());
    }

    // 进入状态A时执行的方法
    public void entryA(MyState from, MyState to, MyEvent event, MyContext context) {
        System.out.println("进入状态 " + to);
        System.out.println("context数据：" + context.getDesc());
    }

    // 进入状态B时执行的方法
    public void entryB(MyState from, MyState to, MyEvent event, MyContext context) {
        System.out.println("进入状态 " + to);
        System.out.println("context数据：" + context.getDesc());
    }

    // 进入状态C时执行的方法
    public void entryC(MyState from, MyState to, MyEvent event, MyContext context) {
        System.out.println("进入状态 " + to);
        System.out.println("context数据：" + context.getDesc());
    }
}
