package com.zdz.ssm.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zdz.ssm.model.Article;
import com.zdz.ssm.service.ArticleService;


@Controller
public class MainController {
	private ArticleService articleService;
	
	public ArticleService getArticleService() {
		return articleService;
	}
	@Autowired
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	@RequestMapping("/articleFlat")
//	这里应该要给pageNumber赋一个默认值，并且要暴露下面的参数值
	public String splitPage(@RequestParam(value = "pageNumber") int pageNumber) {
		final int PAGESIZE = 4;
		int totalPageNumber;
		List<Article> articles;
		int lastPageNumber;
		int nextPageNumber;

		totalPageNumber = articleService.getSplitPageTotalNumber(PAGESIZE);
		if (pageNumber<=0) {
			pageNumber = 1;
		}
		else if(pageNumber>totalPageNumber){
			pageNumber = totalPageNumber;
		}
		lastPageNumber = pageNumber-1;
		nextPageNumber = pageNumber+1;
		articles = articleService.getSplitPageList(PAGESIZE, pageNumber);

		
		return "articleFlat";
	}
	
	@RequestMapping("/articleFlatDetail")
	public String articleFlatDetail(@RequestParam("rootId")int rootId)
	{
		List<Article> articles = articleService.getArticlesByRootid(rootId);
		Article firstArticle = articles.get(0);
		return "articleFlatDetail";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam int id)
	{
		articleService.deleteArticleById(id);
		return "delete";
	}
	
	@RequestMapping("/newArticle")
	public String newArticle(@RequestParam Article article,@RequestParam String post)
	{
//		这里可以考虑将带有post参数与没带的放在不同的方法中处理
		if(post!=null)
		{
			 int rootid = -1;		
			 article.setIsLeaf(true);
			 article.setPdate(new Date(System.currentTimeMillis()));
			 article.setPid(0);
			 article.setRootId(rootid);
			 rootid = articleService.save(article);
			 article.setRootId(rootid);
			 articleService.save(article);
//			 return "return";
		}
//		有没有完成的地方，重定向了
		return "newArticle";
	}
	
	@RequestMapping("/replyDeal")
	public String replyDeal()
	{
		
		return "replyDeal";
	}

}
