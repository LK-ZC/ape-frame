### 使用步骤：

### 1、引入模块
```
<dependency>
    <groupId>com.jingdianjichi</groupId>
    <artifactId>ape-common-mq</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>  
```

### 2、配置，选配使用的mq
```
# RocketMQ
rocketmq.name-server=127.0.0.1:9876
rocketmq.producer.group=myRocketMQGroup

# RabbitMQ
spring.rabbitmq.host=127.0.0.1
spring.rabbitmq.port=5672
spring.rabbitmq.username=guest
spring.rabbitmq.password=guest
```

### 3、发送消息

```
@RestController
@RequiredArgsConstructor
public class MqTestController {

    private final QueueService queueService;

    @GetMapping("/mq")
    public String sendMessage() {
        queueService.send("Test", "hello world");
        return "success";
    }
}
```

ps：只测了rabbitmq，rocketmq同理
![输入图片说明](https://foruda.gitee.com/images/1690445042927550531/e4202f75_924578.png "屏幕截图")
