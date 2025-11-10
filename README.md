# x402 Function

An open-source backend project combined micropayment protocol and Serverless deployment. 
It enables pay-per-use API, automated service deployment, 
and flexible configuration for cloud-native environments.

## Features
- **x402 Protocol Integration**: Pay-per-use API endpoints with USDC micropayment support.
- **Serverless Deployment**: x402-function implementation with Sahara's Hive Serverless infrastructure. Automated deployment via GitHub repository to Serverless vendor. (Hive/Vercel for example)
- **Kubernetes Ready**: ConfigMap, Service, and scalable deployment tuuuuuemplates.

## Architecture
- **x402** for micropayments and pay-per-use API management
- **Serverless** deployment through Sahara's Hive Serverless infrastructure (extensible to other vendors)

## Quick Startad

### Prerequisites
- JDK 21+
- Maven 3.8+
- Docker & Kubernetes (for cloud deployment)

### Local Development
Refer to: [ryan-alexander-zhang/x402-server-sdk](https://github.com/ryan-alexander-zhang/x402-server-sdk) for instructions on installing the x402 SDK required for local development.

```bash
mvn clean spring-boot:run -f backend/pom.xml
```
Access API docs at: `http://localhost:8086/doc.html` (Knife4j)

### Configuration

Edit `backend/src/main/resources/application-local.properties` for local/dev. Key descriptions:

- `logging.level.root`: Sets the root logging level (e.g., DEBUG, INFO).
- `demo.git-repo.url`: Git repository URL for demo service deployment.
- `x402.facilitator.base-url`: Base URL for x402 facilitator service.
- `x402.default-network`: Default blockchain network for x402 transactions.
- `x402.default-payto`: Default pay-to address for micropayments.
- `x402.deploy.vendor`: Config the deploy vendor.
- `hive.api.base-url`: Base URL for Hive Serverless API.
- `hive.api.account`: Hive account identifier for API access.
- `hive.api.token`: API token for authenticating Hive requests.
- `hive.api.token-header-name`: HTTP header name for Hive API token.
- `knife4j.enable`: Enables Knife4j API documentation UI.
- `knife4j.setting.language`: Language setting for Knife4j UI.
- `app.cors.origins`: Allowed CORS origins for frontend access.
- `app.cors.methods`: Allowed HTTP methods for CORS.
- `app.cors.headers`: Allowed HTTP headers for CORS.
- `app.cors.credentials`: Whether to allow credentials in CORS requests.
- `app.cors.max-age`: CORS preflight cache duration (seconds).

For Kubernetes, use `k8s/x402-function-backend-configmap.yaml` and mount as config.

## Dependencies
- x402 Protocol Server SDK: [ryan-alexander-zhang/x402-server-sdk](https://github.com/ryan-alexander-zhang/x402-server-sdk)
- Spring Boot: [spring-projects/spring-boot](https://github.com/spring-projects/spring-boot)
- Knife4j: [xiaoymin/knife4j](https://github.com/xiaoymin/knife4j)
- Lombok: [projectlombok/lombok](https://github.com/projectlombok/lombok)

## API Usage
### Create Service (Pay-per-use)
```http
POST /apis/x402/v1/services
Content-Type: application/json
{
  "url": "https://github.com/your/repo.git",
  ...
}
```
- Requires 0.01 USDC micropayment
- Returns service info

### Get Service Status
```http
GET /apis/x402/v1/services/{id}
```

## License
MIT License. See [LICENSE](LICENSE) for details.
