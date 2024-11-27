package com.project.ECommrce.Services;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.project.ECommrce.Entities.Article;
import com.project.ECommrce.Entities.categorie;

public interface IArticleService {

	 Article addArticle(Long idCategorie,MultipartFile file,String designation,float prix, String couleur) throws IOException;
	 Article getArticleById(Long id);
	 List<Article> getAllArticles();
	 Article updateArticle(Long articleId,Long categorieId,MultipartFile file, String designation,float prix, String couleur) throws IOException;
	 void deleteArticle(Long id);
	 List<Article> getAllArticlesByCategorie(Long idCategorie);
	 List<Article> getArticlesSortedByPriceCroissant();
	 List<Article> getArticlesSortedByPriceDecroissant();
	 public List<Article> getArticlesByCouleur(String couleur);
	 public List<Article> rechercherArticlesParDesignation(String designation);

}
