package com.zdz.ssm.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zdz.ssm.mapper.ArticleMapper;
import com.zdz.ssm.model.Article;
@Component
public class ArticleDaoImpl implements ArticleDao{
//	是否该设置成为单例的？
	private static SqlSessionFactory sqlSessionFactory;

//	public SqlSessionFactory getSqlSessionFactory() {
//		return sqlSessionFactory;
//	}
//	@Autowired
//	public static void setSqlSessionFactory(SqlSessionFactory ssf) {
//		sqlSessionFactory = ssf;
//	}
	@Autowired
	public ArticleDaoImpl(SqlSessionFactory ssf)
	{
		sqlSessionFactory = ssf;
	}
	@Override
	public int save(Article article) {
		SqlSession ss = sqlSessionFactory.openSession();
		ArticleMapper articleMapper = ss.getMapper(ArticleMapper.class);

	    articleMapper.save(article);
	    ss.commit();
	    ss.close();
	    return article.getId();
	}

	@Override
	public List<Article> getSplitPageList(int pageSize, int pageNumber) {
		int begin = (pageNumber-1)*pageSize;
		int size = pageSize;
		SqlSession ss = sqlSessionFactory.openSession();
		ArticleMapper articleMapper = ss.getMapper(ArticleMapper.class);
		List<Article> articles = articleMapper.getSplitPageList(begin, size);
		ss.commit();
		ss.close();
		return articles;
	}

	@Override
	public int getSplitPageTotalNumber(int pageSize) {
		SqlSession ss = sqlSessionFactory.openSession();
		ArticleMapper articleMapper = ss.getMapper(ArticleMapper.class);

		int totalRecords = articleMapper.getTotal();
		int totalPageNumber = totalRecords%pageSize==0 ? totalRecords/pageSize : totalRecords/pageSize+1;
		ss.commit();
		ss.close();
		return totalPageNumber;
	}

	@Override
	public List<Article> getArticlesByRootid(int rootId) {
		SqlSession ss = sqlSessionFactory.openSession();
		ArticleMapper articleMapper = ss.getMapper(ArticleMapper.class);
		List<Article> articles = articleMapper.getArticlesByRootid(rootId);
		ss.commit();
		ss.close();
		return articles;
	}

	@Override
	public Article getArticleById(int id) {
		SqlSession ss = sqlSessionFactory.openSession();
		ArticleMapper articleMapper = ss.getMapper(ArticleMapper.class);
		Article article = articleMapper.getArticleById(id);
		ss.commit();
		ss.close();
		return article;
	}

	@Override
	public void deleteById(int id) {
		SqlSession ss = sqlSessionFactory.openSession();
		ArticleMapper articleMapper = ss.getMapper(ArticleMapper.class);

		articleMapper.deleteById(id);
		ss.commit();
		ss.close();
	}
	@Override
	public void update(Article article) {
		SqlSession ss = sqlSessionFactory.openSession();
		ArticleMapper articleMapper = ss.getMapper(ArticleMapper.class);

		articleMapper.update(article);
		ss.commit();
		ss.close();
	}

}
