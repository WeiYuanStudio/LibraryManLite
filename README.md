# Library Man Lite

图书管理系统，大二上Java课设

## UI 展示

![QScqtf.png](https://s2.ax1x.com/2019/11/26/QScqtf.png)

![QScxXj.png](https://s2.ax1x.com/2019/11/26/QScxXj.png)

[bilibili演示视频](https://www.bilibili.com/video/av77405699/)

依赖MySQL-con 以及MyBatis，以及MyBatis的依赖。

## 部署

使用IDE为IDEA。打包时JDK环境11.0.4

已经打包好war包在release页面里面了。

从release页下载war包。然后部署到tomcat的webapps路径下。注意，记得改SQL配置文件。可以先将war包放到Tomcat让他自动解包。解包完毕后修改`\WEB-INF\classes\mybatis-config.xml`中SQL相关的配置。

主要是这三行。其他的MyBatis的配置，我也不是很懂。还请大佬多多指教

```xml
<property name="url" value="jdbc:mysql://****:3306/library"/>
<property name="username" value="Library"/>
<property name="password" value="****"/>
```

数据库需要自己建库建表。请自行判断修改上面的xml配置文件。关于数据库的创建如下。

遇到问题欢迎提issues，或者到我的用户页 -> 简介 -> 个人博客链接 -> About -> 联系方式  顺便求个star

## 数据库创建

配置数据库close掉长时间sleep的connect

```SQL
SET global wait_timeout = 60;
```

book 表

```SQL
USE library;
CREATE TABLE book (
    isbn VARCHAR(13) PRIMARY KEY,
    title VARCHAR(50),
    publisher VARCHAR(50),
    author VARCHAR(50),
    publish_date VARCHAR(50),
    cover_img VARCHAR(200),
    intro VARCHAR(200)
)
```

user 表

```SQL
CREATE TABLE user(
    uid INTEGER PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(20) UNIQUE,
    gender CHAR,
    mail VARCHAR(20) UNIQUE,
    password VARCHAR(20)
);
```

real_book 表

```SQL
CREATE TABLE real_Book(
    book_sn VARCHAR(20) PRIMARY KEY,
    isbn VARCHAR(13)
);
```

record 表

```SQL
CREATE TABLE record(
    record_id INTEGER PRIMARY KEY AUTO_INCREMENT,
    customer_uid INTEGER DEFAULT -1,
    admin_uid INTEGER DEFAULT -1,
    book_sn VARCHAR(20) NOT NULL,
    operate_id INTEGER NOT NULL,
    ts TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```
