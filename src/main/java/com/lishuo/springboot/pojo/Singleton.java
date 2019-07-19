package com.lishuo.springboot.pojo;

/**
 *  单例模式( 1. 懒汉式  2. 饿汉式 )
 */
public class Singleton {


    /**
     * 懒汉方式
     */
    private  Singleton(){}

    private static  Singleton singleton = null;

    // 线程安全问题 同步方法
    public  synchronized  static  Singleton getSingleton() {
        if(singleton == null){
            return singleton = new Singleton();
        }else {
            return singleton;
        }
    }

    /**
     * 饿汉方式
     */
/*    private Singleton(){}

    private static  final  Singleton singleton = new Singleton();

    public static Singleton getSingleton() {
         return  singleton;
    }*/


    public static void main(String[] args) {
        Singleton  test01 = getSingleton();
        Singleton  test02 = getSingleton();
        System.out.print( test01 == test02);
    }

}
