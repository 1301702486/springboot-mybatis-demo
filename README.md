# 结合 Cloud Study 的 Mybatis 的简易 demo

## 项目结构如下

![项目结构](https://i.loli.net/2020/02/24/XmzrohGRsLQ9Bda.png)

其中 main 下面的 mapper 里面都是接口类，相当于 JPA 中的 repository；实体类不用加各种注解，其余 2 个都和 JPA 一样。

resources 下面的 mapper 放的是 mybatis 映射配置文件 (xml)。

## pom.xml

使用 mybatis 需要以下两个依赖。

```xml
<!-- mysql -->

<dependency>

    <groupId>mysql</groupId>

    <artifactId>mysql-connector-java</artifactId>

    <scope>runtime</scope>

</dependency>

<!-- mybatis -->
<dependency>

    <groupId>org.mybatis.spring.boot</groupId>

    <artifactId>mybatis-spring-boot-starter</artifactId>

    <version>2.1.1</version>

</dependency>
```

## application.yml

创建新项目时默认的项目配置文件是 application.properties，这里改为用 yml 文件，本质是一样的，格式不同而已。

```yml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/CloudStudy?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B8
    username: root
    password: 111
    driver-class-name: com.mysql.cj.jdbc.Driver
mybatis:
  mapper-locations: classpath:mapper/*.xml
server:
  port: 8088
```

datasource 配置数据库的一些信息，这里我连的是自己的数据库。

mapper-locations 就是 resources 下 mapper 文件夹内的所有文件。

## UserMapper.xml

```xml
<mapper namespace="com.whu.cloudstudy_server.mapper.UserMapper">

    <select id="findUserByEmail" resultType="com.whu.cloudstudy_server.entity.User">
        SELECT * FROM user WHERE email = #{email}
    </select>

    <select id="findUserByName" resultType="com.whu.cloudstudy_server.entity.User">
        SELECT * FROM user WHERE name = #{name}
    </select>
</mapper>
```

一个映射文件对应 main 中的一个映射接口。

mapper 是根标签，里面可以有 select, insert, update, delete 子标签，标签内容写 sql 语句。

id 属性就是映射接口中定义的方法名。

## 测试

数据库中添加一条记录

![数据库中添加一条记录](https://i.loli.net/2020/02/24/VKaib6zSn4XogFc.png)

Postman中测试

![Postman中测试](https://i.loli.net/2020/02/24/6WZNOAf1gnzGMBe.png)

## 参考网址

[基于 SpringBoot2.0+优雅整合 SpringBoot+Mybatis](https://segmentfault.com/a/1190000017211657#item-2-7)

[springboot系列 | 与mybatis整合](https://blog.csdn.net/u011320740/article/details/79256807?depth_1-utm_source=distribute.pc_relevant.none-task&utm_source=distribute.pc_relevant.none-task)

[Mybatis 教程]([https://www.w3cschool.cn/mybatis/](https://www.w3cschool.cn/mybatis))


