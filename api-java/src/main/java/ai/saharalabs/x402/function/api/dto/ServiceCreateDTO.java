package ai.saharalabs.x402.function.api.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ServiceCreateDTO {

  private String id;
  private String name;
}
