package com.java.learn.Pattern.template;

/**
 * @Auther: DingZhichao
 * @Date: 2019/12/24 11:07
 * @Description:
 */
public abstract class BuildHouseTemplate {

    public void bulidHouse(){
        foundation();
        buildWall();
        installDoor ();
    }

    /**
     * 打地基
     */
    abstract void  foundation();

    /**
     * 垒墙
     */
    abstract void buildWall();

    /**
     *  安装门
     */
    abstract void installDoor ();

    /**
     * 装修房子，内部类
     */
    abstract static class DecorateHouse{

        public void decorateHouse(){
            wallPaper();
            flooring();
        }

        abstract void wallPaper();
        abstract void flooring();


    }





}
