package com.java.learn.jdk.colleciton.hashmap;

import lombok.Data;
import lombok.experimental.Accessors;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Auther: DingZhichao
 * @Date: 2021/9/11 15:49
 * @Description:
 */
public class MapObjectKeyTest {

    public static void main(String[] args) {

        Map<User, Role> map = new HashMap<>();
        User user = new User();
        user.setId(1);
        user.setAge(18);
        user.setUserName("张三");
        //user.setBirth(LocalDate.of(2012,3,14));

        System.out.println(user.hashCode());
        User user1 = new User();
        user1.setId(1);
        user1.setAge(18);
        user1.setUserName("张三");
        //user1.setBirth(LocalDate.of(2012,3,14));

        Role role = new Role();
        role.setId(1);
        role.setRoleName("管理员");

        Role role1 = new Role();
        role1.setRoleName("游客").setId(2);

        System.out.println(user.equals(user1));
        System.out.println(user1.hashCode());
        map.put(user,role);

        map.put(user1,role1);


        System.out.println(map.size());

    }

    //@Data
    @Accessors(chain = true)
    static class User{

        private Integer id;

        private String userName;

        private Integer age;


        public Integer getId() {
            return id;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }


        public void setId(Integer id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return Objects.equals(id, user.id) &&
                    Objects.equals(userName, user.userName) &&
                    Objects.equals(age, user.age);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, userName, age);
        }
    }

    @Data
    @Accessors(chain = true)
    static class Role{

        private Integer id;

        private String roleName;

    }

}
