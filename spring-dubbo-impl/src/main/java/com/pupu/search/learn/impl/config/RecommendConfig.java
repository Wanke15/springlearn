package com.pupu.search.learn.impl.config;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@EnableApolloConfig
@Configuration
@Data
@RefreshScope
public class RecommendConfig {

    @Value("${recommend.recNum:10}")
    private Integer recNum;
}
