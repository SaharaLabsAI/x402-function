package ai.saharalabs.x402.function.vendor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeploymentConfig {

  private String name;
  private DeploymentSourceConfig sourceConfig;
  private DeploymentResourceConfig resourceConfig;
  private DeploymentRunConfig runConfig;
}
