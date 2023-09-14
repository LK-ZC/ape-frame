package com.jingdianjichi.demo;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.jingdianjichi.user.DemoApplication;
import com.jingdianjichi.user.mongo.entity.User;
import com.jingdianjichi.user.mongo.service.UserService;
import com.loser.core.entity.Page;
import com.loser.core.wrapper.LambdaQueryWrapper;
import com.loser.core.wrapper.Wrappers;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * easyMongo测试类
 *
 * @author: loser
 * @date: 2023/06/13
 */
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@Slf4j
public class EasyMongoApiTest {

    @Resource
    private UserService userService;

    @Before
    public void before() {
        userService.remove(Wrappers.lambdaQuery());
    }

    @After
    public void after() {
        userService.remove(Wrappers.lambdaQuery());
    }

    @Test
    public void testGetOne() {

        User user = new User();
        user.setId("1000");
        user.setLoginName("loser");
        user.setPassWord("");
        user.setAge(0);
        user.setCreateTime(0L);
        user.setUpdateTime(0L);
        userService.save(user);
        LambdaQueryWrapper<User> query = Wrappers.<User>lambdaQuery().eq(User::getId, "1000")
                .eq(User::getAge, 0);
        User dbData = userService.getOne(query);
        log.info("getOne user {}", JSONObject.toJSON(dbData));
        Assert.assertNotNull(dbData);
        Assert.assertEquals(dbData.getId(), user.getId());

    }

    @Test
    public void testSave() {

        User user = new User();
        user.setId("1001");
        user.setLoginName("testUser");
        user.setPassWord("testPassWord");
        user.setAge(1);
        user.setCreateTime(System.currentTimeMillis());
        user.setUpdateTime(System.currentTimeMillis());
        Assert.assertTrue(userService.save(user));
        User dbData = userService.getById("1001");
        log.info("getById user {}", JSONObject.toJSON(dbData));
        Assert.assertNotNull(dbData);
        Assert.assertNull(userService.getById("15555L"));

    }

    @Test
    public void saveBatch() {

        int size = 10;
        List<User> users = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            User user = new User();
            user.setLoginName("testUser");
            user.setPassWord("testPassWord");
            user.setAge(1);
            user.setCreateTime(System.currentTimeMillis());
            user.setUpdateTime(System.currentTimeMillis());
            users.add(user);
        }
        userService.saveBatch(users);
        List<User> list = userService.list(Wrappers.lambdaQuery());
        log.info("saveBatch {}", JSONObject.toJSON(list));
        Assert.assertEquals(list.size(), size);

    }

    @Test
    public void removeById() {

        User user = new User();
        user.setId("1001");
        user.setLoginName("testUser");
        user.setPassWord("testPassWord");
        user.setAge(1);
        user.setCreateTime(System.currentTimeMillis());
        user.setUpdateTime(System.currentTimeMillis());
        Assert.assertTrue(userService.save(user));
        User dbUser = userService.getById("1001");
        log.info("removeById {}", JSONObject.toJSON(dbUser));
        Assert.assertEquals(dbUser.getId(), "1001");
        userService.removeById("1001");
        Assert.assertNull(userService.getById("1001"));

    }

    @Test
    public void remove() {

        int size = 10;
        List<User> users = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            User user = new User();
            user.setId(String.valueOf(i));
            user.setLoginName("testUser");
            user.setPassWord("testPassWord");
            user.setAge(1);
            user.setCreateTime(System.currentTimeMillis());
            user.setUpdateTime(System.currentTimeMillis());
            users.add(user);
        }
        userService.saveBatch(users);
        LambdaQueryWrapper<User> query = Wrappers.<User>lambdaQuery().eq(User::getId, "0");
        userService.remove(query);

        List<User> list = userService.list(Wrappers.lambdaQuery());
        Assert.assertEquals(list.size(), size - 1);
        log.info("remove {} ", JSONObject.toJSON(list));
        userService.remove(Wrappers.lambdaQuery());
        List<User> list1 = userService.list(Wrappers.lambdaQuery());
        log.info("remove {} ", JSONObject.toJSON(list1));
        Assert.assertTrue(CollectionUtils.isEmpty(list1));

    }

    @Test
    public void updateById() {

        String id = "10011";
        User user = new User();
        user.setId(id);
        user.setLoginName("testUser");
        user.setPassWord("testPassWord");
        user.setAge(1);
        user.setCreateTime(System.currentTimeMillis());
        user.setUpdateTime(System.currentTimeMillis());

        userService.save(user);
        User user1 = userService.getById(id);
        log.info("updateById {}", user1);
        Assert.assertEquals(user1.getLoginName(), "testUser");

        user.setLoginName("loser");
        userService.updateById(user);
        User user2 = userService.getById(id);
        log.info("updateById {}", user2);
        Assert.assertEquals(user2.getLoginName(), "loser");

    }

    @Test
    public void testUpdate() {

        String id = "10011";
        User user = new User();
        user.setId(id);
        user.setLoginName("testUser");
        user.setPassWord("testPassWord");
        user.setAge(1);
        user.setCreateTime(System.currentTimeMillis());
        user.setUpdateTime(System.currentTimeMillis());

        userService.save(user);
        User user1 = userService.getById(id);
        log.info("update {}", user1);

        user.setAge(100);
        user.setPassWord("666");
        user.setLoginName("loser");

        LambdaQueryWrapper<User> query = Wrappers.<User>lambdaQuery().eq(User::getAge, 1);
        userService.update(user, query);

        User user2 = userService.getById(id);
        log.info("update {}", user2);
        Assert.assertEquals(user2.getLoginName(), "loser");
        Assert.assertEquals(user2.getPassWord(), "666");

    }

    @Test
    public void testListByIds() {

        int size = 10;
        List<User> users = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            User user = new User();
            user.setId(String.valueOf(i));
            user.setLoginName("testUser");
            user.setPassWord("testPassWord");
            user.setAge(1);
            user.setCreateTime(System.currentTimeMillis());
            user.setUpdateTime(System.currentTimeMillis());
            users.add(user);
        }
        userService.saveBatch(users);

        List<String> ids = Arrays.asList("1", "2", "9");
        Collection<User> list = userService.listByIds(ids);
        log.info("listByIds {}", list);
        Assert.assertEquals(list.size(), ids.size());

    }


    @Test
    public void testCount() {

        int size = 10;
        List<User> users = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            User user = new User();
            user.setId(String.valueOf(i));
            user.setLoginName("testUser");
            user.setPassWord("testPassWord");
            user.setAge(1);
            user.setCreateTime(System.currentTimeMillis());
            user.setUpdateTime(System.currentTimeMillis());
            users.add(user);
        }
        userService.saveBatch(users);

        long count = userService.count(Wrappers.lambdaQuery());
        Assert.assertEquals(count, size);

        LambdaQueryWrapper<User> query = Wrappers.<User>lambdaQuery().in(User::getId, Arrays.asList("1", "2", "9"));
        long count1 = userService.count(query);
        Assert.assertEquals(count1, 3);

        LambdaQueryWrapper<User> query2 = Wrappers.<User>lambdaQuery().notIn(User::getId, Arrays.asList("1", "2", "9"));
        long count2 = userService.count(query2);
        Assert.assertEquals(count2, 7);

    }

    @Test
    public void testList() {

        int size = 10;
        List<User> users = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            User user = new User();
            user.setId(String.valueOf(i));
            user.setLoginName("testUser");
            user.setPassWord("testPassWord");
            user.setAge(1);
            user.setCreateTime(System.currentTimeMillis());
            user.setUpdateTime(System.currentTimeMillis());
            users.add(user);
        }
        userService.saveBatch(users);

        List<User> list = userService.list(Wrappers.lambdaQuery());
        log.info("list {}", JSONObject.toJSON(list));
        Assert.assertEquals(list.size(), 10);

        LambdaQueryWrapper<User> query = Wrappers.<User>lambdaQuery().ne(User::getLoginName, "testUser").le(User::getId, "1");
        List<User> list1 = userService.list(query);
        log.info("list1 {}", JSONObject.toJSON(list1));
        Assert.assertEquals(list1.size(), 0);

    }

    @Test
    public void testPage() {

        int size = 10;
        List<User> users = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            User user = new User();
            user.setId(String.valueOf(i));
            user.setLoginName("testUser");
            user.setPassWord("testPassWord");
            user.setAge(1);
            user.setCreateTime(System.currentTimeMillis());
            user.setUpdateTime(System.currentTimeMillis());
            users.add(user);
        }
        userService.saveBatch(users);

        Page<User> list = userService.page(Wrappers.lambdaQuery(), 1, 10);
        log.info("list {}", JSONObject.toJSON(list));
        Assert.assertEquals(list.getTotal(), 10);

        LambdaQueryWrapper<User> query = Wrappers.<User>lambdaQuery().eq(User::getLoginName, "testUser").le(User::getId, "1");
        Page<User> list1 = userService.page(query, 1, 10);
        log.info("list1 {}", JSONObject.toJSON(list1));
        Assert.assertEquals(list1.getTotal(), 2);

    }

    @Test
    public void test() {

        List<User> users = Arrays.asList(
                new User("12", "sss", "loser", 10, 0L, 0L),
                new User("13", "loser", "loser", 10, 0L, 0L),

                // 排序过滤
                new User("11", "lusir", "loser", 10, 0L, 0L),

                // 年龄不符合
                new User("14", "loser", "loser", 0, 0L, 0L),
                new User("18", "loser", "xxx", 0, 0L, 0L),
                new User("21", "lusir", "loser", 0, 0L, 0L),
                new User("22", "sss", "loser", 0, 0L, 0L),
                new User("23", "loser", "loser", 0, 0L, 0L),
                new User("24", "loser", "loser", 0, 0L, 0L),

                // 密码不符合
                new User("15", "lusir", "xxx", 10, 0L, 0L),
                new User("16", "sss", "xxx", 10, 0L, 0L),
                new User("17", "loser", "xxx", 10, 0L, 0L)
        );
        userService.saveBatch(users);

        List<User> list1 = userService.list(Wrappers.lambdaQuery());
        Assert.assertEquals(list1.size(), users.size());

        int age = 10;
        String lusir = "lusir";
        String sss = "sss";
        String loser = "loser";
        /**
         select * from user where
         age =10
         and (
         loginName='lusir'
         or loginName = 'sss'
         or (loginName='loser' and age <= 10)
         )
         and passWord = 'loser'
         order by id desc limit 0,2
         */
        LambdaQueryWrapper<User> queryWrapper = Wrappers.<User>lambdaQuery()
                .eq(User::getAge, age)
                .and(tem ->
                        tem.eq(User::getLoginName, lusir).or()
                                .eq(User::getLoginName, sss).or()
                                .and(x -> x.eq(User::getLoginName, loser).le(User::getAge, age))
                )
                .eq(User::getPassWord, loser).orderByDesc(User::getId).skip(0L).limit(2);
        List<User> list = userService.list(queryWrapper);
        Assert.assertEquals(list.size(), 2);
        log.info("list {}", JSONObject.toJSON(list));
    }


}
