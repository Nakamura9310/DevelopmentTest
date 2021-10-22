package com.example.demo.service;

import com.example.demo.repository.UserMapper;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    //UserMapperをコンストラクタインジェクション
    private final UserMapper mapper;

    //ユーザーのsort情報を取得
    public String selectSort() {
        return mapper.selectSort();
    }

    
}