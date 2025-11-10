package ai.saharalabs.x402.function.vendor.config;

import ai.saharalabs.x402.function.vendor.IDeployVendor;
import ai.saharalabs.x402.function.vendor.RoutingDeployVendor;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@AutoConfiguration
@EnableConfigurationProperties(DeployVendorProperties.class)
public class DeployVendorAutoConfiguration {

  @Bean
  @Primary
  @ConditionalOnMissingBean(IDeployVendor.class)
  public IDeployVendor routingDeployVendor(
      DeployVendorProperties props,
      List<IDeployVendor> vendorsFromStarters
  ) {
    Map<String, IDeployVendor> map = vendorsFromStarters.stream()
        .filter(v -> !"routing".equalsIgnoreCase(v.getVendorId()))
        .collect(Collectors.toMap(
            IDeployVendor::getVendorId,
            v -> v,
            (a, b) -> a
        ));

    if (props.getVendor() == null || props.getVendor().isBlank()) {
      throw new IllegalStateException(
          "x402.deploy.vendor is not set. Available vendors: " + map.keySet());
    }

    if (!map.containsKey(props.getVendor())) {
      throw new IllegalStateException(
          "No IDeployVendor found for x402.deploy.vendor=" + props.getVendor()
              + ", available vendors: " + map.keySet());
    }

    return new RoutingDeployVendor(props.getVendor(), map);
  }
}
