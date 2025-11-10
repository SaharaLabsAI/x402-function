package ai.saharalabs.x402.function.vendor;

import java.math.BigInteger;
import java.util.Map;
import java.util.Objects;

public record MemoryQuantity(String value) {

  private static final Map<String, BigInteger> UNIT_MAP = Map.ofEntries(
      Map.entry("", BigInteger.ONE),                          // bytes
      Map.entry("K", BigInteger.valueOf(1000L)),
      Map.entry("M", BigInteger.valueOf(1000L).pow(2)),
      Map.entry("G", BigInteger.valueOf(1000L).pow(3)),
      Map.entry("T", BigInteger.valueOf(1000L).pow(4)),
      Map.entry("P", BigInteger.valueOf(1000L).pow(5)),
      Map.entry("E", BigInteger.valueOf(1000L).pow(6)),

      Map.entry("Ki", BigInteger.valueOf(1024L)),
      Map.entry("Mi", BigInteger.valueOf(1024L).pow(2)),
      Map.entry("Gi", BigInteger.valueOf(1024L).pow(3)),
      Map.entry("Ti", BigInteger.valueOf(1024L).pow(4)),
      Map.entry("Pi", BigInteger.valueOf(1024L).pow(5)),
      Map.entry("Ei", BigInteger.valueOf(1024L).pow(6))
  );

  public MemoryQuantity(String value) {
    if (value == null) {
      throw new IllegalArgumentException("Memory quantity cannot be null");
    }
    String v = value.trim();
    if (v.isEmpty()) {
      throw new IllegalArgumentException("Memory quantity cannot be empty");
    }

    BigInteger bytesValue = parseBytes(v);
    if (bytesValue == null) {
      throw new IllegalArgumentException(
          "Invalid memory quantity. Examples: 128974848, 129M, 123Mi, 1G, 1Gi");
    }
    if (bytesValue.compareTo(BigInteger.ZERO) <= 0) {
      throw new IllegalArgumentException("Memory quantity must be > 0");
    }
    if (bytesValue.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) > 0) {
      throw new IllegalArgumentException("Memory quantity is too large");
    }
    this.value = v;
  }

  private static BigInteger parseBytes(String v) {
    // Split the input into numeric and unit parts
    int i = 0;
    while (i < v.length() && (Character.isDigit(v.charAt(i)))) {
      i++;
    }
    String numPart = v.substring(0, i);
    String unitPart = v.substring(i);

    if (numPart.isEmpty()) {
      return null;
    }
    if (!numPart.matches("^[0-9]+$")) {
      return null; // Must be an integer
    }
    if (!UNIT_MAP.containsKey(unitPart)) {
      return null; // Must be a valid unit
    }

    try {
      BigInteger num = new BigInteger(numPart);
      return num.multiply(UNIT_MAP.get(unitPart));
    } catch (NumberFormatException e) {
      return null;
    }
  }

  public static MemoryQuantity of(String value) {
    return new MemoryQuantity(value);
  }

  public MemoryQuantity patch(String newValue) {
    if (newValue == null || newValue.isEmpty() || newValue.equals(this.value)) {
      return this;
    }
    return MemoryQuantity.of(newValue);
  }

  public MemoryQuantity patch(MemoryQuantity other) {
    if (other == null) {
      return this;
    }
    if (Objects.equals(this, other)) {
      return this;
    }
    return this.patch(other.value);
  }
}
