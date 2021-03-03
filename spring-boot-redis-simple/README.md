# SpringBoot+Lettuce监听RedisCluster集群环境下的键值事件
## 修改Redis配置文件
`redis.conf`配置文件修改位置如下：

```conf
# 注释掉bind 127.0.0.1
#bind 127.0.0.1
# 设置后台运行
daemonize yes
# 设置外网可访问
protected-mode no
# 设置授权密码
requirepass 123456
# 开启cluster
cluster-enabled yes
# 设置cluster配置文件名称
cluster-config-file nodes.conf
# 设置Cluster节点超时时间
cluster-node-timeout 2000
# 开启Redis AOF持久化
appendonly yes
# 设置AOF持久化文件名
appendfilename appendonly.aof
# 设置DUMP文件名
dbfilename dump.rdb
# 设置Redis日志文件名
logfile redis.log
# 开启缓存的键空间通知事件
notify-keyspace-events EA
```

> **注意：**若在单机上部署伪集群，注意修改`redis.conf`中的`port 6378`端口号，以及配置中所有文件名称(不重复即可)

参考文章：https://www.cnblogs.com/xfearless/p/11393438.html