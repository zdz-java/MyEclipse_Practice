package com.zdz.ssm.dao;

import java.util.List;

import com.zdz.ssm.model.Article;

public interface ArticleDao {

	int save(Article article);

	List<Article> getSplitPageList(int pageSize, int pageNumber);

	int getSplitPageTotalNumber(int pageSize);

	List<Article> getArticlesByRootid(int rootId);

	Article getArticleById(int id);

	void deleteById(int id);

}
