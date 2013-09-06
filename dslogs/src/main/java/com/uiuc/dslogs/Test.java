package com.uiuc.dslogs;

import java.util.ArrayList;
import java.util.List;

import com.uiuc.dslogs.listener.CommandListener;
import com.uiuc.dslogs.model.Node;
import com.uiuc.dslogs.service.ConnectorService;
import com.uiuc.dslogs.service.IConnectorService;

public class Test {
	public static void main(String[] args) {
		CommandListener commandListener = new CommandListener();
		
		
		commandListener.startService(5989);

		List<Node> nodes = new ArrayList<Node>();
		Node node = new Node();
		node.setIpAddress("127.0.0.1");
		node.setSocket(5989);
        nodes.add(node);
		IConnectorService<Node> connectorService = new ConnectorService();
		connectorService.connect(nodes);

	}
}
