# x402 Spring Boot Starter

## Overview

The x402 Spring Boot Starter provides seamless integration of the x402 Server SDK and vendor SPI
into Spring Boot applications. It enables automatic payment interception and settlement for web
endpoints, supporting blockchain-based payments (e.g., USDC on Base Sepolia).

## Features

- Integrates with vendor SPI for payment verification and settlement.
- Integrates with x402 Server SDK for blockchain payment processing.
- Auto-configures payment interceptors for Spring MVC endpoints.
- Supports custom payment requirements via annotations.

## Installation

Add the following dependency to your Maven `pom.xml`:

```xml

<dependency>
  <groupId>ai.saharalabs.x402-function</groupId>
  <artifactId>x402-spring-boot-starter</artifactId>
  <version>1.0-SNAPSHOT</version>
</dependency>
```

## Configuration

Configure the starter in your `application.properties`:

```properties
x402.enabled=true
x402.default-pay-to=your-payee-address
x402.network=base-sepolia
x402.asset=USDC
x402.max-timeout-seconds=30
x402.facilitator-base-url=https://facilitator.example.com
```

## Usage

Annotate your controller or method with `@X402Payment` to require payment for access:

```java

@RestController
public class DemoController {

  @X402Payment(price = "10000", payTo = "your-payee-address")
  @GetMapping("/protected")
  public String protectedEndpoint() {
    return "This endpoint requires payment.";
  }
}
```

## How It Works

- The starter auto-configures a payment interceptor (`X402Interceptor`) for your web endpoints.
- Payment requirements can be set globally or per endpoint using the `@X402Payment` annotation.
- The interceptor verifies and settles payments using the configured facilitator client.

## License

See the LICENSE file for details.

## Notice

See the NOTICE file for details.

