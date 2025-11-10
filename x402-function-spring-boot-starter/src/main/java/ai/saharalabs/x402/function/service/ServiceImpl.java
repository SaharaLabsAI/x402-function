package ai.saharalabs.x402.function.service;

import ai.saharalabs.x402.function.api.IService;
import ai.saharalabs.x402.function.api.command.ServiceCreationCmd;
import ai.saharalabs.x402.function.api.dto.ServiceCreateDTO;
import ai.saharalabs.x402.function.api.dto.ServiceDTO;
import ai.saharalabs.x402.function.converter.ServiceConverter;
import ai.saharalabs.x402.function.vendor.DeploymentStatus;
import ai.saharalabs.x402.function.vendor.IDeployVendor;

public class ServiceImpl implements IService{

  private final IDeployVendor deployVendor;

  public ServiceImpl(IDeployVendor deployVendor) {
    this.deployVendor = deployVendor;
  }

  @Override
  public ServiceCreateDTO create(ServiceCreationCmd cmd) {
    String id = deployVendor.deploy(ServiceConverter.toDeploymentConfig(cmd));
    return ServiceCreateDTO.builder().id(id).name(cmd.getName()).build();
  }

  @Override
  public ServiceDTO status(String id) {
    DeploymentStatus status = deployVendor.status(id);
    return ServiceConverter.toDTO(status);
  }
}
