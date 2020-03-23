package com.esipe.ms.security;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Component
public class JWTTokenGenerator {

	private InfraSettings infraSettings;
	
	private JWSSigner signer;

	public JWTTokenGenerator(InfraSettings infraSettings) {
		this.infraSettings = infraSettings;
	}
	
	@PostConstruct
	public void init(){
		signer = new RSASSASigner(infraSettings.keyPairLoader().getPrivate());
	}
	
	
	public String generateToken(String subject, List<String> authorities){
		
		JWSHeader header =  new JWSHeader.Builder(JWSAlgorithm.RS256)
				                         .keyID(UUID.randomUUID().toString())
				                         .type(JOSEObjectType.JWT)
				                         .build();
		
		JWTClaimsSet claimset = new JWTClaimsSet.Builder()
											    .subject(subject)
											    .audience("WEB")
											    .issuer("ESIPE_BACK")
											    .issueTime(Date.from(ZonedDateTime.now().toInstant()))
											    .expirationTime(Date.from(ZonedDateTime.now().plusDays(7).toInstant()))
											    .claim("AUTHORITIES", authorities)
											    .claim("key", "value")
											    .build();
		
		SignedJWT signedJWT = new SignedJWT(header, claimset);
		
		try {
			
			signedJWT.sign(signer);
			
			return signedJWT.serialize();
			
		} catch (JOSEException e) {
			throw new RuntimeException(e);
		}
	}
}
