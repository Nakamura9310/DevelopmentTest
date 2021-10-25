package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {

    //ユーザーのsortを取得(date or priority)
    @Select("SELECT sort FROM User")
    public String selectSort();
    
    //ユーザーのsortをdateかpriorityに更新
    @Update("UPDATE User SET sort = #{sort}")
    public void updateUserSort(@Param("sort") String sort);
}
