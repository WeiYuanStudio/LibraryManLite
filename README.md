# Library Man Lite

图书管理系统

## UI 展示

![QScqtf.png](https://s2.ax1x.com/2019/11/26/QScqtf.png)

![QScxXj.png](https://s2.ax1x.com/2019/11/26/QScxXj.png)

## 数据库创建

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
    customer_uid INTEGER,
    admin_uid INTEGER,
    book_sn VARCHAR(20),
    operate_id INTEGER,
    ts TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```
