package ai.saharalabs.x402.function.vendor;

public interface IDeployVendor {

  String getVendorId();

  String deploy(DeploymentConfig config) throws VendorException;

  DeploymentStatus status(String id) throws VendorException;
}
