package ai.saharalabs.x402.function.vendor.hive.dto;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HiveServiceCreateRequest {

  private String name;
  private Configuration configuration;

  @Getter
  @Setter
  public static class Configuration {

    private String sourceType;
    private String sourceUri;
    private String sourceBranch;
    private String sourceContextDir;
    private Integer port;
    private List<Env> envs;
    private Integer concurrencyLimit;
    private String readinessProbe;
    private String livenessProbe;
    private String cpuRequest;
    private String memoryRequest;
    private String cpuLimit;
    private String memoryLimit;
    private Integer minScale;
    private Integer maxScale;
    private Integer initScale;
    private String windowScale;
    private String metric;
    private Integer target;
    private Integer utilization;
    private String dockerConfig;
    private String pvcSize;
    private List<Env> buildEnvs;

    @Getter
    @Setter
    @Builder
    public static class Env {

      private String name;
      private String value;
    }
  }
}
