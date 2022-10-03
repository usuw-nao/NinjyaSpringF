package com.example.app.mapper;

import java.util.List;

import com.example.app.domain.ItemType;

public interface ItemTypeMapper {
	//全一覧
	List<ItemType>selectAll() throws  Exception;
	

}
