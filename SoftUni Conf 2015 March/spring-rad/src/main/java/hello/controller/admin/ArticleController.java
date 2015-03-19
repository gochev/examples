package hello.controller.admin;

import hello.model.Article;
import hello.repository.ArticleRepository;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value = "/admin/article")
public class ArticleController {

	@Autowired
	@Qualifier(ArticleRepository.NAME)
	private ArticleRepository articleRepository;
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String view(Model model, Pageable pageable){
		Page<Article> articles = articleRepository.findAll(pageable);
		
		
		model.addAttribute("articles", articles);
		
		return "/admin/article/view.jsp";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@Valid final Article article, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return "/admin/article/edit.jsp";
		}
		this.articleRepository.save(article);
		
		return "redirect:/admin/article/view";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String edit(Model model){
		model.addAttribute("article", new Article());
		return "/admin/article/edit.jsp";
	}
	
	@RequestMapping(value = "/edit/{itemId}", method = RequestMethod.GET)
	public String edit(@PathVariable("itemId") Long itemId, Model model){
		Article article = articleRepository.findOne(itemId);
		model.addAttribute("article", article);
		return "/admin/article/edit.jsp";
	}
	
	@RequestMapping(value = "/remove/{itemId}", method = RequestMethod.GET)
	public String remove(@PathVariable("itemId") Long itemId, Model model){
		articleRepository.delete(itemId);
		return "redirect:/admin/article/view";
	}
	
}
