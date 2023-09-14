package com.jingdianjichi.user.controller;

import java.io.IOException;
import java.util.Date;

import com.jingdianjichi.mail.MailMessage;
import com.jingdianjichi.mail.MailSender;
import com.jingdianjichi.redis.util.RedisShareLockUtil;
import com.jingdianjichi.redis.util.RedisUtil;
import com.jingdianjichi.tool.oss.AliOSSUtil;
import com.jingdianjichi.threadpool.mdcable.MdcCallable;
import com.jingdianjichi.threadpool.mdcable.MdcRunnable;
import com.jingdianjichi.tool.ExportWordUtil;
import com.jingdianjichi.tool.checker.Checker;
import com.jingdianjichi.tool.checker.Checkers;
import com.jingdianjichi.user.entity.po.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

@RestController
@Slf4j
public class TestController {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private RedisShareLockUtil redisShareLockUtil;

    @Autowired
    private AliOSSUtil aliOSSUtil;

    @Autowired
    @Qualifier("testThreadPool")
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Autowired
    @Qualifier("mailThreadPool")
    private ThreadPoolExecutor mailThreadPool;


    @Resource
    private MailSender mailSender;

    @GetMapping("/test")
    public String test() {
        return "Hello World";
    }

    @GetMapping("/testRedis")
    public void testRedis() {
        redisUtil.set("name", "鸡翅");
    }

    @GetMapping("/testRedisLock")
    public void testRedisLock() {
        boolean result = redisShareLockUtil.lock("jichi", "1231231", 100000L);
        System.out.println(result);
    }

    @GetMapping("/testLog")
    public void testLog() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            log.info("这是{}条日志！", i);
        }
        long endTime = System.currentTimeMillis();
        log.info("当前耗时：{}", endTime - startTime);
    }

    @GetMapping("/testExport")
    public void testExport() throws Exception {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("name", "经典鸡翅");
        dataMap.put("auditName", "可乐鸡翅");
        ExportWordUtil.exportWord(dataMap, "导出文件", "wordExport.ftl");
    }

    @PostMapping("/testQuery")
    public void testQuery(@RequestBody SysUser sysUser) throws Exception {
        //2022-12-18 21:49:00
        System.out.println(sysUser);
    }

    @PostMapping("/upload")
    public void upload(@RequestParam("file") MultipartFile file) throws IOException {
        //2022-12-18 21:49:00
        System.out.println(aliOSSUtil.upload(file));
    }

    @GetMapping("/sendMail")
    public void sendMail() {
        final MailMessage mailMessage = MailMessage.builder()
                .receiver("xxxxx@qq.com")
                .subject("测试邮件主题")
                .content("测试邮件内容")
                .annexFiles(Collections.singletonList(new MailMessage.AnnexFileInfo("测试附件.txt", "Hello World".getBytes())))
                .build();
        try {
            mailSender.sendEmail(mailMessage);
        } catch (MessagingException | IOException e) {
            // 异常
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/testThreadPool")
    public String testThreadPool() {

        //原生线程池+MdcRunnable/MdcCallable
        mailThreadPool.submit(new MdcRunnable(() -> log.info("小米手机，就是牛！")));
        mailThreadPool.submit(new MdcCallable(() -> {
            log.info("苹果手机，就是牛！");
            return "";
        }));

        //common包提供的的线程池
        threadPoolTaskExecutor.submit(()-> log.info("华为手机，就是牛！"));
        threadPoolTaskExecutor.submit(()-> {
            log.info("oppo手机，就是牛！");
            return "";
        });

        //主线程
        log.info("菲尔普斯山寨机，就是牛！");
        return "end";
    }

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            long start = System.currentTimeMillis();
            SysUser sysUser = new SysUser();
            sysUser.setId(0L);
            sysUser.setName("");
            sysUser.setAge(-10);
            sysUser.setCreateBy("");
            sysUser.setCreateTime(new Date());
            sysUser.setUpdateBy("");
            sysUser.setUpdateTime(new Date());
            sysUser.setDeleteFlag(0);
            sysUser.setVersion(0);

            Checker<SysUser> checker = Checkers.<SysUser>lambdaCheck()
                    .notNull(SysUser::getName)
                    .ne(SysUser::getAge, 0)
                    .custom(item -> item.getAge() > queryByDb(item.getId()), "年龄异常");
            checker.check(sysUser);
            System.out.println("cost " + (System.currentTimeMillis() - start));
        }

    }

    /**
     * 模拟通过db获取判断值进行自定义判断
     */
    private static Integer queryByDb(Long id) {
        if (id > 0) {
            return -1;
        } else {
            return 1;
        }
    }


}
