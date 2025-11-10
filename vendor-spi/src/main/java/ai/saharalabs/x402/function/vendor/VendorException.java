package ai.saharalabs.x402.function.vendor;

import lombok.Getter;

@Getter
public class VendorException extends RuntimeException {

  private final String code;

  public VendorException(String code, String message) {
    super(message);
    this.code = code;
  }
}
