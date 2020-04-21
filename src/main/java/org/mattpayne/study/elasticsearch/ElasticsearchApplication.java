package org.mattpayne.study.elasticsearch;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ElasticsearchApplication implements CommandLineRunner {

    final RestHighLevelClient client;

    public ElasticsearchApplication(RestHighLevelClient client) {
        this.client = client;
    }

    public static void main(String[] args) {
        SpringApplication.run(ElasticsearchApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Running!");
        // https://www.elastic.co/guide/en/elasticsearch/client/java-rest/current/java-rest-high-search.html
        RequestOptions options=RequestOptions.DEFAULT;
        SearchRequest searchRequest=new SearchRequest();
        SearchSourceBuilder searchSourceBuilder=new SearchSourceBuilder();
        BoolQueryBuilder qb = QueryBuilders.boolQuery();
        qb.must(QueryBuilders.matchAllQuery());
        searchSourceBuilder.query(qb);
        searchRequest.source(searchSourceBuilder);
        System.out.println("searchRequest="+searchRequest);
        System.out.println("searchRequest.source()="+searchRequest.source());
        SearchResponse searchResponse = client.search(searchRequest, options);
        long numHits = searchResponse.getHits().totalHits;
        System.out.println("numHits="+numHits);
    }
}
