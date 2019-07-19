package com.lishuo.springboot.factory;

/**
 * 工厂模式
 */
public class AnimalFactory {

    public static  Animal getAnimal(String animalName){
        Animal animal = null;
        if("Cat".equals(animalName)){
            animal = new Cat();
        }else if("Dog".equals(animalName)){
            animal = new Dog();
        }
        return animal;
    }

    public static void main(String[] args) {
        Animal cat = getAnimal("Dog");
        System.out.print(cat.say());
    }

}
