package com.zdz.ssm.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	// 这里应该要给pageNumber赋一个默认值，并且要暴露下面的参数值
	public String splitPage(
			@RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
			Model model) {
		final int PAGESIZE = 4;
		int totalPageNumber;
		List<Article> articles;
		int lastPageNumber;
		int nextPageNumber;

		totalPageNumber = articleService.getSplitPageTotalNumber(PAGESIZE);
		if (pageNumber <= 0) {
			pageNumber = 1;
		} else if (pageNumber > totalPageNumber) {
			pageNumber = totalPageNumber;
		}
		lastPageNumber = pageNumber - 1;
		nextPageNumber = pageNumber + 1;
		articles = articleService.getSplitPageList(PAGESIZE, pageNumber);

		model.addAttribute("totalPageNumber", totalPageNumber);
		model.addAttribute("lastPageNumber", lastPageNumber);
		model.addAttribute("nextPageNumber", nextPageNumber);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("articles", articles);

		return "articleFlat";
	}

	@RequestMapping("/articleFlatDetail")
	public String articleFlatDetail(@RequestParam("rootId") int rootId,
			Model model) {
		List<Article> articles = articleService.getArticlesByRootid(rootId);
		if (articles == null) {
			System.out.println("articles is null");
		}
		Article firstArticle = articles.get(0);
		if (model == null) {
			System.out.println("model is null");
		}
		model.addAttribute("articles", articles);
		model.addAttribute("firstArticle", firstArticle);
		return "articleFlatDetail";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam int id) {
		articleService.deleteArticleById(id);
		return "delete";
	}

	@RequestMapping(value = "/newArticle", method = RequestMethod.POST)
	public String newArticle(Article article) {
		int rootid = -1;
		article.setIsLeaf(true);
		article.setPdate(new Date(System.currentTimeMillis()));
		article.setPid(0);
		article.setRootId(rootid);
		rootid = articleService.save(article);
		article.setRootId(rootid);
		articleService.update(article);
		return "forward:/articleFlat";
	}

	@RequestMapping(value = "/newArticle", method = RequestMethod.GET)
	public String showNewArticle(Model model) {
		model.addAttribute("article",new Article());
		return "newArticle";
	}

	@RequestMapping(value = "/reply" ,method = RequestMethod.GET)
	public String reply(@RequestParam(value="id")int pid,@RequestParam(value="rootid")int rootId,Model model) {
		Article article = new Article();
		article.setPid(pid);
		article.setRootId(rootId);
		model.addAttribute("article",article);
		return "reply";
	}
	
	@RequestMapping(value = "/reply" ,method = RequestMethod.POST)
	public String replyToPersist(Article article) {
		article.setIsLeaf(true);
		article.setPdate(new Date());
		articleService.save(article);
		return "replyDeal";
	}
	@RequestMapping(value="/login")
	public String login()
	{
		return "login";
	}
	@RequestMapping(value="/backgroundAdmin")
	public String backgroundAdmin(@RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,Model model)
	{
		final int PAGESIZE = 4;
		int totalPageNumber;
		List<Article> articles;
		int lastPageNumber;
		int nextPageNumber;

		totalPageNumber = articleService.getSplitPageTotalNumber(PAGESIZE);
		if (pageNumber <= 0) {
			pageNumber = 1;
		} else if (pageNumber > totalPageNumber) {
			pageNumber = totalPageNumber;
		}
		lastPageNumber = pageNumber - 1;
		nextPageNumber = pageNumber + 1;
		articles = articleService.getSplitPageList(PAGESIZE, pageNumber);

		model.addAttribute("totalPageNumber", totalPageNumber);
		model.addAttribute("lastPageNumber", lastPageNumber);
		model.addAttribute("nextPageNumber", nextPageNumber);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("articles", articles);
		
		return "backgroundAdmin";
	}
}
