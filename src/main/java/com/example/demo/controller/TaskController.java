package com.example.demo.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.example.demo.model.Task;
import com.example.demo.service.TaskService;
import com.example.demo.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Data
@Controller
@RequiredArgsConstructor
public class TaskController {

    //@RequiredArgsConstructorによりコンストラクタ記述省略
	private final TaskService taskService;
	private final UserService userService;

    /**
     * top.html表示
     * @param model
     */
    @GetMapping("/top")
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

        //タスク一覧 日付欄 各種表示処理 今日(赤字) 明日(太字) 超過日(背景ピンク)
        LocalDate today = LocalDate.now();
        LocalDate tomorrow  = today.plusDays(1);
        DateTimeFormatter ymd = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        model.addAttribute("today", today.format(ymd));
        model.addAttribute("tomorrow", tomorrow.format(ymd));

        return "top.html";
    }


    /**
	 * top.html 優先度順ボタン押下
	 * @param model
	 */
	@PostMapping("/top/priority")
	public String sortByPriority(Model model) {
		//ユーザーのsortをpriorityに変換
		String sort = "priority";
		userService.updateUserSort(sort);
		return "redirect:/top";
	}
    /**
	 * top.html 予定日順ボタン押下
	 * @param model
	 */
	@PostMapping("/top/date")
	public String sortByDate(Model model) {
		//ユーザーのsortをdateに変換
		String sort = "date";
		userService.updateUserSort(sort);
		return "redirect:/top";
	}


    /**
     * 新規タスク登録
     * new.html表示
     * @param model
     * @param task
     * @return
     */
    @GetMapping("/new")
    public String displayNew(Model model, @ModelAttribute Task task) {
        //タスク登録時の初期値
        task.setScheduledDate(LocalDate.now().toString());
        task.setStartTime("12:00");
        return "new.html";
    }
    /**
	 * 新規タスク登録
	 * postで受け取ったあとの処理
	 * @param model
	 * @param task
	 * @param bindingResult
	 */
	@PostMapping("/new")
	public String register(Model model, @Validated @ModelAttribute Task task, BindingResult bindingResult) {
		//バリデーション処理
		if(bindingResult.hasErrors()) {
			System.err.println("↓↓　エラー発生！BindingResult内容　↓↓");
			System.err.println(bindingResult);
			System.err.println("↑↑　エラー発生！BindingResult内容　↑↑");
            //タスク登録時の初期値
			task.setScheduledDate(LocalDate.now().toString());
			task.setStartTime("12:00");
			return "new.html";
		}
		//新規タスクinsert
		taskService.insertOneTask(task);
		return "redirect:/top";
	}
    
    
}
