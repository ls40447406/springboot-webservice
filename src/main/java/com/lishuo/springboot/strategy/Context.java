package com.lishuo.springboot.strategy;



public class Context {

    /**
     * 策略模式
     */
/*
    private Strategy strategy;

    public  Context(Strategy strategy){
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2){
        return strategy.doOperation(num1,num2);
    }
*/

    /**
     * 状态模式
     * @param args
     */

    private  Strategy strategy;

    public Context(){

    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2){
        return strategy.doOperation(num1,num2);
    }


    public static void main(String[] args) {
        //Context context = new Context(new OperationAdd());
        Context context = new Context();
        //context.setStrategy(new OperationMultiply());
        context.setStrategy(new OperationSubstract());
        int num = context.executeStrategy(4, 5);
        System.out.print(num);
    }

}
