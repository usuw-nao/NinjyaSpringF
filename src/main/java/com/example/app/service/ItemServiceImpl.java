package com.example.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.domain.Item;
import com.example.app.domain.ItemType;
import com.example.app.mapper.ItemMapper;
import com.example.app.mapper.ItemTypeMapper;

@Service
@Transactional(rollbackFor=Exception.class)
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	ItemMapper itemMapper;
	
	@Autowired
	ItemTypeMapper itemTypeMapper;
	
	@Override
	public List<Item> getItemList() throws Exception {
		return itemMapper.selectAll();
	}

	@Override
	public Item getItemById(String itemId) throws Exception {
		return itemMapper.selectById(itemId);
	}
	
	@Override
	public Item getItemId(Integer id) throws Exception {
		return itemMapper.selectId(id);
	}
	
	@Override
	public void addinto(Item item) throws Exception {
		itemMapper.into(item);		
	}
	
	

	@Override
	public void addItem(Item item) throws Exception {
		itemMapper.insert(item);
	}

	@Override
	public void editItem(Item item) throws Exception {
		itemMapper.update(item);		
	}

	@Override
	public void deleteItem(Integer id) throws Exception {
		itemMapper.delete(id);		
	}

	@Override
	public List<ItemType> getTypeList() throws Exception {
		return itemTypeMapper.selectAll();
	}

	

	

}
