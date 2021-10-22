package com.example.demo.model;

import lombok.Data;


/**
 * 当アプリケーションではログイン機能はありませんが、
 * タスクのソート情報を保存しておくため仮のUserモデルを作成しております。
 */
@Data
public class User {

    //ユーザー識別用のID
    private int userID;

    //タスクをソートする方法を格納
    //日付順(date)か優先度順(priority)
    private String sort;

    
}
