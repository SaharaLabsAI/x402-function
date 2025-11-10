package ai.saharalabs.x402.function.vendor.hive.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceResultDTO {

  private String id;
  private String name;
  private Boolean ready;
  private String url;
  private String reason;
  private String message;
  private List<RevisionResultDTO> revisions;
  private List<DeployStatusResultDTO> deployStatuses;

  @Getter
  @Setter
  public static class RevisionResultDTO {

    private String name;
    private String image;
    private Integer desiredReplicas;
    private Integer actualReplicas;
    private Integer percentage;
    private Boolean ready;
    private String reason;
    private String message;
  }

  @Getter
  @Setter
  public static class DeployStatusResultDTO {

    private String phase;
    private String status;
  }
}
