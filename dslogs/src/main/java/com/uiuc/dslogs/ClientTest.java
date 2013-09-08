package com.uiuc.dslogs;

import java.util.ArrayList;
import java.util.List;

import com.uiuc.dslogs.model.Node;
import com.uiuc.dslogs.service.ConnectorService;
import com.uiuc.dslogs.service.IConnectorService;

public class ClientTest {
	public static void main(String[] args) {
		List<Node> nodes = new ArrayList<Node>();
		Node node= new Node();
		node.setIpAddress("localhost");
		node.setSocket(5989);
		nodes.add(node);
		IConnectorService<Node> connectorService= new ConnectorService();
		connectorService.connect(nodes);
	}
	
	
}

	

	
