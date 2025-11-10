package ai.saharalabs.x402.function.api.dto;

import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceDTO {

  private String id;
  private String name;
  private Boolean ready;
  private String url;
  private String message;
  private Map<String, Object> extra;
}
