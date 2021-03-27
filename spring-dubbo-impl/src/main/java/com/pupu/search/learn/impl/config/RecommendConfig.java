package com.pupu.search.learn.impl.config;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "recommend")
@EnableApolloConfig
@Configuration
@Data
public class RecommendConfig {

    @Value("${recommend.recNum:10}")
    private Integer recNum;
}
