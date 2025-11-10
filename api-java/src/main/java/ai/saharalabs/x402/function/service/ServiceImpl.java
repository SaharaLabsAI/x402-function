package ai.saharalabs.x402.function.service;

import ai.saharalabs.x402.function.api.IService;
import ai.saharalabs.x402.function.api.command.ServiceCreationCmd;
import ai.saharalabs.x402.function.api.dto.ServiceCreateDTO;
import ai.saharalabs.x402.function.api.dto.ServiceDTO;
import ai.saharalabs.x402.function.converter.ServiceConverter;
import ai.saharalabs.x402.function.vendor.DeploymentStatus;
import ai.saharalabs.x402.function.vendor.IDeployVendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

@Service
public class ServiceImpl implements IService {

  @Autowired
  private IDeployVendor deployVendor;

  @Value("${demo.git-repo.url}")
  private String demoGitRepoUrl;

  @Override
  public ServiceCreateDTO create(ServiceCreationCmd cmd) {
    // TODO for demo purpose
    if (!demoGitRepoUrl.equals(cmd.getUrl())) {
      throw new IllegalArgumentException("Only demo git repo is allowed: " + demoGitRepoUrl);
    }
    // TODO for demo purpose, generate a name if not provided
    if (!StringUtils.hasLength(cmd.getName())) {
      String generatedName = generateServiceName("demo");
      cmd.setName(generatedName);
    }
    // TODO for demo purpose, set default port if not provided
    if (ObjectUtils.isEmpty(cmd.getPort())) {
      cmd.setPort(8081);
    }
    // TODO for demo purpose, set default branch if not provided
    if (!StringUtils.hasLength(cmd.getBranch())) {
      cmd.setBranch("main");
    }

    String id = deployVendor.deploy(ServiceConverter.toDeploymentConfig(cmd));
    return ServiceCreateDTO.builder().id(id).name(cmd.getName()).build();
  }

  @Override
  public ServiceDTO status(String id) {
    DeploymentStatus status = deployVendor.status(id);
    return ServiceConverter.toDTO(status);
  }

  // TODO for demo purpose, generate a unique service name
  private String generateServiceName(String prefix) {
    long timestamp = System.currentTimeMillis();
    return prefix + "-" + timestamp;
  }
}
