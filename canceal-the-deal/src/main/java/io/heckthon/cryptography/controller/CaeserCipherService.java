/**
 * 
 */
package io.heckthon.cryptography.controller;

import io.heckthon.cryptography.ceaser.cipher.CaesarCipherProcessor;

import org.springframework.stereotype.Service;

/**
 * @author vipink
 *
 */
@Service
public class CaeserCipherService {

	public String process(int shift, String plaintext) {
		return new CaesarCipherProcessor().shiftText(shift, plaintext);
	}
}
