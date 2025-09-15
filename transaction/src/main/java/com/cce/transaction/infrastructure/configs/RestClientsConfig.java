package com.cce.transaction.infrastructure.configs;

import com.cce.transaction.application.ports.DirectoryServiceClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.client.RestClientBuilderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class RestClientsConfig {
    @Value("${rest.client.api-gateway.base-url}")
    private String apiGatewayBaseUrl;

    @Bean
    DirectoryServiceClient directoryServiceClient(RestClient.Builder restClientBuilder,
                                                  RestClientBuilderConfigurer configurer) {
        RestClient restClient = configurer.configure(restClientBuilder)
                .baseUrl(apiGatewayBaseUrl)
                .build();

        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builderFor(RestClientAdapter.create(restClient))
                .build();

        return factory.createClient(DirectoryServiceClient.class);
    }
}
