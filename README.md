## 介绍

迅捷外卖APP，一款为餐饮企业打造的在线订餐软件



## 技术选型 [![img.png](https://github.com/Q-1515/reggie_parent/raw/master/img/1.png)](https://github.com/Q-1515/reggie_parent/blob/master/img/1.png)



## 技术架构

Spring Boot、Mybatis、SpringMVC、Mybatis-Plus、Mysql、Redis 、Swagger



## 前后端分离开发

|          | **开发语言**     | **开发工具**      | **运行环境** | **服务器** |
| -------- | ---------------- | ----------------- | ------------ | ---------- |
| 前端开发 | JavaScript、HTML | VS Code、Hbuilder | Node.js      | Nginx      |
| 后端开发 | Java             | IDEA、eclipse     | JDK          | Tomcat     |

## 启动路径
前端启动路径：localhost:8080/front/page/login.html

后端启动路径：localhost:8080/backend/index.html

redis启动（192.168.114.130）：
cd /usr/local/redis
./bin/redis-server ./redis.conf
bin/redis-cli -h localhost -p 6379 -a 123456

关闭防火墙（开启mysql 114.130）：
systemctl stop firewalld	
