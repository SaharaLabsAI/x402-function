package ai.saharalabs.x402.function.config;

import ai.saharalabs.x402.function.api.IService;
import ai.saharalabs.x402.function.service.ServiceImpl;
import ai.saharalabs.x402.function.vendor.IDeployVendor;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class X402FunctionAutoConfiguration {

  @Bean
  @ConditionalOnClass(IDeployVendor.class)
  @ConditionalOnMissingBean(IService.class)
  public IService x402Service(IDeployVendor deployVendor) {
    return new ServiceImpl(deployVendor);
  }
}