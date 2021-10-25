package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Task;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface TaskMapper {

    /**
     * タスクのselect
     * 1件のみ
     */
    @Select("SELECT * FROM Task WHERE taskID = #{taskID}")
    public Task selectOne(int taskID);

    /**
     * タスクのselect
     * undoneのみ
     * scheduledDate順
     */
    @Select("SELECT * FROM Task WHERE done = false ORDER BY " +
        "CASE " +
            "WHEN scheduledDate IS NULL THEN'2' " +//null最後
            "WHEN scheduledDate = '' THEN '1' " +//空文字最後
            "ELSE '0' " +
        "END, scheduledDate ASC, startTime ASC")
    public List<Task> selectUndoneTasksByScheduledDate();

    /**
     * タスクのselect
     * undoneのみ
     * priority順
     */
    @Select("SELECT * FROM Task WHERE done = false ORDER BY " +
        "CASE " +
            "WHEN priority IS NULL THEN '2' " +//null最後
            "WHEN priority = '' THEN '1' " +//空文字最後
            "ELSE '0' " +
        "END, priority ASC, scheduledDate ASC")
    public List<Task> selectUndoneTasksByPriority();

    /**
     * タスクのselect
     * undone,todayのみ
     * startTime順
     */
    @Select("SELECT * FROM Task WHERE scheduledDate = CURRENT_DATE AND done = false ORDER BY " +
        "CASE " +
            "WHEN startTime IS NULL THEN '2' " +//null最後
            "WHEN startTime = '' THEN '1' " +//空文字最後
            "ELSE '0' " +
        "END, startTime ASC")
    public List<Task> selectTodayTasks();

    /**
     * タスクのselect
     * doneのみ
     * completionDate順
     */
    @Select("SELECT * FROM Task WHERE done = true ORDER BY completionDate ASC")
    public List<Task> selectDoneTasks();

    /**
     * タスクのinsert
     */
    @Insert("INSERT INTO Task (taskName, estimatedTime, scheduledDate, startTime) VALUES (#{taskName}, #{estimatedTime}, #{scheduledDate}, #{startTime})")
    public void insertOneTask(Task task);

    /**
     * タスクの更新(edit.html)
     * @param task
     */
    @Update("UPDATE Task SET "+
        "taskName = #{taskName}, "+
        "estimatedTime = #{estimatedTime}, "+
        "scheduledDate = #{scheduledDate}, "+
        "startTime = #{startTime}, "+
        "priority = #{priority} "+
        "WHERE taskID = #{taskID}")
    public void updateOneTask(Task task);

    /**
     * タスクの完了処理
     * done→trueへ
     * completionDate→CURRENT_DATE
     * @param taskID
     */
    @Update("UPDATE Task SET done = true, completionDate = CURRENT_DATE WHERE taskID = #{taskID}")
    public void done(int taskID);

    /**
     * タスクの未完了処理
     * done→falseへ
     * comletionDate→null
     * @param taskID
     */
    @Update("UPDATE Task SET done = false, completionDate = null WHERE taskID = #{taskID}")
    public void undone(int taskID);

    /**
     * タスクのdelete
     * @param taskID
     */
    @Delete("DELETE from Task WHERE taskID = #{taskID}")
    public void deleteTask(int taskID);



    
    
}
