package hello.controller;

import hello.model.Article;
import hello.repository.ArticleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@Autowired
	@Qualifier(ArticleRepository.NAME)
	private ArticleRepository articleRepository;

    @RequestMapping("/")
    String index(Model model, Pageable pageable) {
    	Page<Article> articles = articleRepository.findAll(pageable);
    	model.addAttribute("articles", articles.getContent());
        return "index.jsp";
    }

}