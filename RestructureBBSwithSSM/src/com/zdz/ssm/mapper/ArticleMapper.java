package com.zdz.ssm.mapper;

import java.util.List;

import com.zdz.ssm.model.Article;

public interface ArticleMapper {
	public Article getArticleById(int id);
	public void save(Article article);
	public void deleteById(int id);
	public List<Article> getArticlesByRootid(int rootId);
	public int getTotal();
	public List<Article> getSplitPageList(int begin, int size);
}	
