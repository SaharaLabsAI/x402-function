package ai.saharalabs.x402.function.vendor.hive.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "hive.api")
public class HiveApiProperties {

  private String baseUrl;
  private String token;
  private String tokenHeaderName = "Authorization";
  private String account;
  private boolean enabled = true;
}
