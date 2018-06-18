package com.spring.boot.config;

import java.net.InetAddress;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages="com.spring.boot.repository")
public class EsConfig {
	@Value("${elasticsearch.host}")
	private String EsHost;

	@Value("${elasticsearch.port}")
	private int EsPort;

	@Value("${elasticsearch.clustername}")
	private String EsClusterName;
	
	@Bean
	public Client client() throws Exception{
		//ES 2.x
//		Settings esSettings = Settings.settingsBuilder()
		//ES 5.x
		Settings esSettings = Settings.builder()
				.put("cluster.name", EsClusterName)
				.put("client.transport.sniff", false)
				.put("client.transport.ping_timeout", "30s")
				.put("network.server", false)
				.put(org.elasticsearch.client.support.AbstractClient.CLIENT_TYPE_SETTING_S.getKey(), "transport")
				.build();
		
		//ES 2.x
//        return TransportClient.builder().settings(esSettings)
//                .build()
//                .addTransportAddress(
//				  new InetSocketTransportAddress(InetAddress.getByName(EsHost), EsPort));
		
		//ES 5.x
		TransportClient client = new PreBuiltTransportClient(esSettings);
		client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(EsHost), EsPort));
		
		return client;
	}
	
	@Bean
	public ElasticsearchOperations elasticsearchTemplate() throws Exception {
		return new ElasticsearchTemplate(client());
	}
}
