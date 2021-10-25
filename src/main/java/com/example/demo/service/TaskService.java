package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskMapper;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskService {

    //@RequiredArgsConstructorにより以下記述のみでコンストラクタインジェクション
    private final TaskMapper mapper;

    //select1件
    public Task selectOne(int taskID) {
    	return mapper.selectOne(taskID);
    }

    //select undoneのみ 予定日順　
    public List<Task> selectUndoneTasksByScheduledDate() {
        return mapper.selectUndoneTasksByScheduledDate();
    }

    //select undone 優先度順
    public List<Task> selectUndoneTasksByPriority() {
        return mapper.selectUndoneTasksByPriority();
    }

    //select todayのみ
    public List<Task> selectTodayTasks() {
        return mapper.selectTodayTasks();
    }

    //新規タスク登録
    public void insertOneTask(Task task) {
    	mapper.insertOneTask(task);
    }

    //タスク更新
    public void updateOneTask(Task task) {
        mapper.updateOneTask(task);
    }

    //タスク完了状態へ
    public void done(int taskID) {
        mapper.done(taskID);
    }

    //タスク未完了状態へ
    public void undone(int taskID) {
        mapper.undone(taskID);
    }

    //delete処理
    public void deleteTask(int taskID) {
        mapper.deleteTask(taskID);
    }







    
}
