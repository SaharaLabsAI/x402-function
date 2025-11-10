package ai.saharalabs.x402.function.vendor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeploymentSourceConfig {

  private String git;
  private String branch;
  private String dir;
}
