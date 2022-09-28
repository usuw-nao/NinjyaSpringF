package com.example.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.domain.News;
import com.example.app.mapper.NewsMapper;

@Service
@Transactional(rollbackFor = Exception.class)
public class NewsServiceImpl implements NewsService{
	
	@Autowired
	NewsMapper newsMapper;
	
	@Override
	public List<News>getNewsList() throws Exception{
		return newsMapper.selectAll();
	}
	
	

}
