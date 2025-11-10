package ai.saharalabs.x402.function.vendor;

import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeploymentStatus {

  private String id;
  private String name;
  private String url;
  private Boolean ready;
  private String message;
  private Map<String, Object> extra;
}
