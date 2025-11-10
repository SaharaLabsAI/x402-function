package ai.saharalabs.x402.function.vendor;

import java.math.BigDecimal;
import java.util.Objects;

public record CpuQuantity(String value) {

  private static final String DECIMAL_CORE_REGEX = "^[0-9]+(?:\\.[0-9]{1,3})?$";
  private static final String MILLI_REGEX = "^[0-9]+m$";

  public CpuQuantity(String value) {
    if (value == null) {
      throw new IllegalArgumentException("CPU quantity cannot be null");
    }
    String v = value.trim();
    if (v.isBlank()) {
      throw new IllegalArgumentException("CPU quantity cannot be empty");
    }

    Long mc = parseToMilliCores(v);
    if (mc == null) {
      throw new IllegalArgumentException("Invalid CPU quantity. Examples: 500m, 1, 0.5, 0.125");
    }
    if (mc <= 0) {
      throw new IllegalArgumentException("CPU quantity must be > 0");
    }
    this.value = v;
  }

  private static Long parseToMilliCores(String v) {
    if (v.endsWith("m")) {
      if (!v.matches(MILLI_REGEX)) {
        return null;
      }
      try {
        return Long.parseLong(v.substring(0, v.length() - 1));
      } catch (NumberFormatException e) {
        return null;
      }
    }
    if (!v.matches(DECIMAL_CORE_REGEX)) {
      return null;
    }
    try {
      BigDecimal cores = new BigDecimal(v);
      BigDecimal milli = cores.movePointRight(3);
      if (milli.stripTrailingZeros().scale() > 0) {
        return null;
      }
      return milli.longValueExact();
    } catch (Exception e) {
      return null;
    }
  }

  public static CpuQuantity of(String value) {
    return new CpuQuantity(value);
  }

  public CpuQuantity patch(String newValue) {
    if (newValue == null || newValue.isBlank() || newValue.equals(this.value)) {
      return this;
    }
    return CpuQuantity.of(newValue);
  }

  public CpuQuantity patch(CpuQuantity other) {
    if (other == null) {
      return this;
    }
    if (Objects.equals(this, other)) {
      return this;
    }
    return this.patch(other.value);
  }
}
