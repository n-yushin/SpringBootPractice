package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.model.MUser;


@Mapper // Mybatisでリポジトリを作成するためにはjavaのインターフェースに@Mapperアノテーションを付ける
public interface UserMapper {
	
	/* ユーザー登録 */
	public int insertOne(MUser user);
}
