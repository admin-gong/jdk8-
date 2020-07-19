package com.beanfactory.demo.stream;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author  gxj
 *
 * /**
 * * 题目要求：一分钟内完成此题，只能用一行代码实现！
 * * 现在有5个用户！筛选：
 * * 1、ID 必须是偶数
 * * 2、年龄必须大于23岁
 * * 3、用户名转为大写字母
 * * 4、用户名字母倒着排序
 * * 5、只输出一个用户！
 * */

public class UserTest {
    public static void main(String[] args) {
        User user1 = new User(1,"zhangsan",21);
        User user2 = new User(2,"zhangsan",22);
        User user3 = new User(3,"zhangsan",23);
        User user4 = new User(4,"zhangsan",24);
        User user5 = new User(5,"zhangsan",25);

        //集合就是存储
        List<User> users = Arrays.asList(user1, user2, user3, user4, user5);
        //id为偶数
        users.stream()
                .filter(w->w.getId()%2==0)
                .filter(w->w.getAge()>23)
                .map(w->{return w.getName().toUpperCase();})
                .sorted((uu1,uu2)->{return uu2.compareTo(uu1);}).limit(1).forEach(System.out::println);
        int sumage   = users.stream().collect(Collectors.summingInt(User::getAge));
        System.out.println(sumage);








    }
}
