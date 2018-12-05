package br.com.cursojava.utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ValidationResult {
	
private Map<String, String> messages = new HashMap<>();
	
	public void addErrorMessage(String key,String message){
		messages.put(key, message);
	}
	
	public boolean isOk(){
		return messages.isEmpty();
	}
	public Map<String, String> getMessages(){
		return Collections.unmodifiableMap(messages);
	}

}
