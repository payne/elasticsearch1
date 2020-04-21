package org.mattpayne.study.elasticsearch;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.*;

@Configuration
@EnableElasticsearchRepositories(basePackages = "org.mattpayne.study.elasticsearch")
@ComponentScan(basePackages = { "org.mattpayne.study.elasticsearch" })
public class Config {

    @Value("${elasticsearch.home:/usr/local/Cellar/elasticsearch/5.6.0}")
    private String elasticsearchHome;

    @Value("es-docker-cluster")
    private String clusterName;

//    @Bean
//    public Client client() {
//        Settings elasticsearchSettings = Settings.builder()
//                .put("client.transport.sniff", true)
//                .put("path.home", elasticsearchHome)
//                .put("cluster.name", clusterName).build();
//        TransportClient client = new PreBuiltTransportClient(elasticsearchSettings);
//        try {
//            client.addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"), 9200));
//            return client;
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    @Bean
    public Client client() {
        Settings elasticsearchSettings = Settings.builder()
                .put("client.transport.sniff", true)
          //     .put("path.home", elasticsearchHome)
                .put("cluster.name", clusterName).build();
        TransportClient client = new PreBuiltTransportClient(elasticsearchSettings);
        TransportAddress address = null;
        try {
            address = new TransportAddress(
                    InetAddress.getByName("127.0.0.1"),Integer.valueOf(9200));
            client.addTransportAddress(address);
            return client;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchTemplate(client());
    }
}



