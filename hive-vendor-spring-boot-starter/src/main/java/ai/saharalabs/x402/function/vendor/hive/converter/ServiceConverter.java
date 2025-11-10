package ai.saharalabs.x402.function.vendor.hive.converter;

import ai.saharalabs.x402.function.vendor.DeploymentConfig;
import ai.saharalabs.x402.function.vendor.DeploymentRunConfig;
import ai.saharalabs.x402.function.vendor.DeploymentSourceConfig;
import ai.saharalabs.x402.function.vendor.hive.dto.HiveServiceCreateRequest;

public class ServiceConverter {

  public static HiveServiceCreateRequest toRequest(DeploymentConfig config) {
    HiveServiceCreateRequest request = new HiveServiceCreateRequest();
    request.setName(config.getName());

    HiveServiceCreateRequest.Configuration configuration = new HiveServiceCreateRequest.Configuration();
    DeploymentSourceConfig sourceConfig = config.getSourceConfig();
    // TODO only support GIT type for now.
    configuration.setSourceType("GIT");
    configuration.setSourceUri(sourceConfig.getGit());
    configuration.setSourceBranch(sourceConfig.getBranch());
    configuration.setSourceContextDir(sourceConfig.getDir());

    DeploymentRunConfig runConfig = config.getRunConfig();
    configuration.setPort(runConfig.getPort());

    request.setConfiguration(configuration);
    return request;
  }
}
