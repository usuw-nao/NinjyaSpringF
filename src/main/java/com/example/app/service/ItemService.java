package com.example.app.service;

import java.util.List;

import com.example.app.domain.Item;
import com.example.app.domain.ItemType;

public interface ItemService {
	
	List<Item>getItemList() throws Exception;
	Item getItemById(String itemId) throws Exception;
	Item getItemId(Integer id)throws Exception;
	
	void addinto(Item item)throws Exception;
	
	void addItem(Item item)throws Exception;
	void editItem(Item item)throws Exception;
	void deleteItem(Integer id)throws Exception;
	List<ItemType>getTypeList()throws Exception;

}
