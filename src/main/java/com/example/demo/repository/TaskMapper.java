package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Task;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TaskMapper {

    /**
     * タスクのselect処理 undoneのみ scheduledDate順
     */
    @Select("SELECT * FROM Task WHERE done = false ORDER BY " +
        "CASE " +
            "WHEN scheduledDate IS NULL THEN'2' " +//null最後
            "WHEN scheduledDate = '' THEN '1' " +//空文字最後
            "ELSE '0' " +
        "END, scheduledDate ASC, startTime ASC")
    public List<Task> selectUndoneTasksByScheduledDate();

    /**
     * タスクのselect処理 undoneのみ priority順
     */
    @Select("SELECT * FROM Task WHERE done = false ORDER BY " +
        "CASE " +
            "WHEN priority IS NULL THEN '2' " +//null最後
            "WHEN priority = '' THEN '1' " +//空文字最後
            "ELSE '0' " +
        "END, priority ASC, scheduledDate ASC")
    public List<Task> selectUndoneTasksByPriority();

    
    
}
