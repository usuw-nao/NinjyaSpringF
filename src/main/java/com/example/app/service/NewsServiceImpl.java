package com.example.app.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.app.domain.News;
import com.example.app.domain.NewsDetail;
import com.example.app.domain.NewsForm;
import com.example.app.mapper.NewsDetailMapper;
import com.example.app.mapper.NewsMapper;
import com.example.app.mapper.NewsTargetMapper;

@Service
@Transactional(rollbackFor = Exception.class)
public class NewsServiceImpl implements NewsService{
	
	@Autowired
	NewsMapper newsMapper;
	
	@Autowired
	NewsDetailMapper newsDetailMapper;
	
	@Autowired
	NewsTargetMapper newsTargetMapper;
	
	@Override
	public List<News>getNewsList() throws Exception{
		return newsMapper.selectAll();
	}

	@Override
	public News getNewsById(Integer id) throws Exception {
		return newsMapper.selectById(id);
	}

	@Override
	public void addNews(NewsForm formData) throws Exception {
		//newsテーブルへの追加
		News news = new News();
		news.setTitle(formData.getTitle());
		news.setAuthor(formData.getAuthor());
		news.setPostDate(formData.getPostDate());
		newsMapper.insert(news);
		
		//news_detailsテーブルの追加
		NewsDetail detail = new NewsDetail();
		detail.setNewsId(news.getId());
		detail.setArticle(formData.getArticle());
		
		
		//画像が選択されている場合の処理
		MultipartFile upfile = formData.getUpfile();
		if(!upfile.isEmpty()) {
			String photo = upfile.getOriginalFilename();
			detail.setPhoto(photo);
			File dest = new File("C:/Users/zd2L03/uploads/" + photo);
			upfile.transferTo(dest);
			
		}
		
		newsDetailMapper.insert(detail);
		
	
	for(Integer targetId : formData.getTargetIdList()) {
		newsTargetMapper.insert(news.getId(),targetId);
	}
	}
	
	}
	


