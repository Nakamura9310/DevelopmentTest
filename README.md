# Webアプリケーション開発課題用

## 本アプリケーションの概要
RDBにアクセスし、タスクの読み込み、登録、変更、削除ができるアプリケーションです。

使用技術や環境は以下の通りです。
- macOS BigSur
- Java (AdoptOpenJDK 11.0.10)
- SpringBoot 2.5.5
- MySQL 14.14
- MyBatis 
- Thymeleaf 
- HTML / CSS / MDBootstrap
- JavaScript(画面の一部のみ)

本アプリケーションはlolalhostで起動させることを前提としておりますのでご了承ください。

## 起動前に必要な設定
application.yml内の以下の箇所は、ご自身の環境に合わせて変えていただけますようお願いします。
```
spring:
    datasource:
        url: jdbc:mysql://localhost:3306/{使用DB名}?serverTimezone=Asia/Tokyo
        driver-class-name: com.mysql.cj.jdbc.Driver
        username: {MySQLのユーザー名}
        password: {MySQLのパスワード}
```

## アプリケーション画面イメージ

Topページ<br>
<img width="60%" alt="スクリーンショット 2021-10-25 17 30 21" src="https://user-images.githubusercontent.com/81789439/138662043-4faaed2b-bb59-4082-b1c2-4e315cd1a2ff.png">
<br>
Todayページ(本日のタスクのみ表示させるページ)<br>
<img width="60%" alt="スクリーンショット 2021-10-25 17 30 32" src="https://user-images.githubusercontent.com/81789439/138662061-78ecb0d6-20d4-499d-b2b0-3ef11d21040d.png">
<br>
Doneページ(完了タスクのみ表示させるページ)<br>
<img width="60%" alt="スクリーンショット 2021-10-25 17 30 39" src="https://user-images.githubusercontent.com/81789439/138662067-8cecd6bc-97c5-4bbb-9d3e-969f0ac419dc.png">
<br>
動作イメージ<br>
![画面収録 2021-10-25 17 31 09 mov](https://user-images.githubusercontent.com/81789439/138662574-2bdf2c93-b615-4af8-8c35-924d1b8de761.gif)
