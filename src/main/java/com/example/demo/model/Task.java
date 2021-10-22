package com.example.demo.model;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class Task {

    //タスク識別番号 primary key
    private int taskID;

    //タスク名 重複可能
    @NotBlank(message = "タスク名を入力してください")
    private String taskName;

    //タスクの実行予定日
    @NotBlank(message = "予定日を入力してください")
    private String scheduledDate;

    //タスクの開始予定時刻
    @NotBlank(message = "開始時刻を入力してください")
    private String startTime;

    //タスクが完了状態か否か表す
    private boolean done;

    //タスク完了日
    private String completionDate;

    //タスクの優先度(A~C or Null)
    private String priority;




}
