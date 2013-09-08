package com.uiuc.dslogs;

import java.util.ArrayList;
import java.util.List;

import com.uiuc.dslogs.grep.GrepCommand;
import com.uiuc.dslogs.listener.CommandListener;
import com.uiuc.dslogs.model.Node;
import com.uiuc.dslogs.service.ConnectorService;
import com.uiuc.dslogs.service.IConnectorService;

public class Test {
	public static void main(String[] args) {
		CommandListener commandListener = new CommandListener();
		
		
		commandListener.startService(5989);

		
		
		//GrepCommand ExecGrep = new GrepCommand();
		//ExecGrep.executeGrep(true);

	}
}
