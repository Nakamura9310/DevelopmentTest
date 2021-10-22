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

    //select undoneのみ 予定日順　
    public List<Task> selectUndoneTasksByScheduledDate() {
        return mapper.selectUndoneTasksByScheduledDate();
    }

    //select undone 優先度順
    public List<Task> selectUndoneTasksByPriority() {
        return mapper.selectUndoneTasksByPriority();
    }





    
}
