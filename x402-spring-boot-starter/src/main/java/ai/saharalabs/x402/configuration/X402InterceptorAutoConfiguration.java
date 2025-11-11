package ai.saharalabs.x402.configuration;

import ai.saharalabs.x402.server.facilitator.FacilitatorClient;
import ai.saharalabs.x402.server.facilitator.HttpFacilitatorClient;
import ai.saharalabs.x402.server.intereptor.X402Interceptor;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@AutoConfiguration
@ConditionalOnClass(WebMvcConfigurer.class)
@EnableConfigurationProperties(X402Configuration.class)
@ConditionalOnProperty(prefix = "x402", name = "enabled", havingValue = "true")
public class X402InterceptorAutoConfiguration {

  @ConditionalOnMissingBean
  @Bean
  public FacilitatorClient x402FacilitatorClient(X402Configuration props) {
    if (props.getFacilitatorBaseUrl() == null) {
      throw new IllegalStateException(
          "x402.facilitator-base-url must be configured when x402 is enabled");
    }
    return new HttpFacilitatorClient(props.getFacilitatorBaseUrl());
  }

  @Bean
  public WebMvcConfigurer x402WebMvcConfigurer(
      X402Configuration properties,
      FacilitatorClient facilitatorClient
  ) {
    return new WebMvcConfigurer() {
      @Override
      public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new X402Interceptor(
            properties.getDefaultPayTo(),
            properties.getNetwork(),
            properties.getAsset(),
            properties.getMaxTimeoutSeconds(),
            facilitatorClient
        ));
      }
    };
  }


}