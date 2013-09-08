package com.uiuc.dslogs.grep;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
//import java.lang.Runtime;
public class GrepCommand {

	//private Boolean regEx;
	//private String fileName = "*.rtf";
	//private String cmdString = "/bin/sh/ -c grep he " + fileName;
	private String cmd[] = {"/bin/sh","-c","grep -c he *.rtf"};
	public void executeGrep(boolean regEx)
	{
		try
		{
			Process process = java.lang.Runtime.getRuntime().exec(cmd);
	     	BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            process.waitFor();
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
