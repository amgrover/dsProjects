package com.uiuc.dslogs.grep;
import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.lang.Runtime;
public class GrepCommand {

	//private Boolean regEx;
	//private String fileName = "*.rtf";
	//private String cmdString = "/bin/sh/ -c grep he " + fileName;
	
	public void executeGrep(boolean regEx)
	{
		try{
			//if(regEx)
			//cmdString.concat(" -E");
			//java.lang.Runtime.getRuntime().exec(cmdString + fileName);
			Process process = new ProcessBuilder("ls"/* "-c", "he", "*.rtf"*/).start();
			//process.waitFor();
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line = "";
            while((line = br.readLine()) != null) {
                System.out.println(line);
	        }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
