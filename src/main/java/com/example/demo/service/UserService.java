package com.example.demo.service;

import com.example.demo.repository.UserMapper;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    //@RequiredArgsConstructorによりコンストラクタインジェクションの記述省略
    private final UserMapper mapper;

    //ユーザーのsort情報を取得
    public String selectSort() {
        return mapper.selectSort();
    }

    //ユーザーのsortをdateかpriorityに更新
    public void updateUserSort(String sort) {
        mapper.updateUserSort(sort);
    }

    
}
