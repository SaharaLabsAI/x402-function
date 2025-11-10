package ai.saharalabs.x402.function.vendor.hive;

import ai.saharalabs.x402.function.vendor.hive.dto.HiveServiceCreateRequest;
import ai.saharalabs.x402.function.vendor.hive.dto.ServiceCreateResultDTO;
import ai.saharalabs.x402.function.vendor.hive.dto.ServiceResultDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

public class HiveHttpClient {

  private final RestClient restClient;

  public HiveHttpClient(RestClient restClient) {
    this.restClient = restClient;
  }

  public HiveResponse<ServiceCreateResultDTO> createService(HiveServiceCreateRequest request) {
    return restClient.post()
        .uri("/services")
        .body(request)
        .retrieve()
        .body(new ParameterizedTypeReference<>() {
        });
  }

  public HiveResponse<ServiceResultDTO> getServiceStatusByName(String name) {
    return restClient.get()
        .uri("/services/name/{name}", name)
        .retrieve()
        .body(new ParameterizedTypeReference<>() {
        });
  }

  public HiveResponse<ServiceResultDTO> getServiceStatusById(String id) {
    return restClient.get()
        .uri("/services/{serviceId}", id)
        .retrieve()
        .body(new ParameterizedTypeReference<>() {
        });
  }
}
