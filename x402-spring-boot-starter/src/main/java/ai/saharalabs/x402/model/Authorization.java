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

/**
 * ERC-3009 authorization information within a payment payload. Matches the TypeScript
 * ExactEvmPayloadAuthorization and Go ExactEvmPayloadAuthorization structures.
 */
public class Authorization {

  /**
   * Wallet address of the person making the payment (sender).
   */
  public String from;

  /**
   * Wallet address receiving the payment.
   */
  public String to;

  /**
   * Payment amount in atomic units.
   */
  public String value;

  /**
   * Timestamp after which the authorization is valid.
   */
  public String validAfter;

  /**
   * Timestamp before which the authorization is valid.
   */
  public String validBefore;

  /**
   * Unique hex-encoded nonce to prevent replay attacks.
   */
  public String nonce;

  /**
   * Default constructor for Jackson.
   */
  public Authorization() {
  }
}
