package com.esipe.ms.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;

@Configuration
@ConfigurationProperties(prefix =  "app")
public class InfraSettings {

	private Keystore keystore;	
	
	@PostConstruct
	public KeyPair keyPairLoader(){
		
		try(FileInputStream is = new FileInputStream(keystore.getFile())) {
			
			KeyStore kstore = KeyStore.getInstance("PKCS12");
			kstore.load(is, keystore.getPassword().toCharArray());
			
			Key key = kstore.getKey(keystore.getAlias(), keystore.getPassword().toCharArray());
			
			Certificate certificate = kstore.getCertificate(keystore.getAlias());
			
			return new KeyPair(certificate.getPublicKey(), (PrivateKey) key);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public Keystore getKeystore() {
		return keystore;
	}

	public void setKeystore(Keystore keystore) {
		this.keystore = keystore;
	}

	public static class Keystore{
		private String file;
		private String alias;
		private String password;
		public String getFile() {
			return file;
		}
		public void setFile(String file) {
			this.file = file;
		}
		public String getAlias() {
			return alias;
		}
		public void setAlias(String alias) {
			this.alias = alias;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
	}
}
