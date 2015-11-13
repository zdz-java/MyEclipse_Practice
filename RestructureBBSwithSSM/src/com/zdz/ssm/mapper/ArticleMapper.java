package com.zdz.ssm.mapper;

import com.zdz.ssm.model.Article;

public interface ArticleMapper {
	public Article getArticleById(int id);
	public void save(Article article);
	public void deleteById(int id);
}	
