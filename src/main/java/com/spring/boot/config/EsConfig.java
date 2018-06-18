package com.spring.boot.config;

import java.net.InetAddress;
import java.net.UnknownHostException;

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

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class EsConfig {
	@Value("${elasticsearch.host}")
	private String EsHost;

	@Value("${elasticsearch.port}")
	private String EsPort;

	@Value("${elasticsearch.clustername}")
	private String EsClusterName;
	
	@Bean
	public Client client() {
		TransportClient client = null;
		
		try {
			//ES 2.x
	//		Settings esSettings = Settings.settingsBuilder()
			//ES 5.x
			Settings esSettings = Settings.builder()
					.put("cluster.name", EsClusterName)
//					.put("cluster.name", "elasticsearch")
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
			client = new PreBuiltTransportClient(esSettings);
			client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(EsHost), Integer.parseInt(EsPort)));
//			client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("192.168.0.10"), Integer.parseInt("9300")));
			
		} catch (NumberFormatException e) {
			log.info("NumberFormatException : ", e);
		} catch (UnknownHostException e) {
			log.info("UnknownHostException : ", e);
		}
		
		return client;
	}
	
	@Bean
	public ElasticsearchOperations elasticsearchTemplate() throws Exception {
		return new ElasticsearchTemplate(client());
	}
}
