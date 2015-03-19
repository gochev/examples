package hello;

import hello.model.Article;
import hello.repository.ArticleRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(
				Application.class, args);

		// ArticleRepository articleRepository =
		// context.getBean(ArticleRepository.class, ArticleRepository.NAME);
		//
		// Article article = new Article();
		// article.setContent("SOme content");
		// article.setTitle("Hello World");
		//
		// articleRepository.save(article);

//		ArticleRepository articleRepository = context.getBean(
//				ArticleRepository.class, ArticleRepository.NAME);
//
//		for (int i = 0; i < 100; i++) {
//			Article article = new Article();
//			article.setContent("SOme content random article " + i);
//			article.setTitle("Bla bla vla " + i);
//
//			articleRepository.save(article);
//		}
	}
}
