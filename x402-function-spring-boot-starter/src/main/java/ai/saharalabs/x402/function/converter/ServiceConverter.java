package ai.saharalabs.x402.function.converter;


import ai.saharalabs.x402.function.api.command.ServiceCreationCmd;
import ai.saharalabs.x402.function.api.dto.ServiceDTO;
import ai.saharalabs.x402.function.vendor.DeploymentConfig;
import ai.saharalabs.x402.function.vendor.DeploymentRunConfig;
import ai.saharalabs.x402.function.vendor.DeploymentSourceConfig;
import ai.saharalabs.x402.function.vendor.DeploymentStatus;

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
}
