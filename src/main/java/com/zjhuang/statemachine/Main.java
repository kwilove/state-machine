package com.zjhuang.statemachine;

import org.squirrelframework.foundation.fsm.StateMachineBuilderFactory;
import org.squirrelframework.foundation.fsm.UntypedStateMachine;
import org.squirrelframework.foundation.fsm.UntypedStateMachineBuilder;

/**
 * 启动状态机
 *
 * @author zjhuang
 * @create 2019/1/12 17:44
 **/
public class Main {

    public static void main(String[] args) {
        UntypedStateMachineBuilder builder = StateMachineBuilderFactory.create(MyyStateMachine.class);
        UntypedStateMachine machine = builder.newStateMachine(MyState.A);
        // context定义用户数据，可以在各个状态事件和方法间使用
        MyContext context = new MyContext("1");
        // 启动流程，初始状态是A
        machine.start(context);
        // 触发A2B事件，让状态从A切换到B，并且改变context数据
        context.setDesc("2");
        machine.fire(MyEvent.A2B, context);
        // 触发B2C事件，让状态从B切换到C
        machine.fire(MyEvent.B2C, context);
        // 触发C2A事件，让状态重新回到A
        context.setDesc("3");
        machine.fire(MyEvent.C2A, context);
        // 结束流程
        machine.terminate();
    }
}
