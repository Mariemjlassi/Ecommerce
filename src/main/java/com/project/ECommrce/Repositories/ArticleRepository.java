package com.project.ECommrce.Repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.ECommrce.Entities.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>{
	List<Article> findByCategorieId(Long idCategorie);
	List<Article> findAll(Sort sort);
	List<Article> findByCouleur(String couleur);
	
    List<Article> findByDesignationContainingIgnoreCase(String designation);
    
    
    List<Article> findByDesignationIgnoreCase(String designation);
}
