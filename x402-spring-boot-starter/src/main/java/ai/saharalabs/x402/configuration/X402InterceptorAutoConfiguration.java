/*
 * MIT License
 *
 * Copyright © 2025 Sahara AI
 *
 * This file is part of the x402-function project.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package ai.saharalabs.x402.configuration;

import ai.saharalabs.x402.server.facilitator.FacilitatorClient;
import ai.saharalabs.x402.server.facilitator.HttpFacilitatorClient;
import ai.saharalabs.x402.server.intereptor.X402Interceptor;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@AutoConfiguration
@ConditionalOnClass(WebMvcConfigurer.class)
@EnableConfigurationProperties(X402Configuration.class)
@ConditionalOnProperty(prefix = "x402", name = "enabled", havingValue = "true")
public class X402InterceptorAutoConfiguration {

  @ConditionalOnMissingBean
  @Bean
  public FacilitatorClient x402FacilitatorClient(X402Configuration props) {
    if (props.getFacilitatorBaseUrl() == null) {
      throw new IllegalStateException(
          "x402.facilitator-base-url must be configured when x402 is enabled");
    }
    return new HttpFacilitatorClient(props.getFacilitatorBaseUrl());
  }

  @Bean
  public WebMvcConfigurer x402WebMvcConfigurer(
      X402Configuration properties,
      FacilitatorClient facilitatorClient
  ) {
    return new WebMvcConfigurer() {
      @Override
      public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new X402Interceptor(
            properties.getDefaultPayTo(),
            properties.getNetwork(),
            properties.getAsset(),
            properties.getMaxTimeoutSeconds(),
            facilitatorClient
        ));
      }
    };
  }


}