package com.example.demo.dao;

import com.example.demo.model.Article;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * @author <a href="zemlyanscky.grigorij@yandex.ru">Zemlyanskii Grigoriy</a> <br/>
 *         Creation date: 02/02/18.
 * @since 1.0
 */
@Repository
public interface ArticleRepository extends CrudRepository<Article, Integer> {
}