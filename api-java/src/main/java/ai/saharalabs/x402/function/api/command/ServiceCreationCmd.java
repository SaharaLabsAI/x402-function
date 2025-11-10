package ai.saharalabs.x402.function.api.command;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceCreationCmd {

  @Pattern(regexp = "^[A-Za-z0-9\\-]+$", message = "Service name can only contain letters, numbers, and '-'")
  @Size(max = 32, message = "Service name must be less than or equal to 32 characters")
  private String name;

  @NotBlank(message = "Git url must not be blank")
  @Size(max = 2048, message = "Source URI must be less than or equal to 2048 characters")
  private String url;

  @Size(max = 64, message = "Source branch must be less than or equal to 64 characters")
  private String branch;

  @Size(max = 128, message = "Source context directory must be less than or equal to 128 characters")
  private String dir;

  @Max(value = 65535, message = "Port must be less than or equal to 65535")
  @Min(value = 1, message = "Port must be greater than 0")
  private Integer port;
}
