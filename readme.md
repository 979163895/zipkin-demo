## 项目集成了普通的 http zipkin 链路，mysql 语句查询链路，kafka 链路
## 需要自己先安装 zipkin 服务
## kafka

#### 下载

> https://kafka.apache.org/downloads
#### 启动zk

`bin/zookeeper-server-start.sh config/zookeeper.properties`

#### 启动kafka

`bin/kafka-server-start.sh config/server.properties`

#### 创建topic

`bin/kafka-topics.sh --create --bootstrap-server 192.168.1.97:9092 --replication-factor 1 --partitions 1 --topic test`

#### 查看topic

`bin``/kafka-topics``.sh --list --bootstrap-server 192.168.1.97:9092`

#### 发送消息

```bash
bin/kafka-console-producer.sh --bootstrap-server 192.168.1.97:9092 --topic test
This is a message
This is another message
```

#### 消费消息

```
bin``/kafka-console-consumer``.sh --bootstrap-server 192.168.1.97:9092 --topic ``test` `--from-beginning
```
