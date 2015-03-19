package hello.repository;

import hello.model.Article;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository(value = ArticleRepository.NAME)
public interface ArticleRepository extends PagingAndSortingRepository<Article, Long> {

	String NAME = "articleRepository";

}
