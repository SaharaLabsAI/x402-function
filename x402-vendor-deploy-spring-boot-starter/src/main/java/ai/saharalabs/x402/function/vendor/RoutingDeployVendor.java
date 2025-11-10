package ai.saharalabs.x402.function.vendor;

import java.util.Map;

public class RoutingDeployVendor implements IDeployVendor {

  private final String activeVendorId;
  private final Map<String, IDeployVendor> delegateMap;

  public RoutingDeployVendor(String activeVendorId, Map<String, IDeployVendor> delegateMap) {
    this.activeVendorId = activeVendorId;
    this.delegateMap = delegateMap;
  }

  @Override
  public String getVendorId() {
    // Virtual vendor
    return "routing";
  }

  private IDeployVendor current() {
    IDeployVendor vendor = delegateMap.get(activeVendorId);
    if (vendor == null) {
      throw new IllegalStateException("No IDeployVendor found for vendorId=" + activeVendorId);
    }
    return vendor;
  }

  @Override
  public String deploy(DeploymentConfig config) {
    return current().deploy(config);
  }

  @Override
  public DeploymentStatus status(String id) {
    return current().status(id);
  }
}
