package com.java.learn.jdk.clone;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Description：
 *
 * @author zhichao.ding
 * @version 1.0
 * @date 2021/1/29 14:20
 */
public class CloneTest {
    public static void main(String[] args) {
        Head head = new Head().setEyeColor("blue").setHair("brown");
       // String name="莱昂纳多";
        String name = new String("莱昂纳多");

        Person person = new Person().setName(name).setAge(34).setHigh(174).setHead(head);

        try {
            Person clone =(Person) person.clone();

            //name="奥兰多";
            name=new String("奥兰多");

            person.setName(name);
            person.setHead(head.setHair("black").setEyeColor("black"));
            System.out.println(person);
            System.out.println(clone);
            System.out.println("String引用类型:"+(person.getName()==clone.getName()?"浅拷贝":"深拷贝"));
            System.out.println("引用类型:"+(person.getHead()==clone.getHead()?"浅拷贝":"深拷贝"));

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }


    }
}

@Data
@Accessors(chain = true)
class Person implements Cloneable{

    private String name;

    private Integer age;

    private int high;

    private Head head;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return (Person)super.clone();

    }
}


@Data
@Accessors(chain = true)
class Head{

    private String eyeColor;

    private String hair;


}
