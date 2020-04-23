package com.java.learn.Pattern.template;

/**
 * @Auther: DingZhichao
 * @Date: 2019/12/24 11:23
 * @Description:
 */
public class ChineseBuildHouse extends BuildHouseTemplate {

    @Override
    void foundation() {
        System.out.println("用水泥打地基");
    }

    @Override
    void buildWall() {
        System.out.println("用砖垒墙");
    }

    @Override
    void installDoor() {
        System.out.println("安装防盗门");
    }

    public static void main(String[] args) {
        BuildHouseTemplate buildHouseTemplate = new ChineseBuildHouse();

        buildHouseTemplate.bulidHouse();

        BuildHouseTemplate.DecorateHouse decorateHouse = new DecorateHouse() {
            @Override
            void wallPaper() {
                System.out.println("贴墙纸");
            }

            @Override
            void flooring() {
                System.out.println("铺瓷砖地板");
            }
        };

        decorateHouse.decorateHouse();
    }


}


