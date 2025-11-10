package ai.saharalabs.x402.function.vendor.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "x402.deploy")
public class DeployVendorProperties {

  /**
   * Vendor ID. Foe example, hive
   */
  private String vendor;
}
