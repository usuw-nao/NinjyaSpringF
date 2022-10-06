package com.example.app.mapper;

import java.util.List;

import com.example.app.domain.Item;

public interface ItemMapper {

	// 全一覧
	List<Item> selectAll() throws Exception;

	// itemIdによるそれぞれの取り出し
	Item selectById(String itemId) throws Exception;
	
	//idによるそれぞれの取り出し
	Item selectId(Integer id)throws Exception;

	// 追加
	void insert(Item item) throws Exception;

	// 更新、編集
	void update(Item item) throws Exception;

	// 削除
	void delete(Integer id) throws Exception;

}
