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

package ai.saharalabs.x402.model;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Settlement response header that gets base64-encoded into X-PAYMENT-RESPONSE. Matches the
 * structure of Go SettleResponse and TypeScript SettleResponse.
 */
@JsonInclude(JsonInclude.Include.ALWAYS) // Always include all fields, even nulls
public class SettlementResponseHeader {

  /**
   * Whether the settlement was successful.
   */
  public boolean success;

  /**
   * Transaction hash of the settled payment.
   */
  public String transaction;

  /**
   * Network ID where the settlement occurred.
   */
  public String network;

  /**
   * Wallet address of the person who made the payment (can be null).
   */
  public String payer;

  /**
   * Default constructor for Jackson.
   */
  public SettlementResponseHeader() {
  }

  /**
   * Constructor with all fields.
   */
  public SettlementResponseHeader(boolean success, String transaction, String network,
      String payer) {
    this.success = success;
    this.transaction = transaction;
    this.network = network;
    this.payer = payer;
  }
}
