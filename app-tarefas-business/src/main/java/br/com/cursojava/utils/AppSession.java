package br.com.cursojava.utils;

public interface AppSession {
	
	public void addAttribute(String key,Object value);
	public <T> T getAttribute(String key);

}
