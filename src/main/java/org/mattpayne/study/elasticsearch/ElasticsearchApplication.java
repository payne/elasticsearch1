package org.mattpayne.study.elasticsearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;

import java.util.List;

@SpringBootApplication
public class ElasticsearchApplication implements CommandLineRunner {

    @Autowired
    ElasticsearchOperations elasticsearchTemplate;

    public static void main(String[] args) {
        SpringApplication.run(ElasticsearchApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Running!");
        SearchQuery searchQuery = new NativeSearchQueryBuilder().build();
        List<String> ids = elasticsearchTemplate.queryForIds(searchQuery);
        System.out.println(ids);
    }
}
