package com.example.demo.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.example.demo.model.Task;
import com.example.demo.service.TaskService;
import com.example.demo.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;


@Data
@Controller
@RequiredArgsConstructor
public class TaskController {

    //@RequiredArgsConstructorによりコンストラクタ記述省略
	private final TaskService taskService;
	private final UserService userService;

    @GetMapping(value = "/top")
    public String displayTop(Model model) {

        //ソート情報を取得
        String sort = userService.selectSort();

        //タスクリスト初期化宣言
        //下記if文でタスクリストを入れるため
        List<Task> task = null;
        
        //ログイン中のユーザーのsortがdateならば日付順、priorityなら優先度順でタスク表示
        if(sort.equals("date")) {
            task = taskService.selectUndoneTasksByScheduledDate();
        }
        if(sort.equals("priority")) {
            task = taskService.selectUndoneTasksByPriority();
        }

        //sort情報をモデルに渡す
        model.addAttribute("sort", sort);
        
        //task情報をモデルに渡す
        model.addAttribute("task", task);

        //タスク一覧 日付欄 各種表示処理 今日(赤字) 明日(太字) 超過日(ピンク背景)
        LocalDate today = LocalDate.now();
        LocalDate tomorrow  = today.plusDays(1);
        DateTimeFormatter ymd = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        model.addAttribute("today", today.format(ymd));
        model.addAttribute("tomorrow", tomorrow.format(ymd));

        return "/top.html";
    }
    
    
}
