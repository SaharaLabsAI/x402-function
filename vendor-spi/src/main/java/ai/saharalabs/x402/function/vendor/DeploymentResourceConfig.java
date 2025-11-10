package ai.saharalabs.x402.function.vendor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeploymentResourceConfig {

  private Resource request;
  private Resource limit;

  public static final DeploymentResourceConfig DEFAULT;

  static {
    DeploymentResourceConfig config = new DeploymentResourceConfig();
    config.setRequest(Resource.of("500m", "64Mi"));
    config.setLimit(Resource.of("1", "128Mi"));
    DEFAULT = config;
  }

  public static DeploymentResourceConfig defaultConfig() {
    return DEFAULT;
  }
}
