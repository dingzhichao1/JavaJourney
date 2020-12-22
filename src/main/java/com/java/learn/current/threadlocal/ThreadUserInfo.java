package com.java.learn.current.threadlocal;

import lombok.Data;

/**
 * Description：
 *
 * @author zhichao.ding
 * @version 1.0
 * @date 2020/11/27 13:14
 */
@Data
public class ThreadUserInfo extends ThreadLocal {

    private String name;

    private Integer age;




}


class