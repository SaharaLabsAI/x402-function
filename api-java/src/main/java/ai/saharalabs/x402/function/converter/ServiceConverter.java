package ai.saharalabs.x402.function.converter;


import ai.saharalabs.x402.function.api.command.ServiceCreationCmd;
import ai.saharalabs.x402.function.api.dto.ServiceDTO;
import ai.saharalabs.x402.function.vendor.DeploymentConfig;
import ai.saharalabs.x402.function.vendor.DeploymentRunConfig;
import ai.saharalabs.x402.function.vendor.DeploymentSourceConfig;
import ai.saharalabs.x402.function.vendor.DeploymentStatus;
import ai.saharalabs.x402.function.vendor.hive.dto.HiveServiceCreateRequest;

public class ServiceConverter {

  public static DeploymentConfig toDeploymentConfig(ServiceCreationCmd cmd) {
    DeploymentConfig config = new DeploymentConfig();
    config.setName(cmd.getName());
    DeploymentSourceConfig sourceConfig = new DeploymentSourceConfig();
    sourceConfig.setGit(cmd.getUrl());
    sourceConfig.setBranch(cmd.getBranch());
    sourceConfig.setDir(cmd.getDir());

    DeploymentRunConfig runConfig = new DeploymentRunConfig();
    runConfig.setPort(cmd.getPort());

    config.setSourceConfig(sourceConfig);
    config.setRunConfig(runConfig);
    return config;
  }

  public static ServiceDTO toDTO(DeploymentStatus status) {
    ServiceDTO dto = new ServiceDTO();
    dto.setId(status.getId());
    dto.setName(status.getName());
    dto.setReady(status.getReady());
    dto.setUrl(status.getUrl());
    dto.setMessage(status.getMessage());
    dto.setExtra(status.getExtra());
    return dto;
  }

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
