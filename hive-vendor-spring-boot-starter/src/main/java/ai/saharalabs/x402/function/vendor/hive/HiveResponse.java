package ai.saharalabs.x402.function.vendor.hive;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HiveResponse<T> {

  private boolean success;
  private String errCode;
  private String errMessage;
  private T data;
}
