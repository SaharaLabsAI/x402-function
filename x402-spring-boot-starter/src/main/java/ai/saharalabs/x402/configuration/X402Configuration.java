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

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "x402")
public class X402Configuration {

  /**
   * Whether to enable X402 payment interception
   */
  private boolean enabled = false;

  /**
   * Default payee address, can be overridden by @X402Payment.payTo
   */
  private String defaultPayTo;

  /**
   * Network identifier, e.g. base-sepolia
   */
  private String network = "base-sepolia";

  /**
   * Token symbol, e.g. USDC
   */
  private String asset = "USDC";

  /**
   * Maximum payment waiting time (seconds)
   */
  private int maxTimeoutSeconds = 30;

  /**
   * Facilitator base URL. e.g. https://facilitator.example.com
   */
  private String facilitatorBaseUrl;

  // getter / setter

  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  public String getDefaultPayTo() {
    return defaultPayTo;
  }

  public void setDefaultPayTo(String defaultPayTo) {
    this.defaultPayTo = defaultPayTo;
  }

  public String getNetwork() {
    return network;
  }

  public void setNetwork(String network) {
    this.network = network;
  }

  public String getAsset() {
    return asset;
  }

  public void setAsset(String asset) {
    this.asset = asset;
  }

  public int getMaxTimeoutSeconds() {
    return maxTimeoutSeconds;
  }

  public void setMaxTimeoutSeconds(int maxTimeoutSeconds) {
    this.maxTimeoutSeconds = maxTimeoutSeconds;
  }

  public String getFacilitatorBaseUrl() {
    return facilitatorBaseUrl;
  }

  public void setFacilitatorBaseUrl(String facilitatorBaseUrl) {
    this.facilitatorBaseUrl = facilitatorBaseUrl;
  }
}
