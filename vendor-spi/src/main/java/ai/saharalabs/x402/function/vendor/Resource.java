package ai.saharalabs.x402.function.vendor;

public record Resource(CpuQuantity cpu, MemoryQuantity memory) {

  public Resource {
    if (cpu == null) {
      throw new IllegalArgumentException("CPU quantity cannot be null");
    }
    if (memory == null) {
      throw new IllegalArgumentException("Memory quantity cannot be null");
    }
  }

  public static Resource of(CpuQuantity cpu, MemoryQuantity memory) {
    return new Resource(cpu, memory);
  }

  public static Resource of(String cpu, String memory) {
    return new Resource(CpuQuantity.of(cpu), MemoryQuantity.of(memory));
  }
}
