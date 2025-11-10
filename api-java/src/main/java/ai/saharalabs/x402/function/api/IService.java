package ai.saharalabs.x402.function.api;


import ai.saharalabs.x402.function.api.command.ServiceCreationCmd;
import ai.saharalabs.x402.function.api.dto.ServiceCreateDTO;
import ai.saharalabs.x402.function.api.dto.ServiceDTO;

public interface IService {

  ServiceCreateDTO create(ServiceCreationCmd cmd);

  ServiceDTO status(String id);
}
