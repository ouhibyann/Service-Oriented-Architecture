package com.esipe.ms.security;

import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jwt.SignedJWT;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.security.interfaces.RSAPublicKey;
import java.util.List;

@Component
public class JWTTokenValidator {

	
	private InfraSettings setting;
	
	private JWSVerifier verifier;

	public JWTTokenValidator(InfraSettings setting) {
		this.setting = setting;
	}

	@PostConstruct
	public void init(){
		verifier = new RSASSAVerifier((RSAPublicKey)setting.keyPairLoader().getPublic());
	}
	
	public List<String> verifyAndTransform(String token){
		
		try {
			SignedJWT signedJWT = SignedJWT.parse(token);
			
			if(!signedJWT.verify(verifier)){
				throw new RuntimeException("Token cannot be verified. Invalid Token");
			}
			
			return signedJWT.getJWTClaimsSet().getStringListClaim("AUTHORITIES");
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	// public boolean validateTokenIssuer()
	
}
