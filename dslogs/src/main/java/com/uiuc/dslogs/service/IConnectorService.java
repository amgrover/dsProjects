package com.uiuc.dslogs.service;

import java.util.List;
import java.util.Map;

import com.uiuc.dslogs.model.Node;

/**
 * Interface that needs to be implemented for creating a peer to peer connection
 * 
 * @author Aman's Alien
 * 
 */
public interface IConnectorService<T extends Node> {
	Map<String, Integer> connect(List<Node> nodes);

}
