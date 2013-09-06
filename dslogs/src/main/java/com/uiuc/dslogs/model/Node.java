package com.uiuc.dslogs.model;

/**
 * Model class representing a node in the cluster
 * 
 * @author Aman's Alien
 * 
 */
public class Node {

	private String name;
	private String ipAddress;
	private Integer socket;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Integer getSocket() {
		return socket;
	}

	public void setSocket(Integer socket) {
		this.socket = socket;
	}

}
