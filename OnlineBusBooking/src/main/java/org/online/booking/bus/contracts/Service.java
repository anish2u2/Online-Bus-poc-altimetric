package org.online.booking.bus.contracts;

public interface Service <T>{

	public void save(T data);
	 
	public void delete(T data);
	
	public void update(T data);
	
}
