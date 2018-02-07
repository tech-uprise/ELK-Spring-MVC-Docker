package com.wal.monkeys.processor;

import java.io.File;
import java.io.IOException;

public class KafkaaConsumer {	
	public void logstshToElastic() {		
		try {						
			Process proc = null;			
			//File workingDir = new File("/exercise/sts-workspace/elk-spring-mvc-web/WebContent/resources/");
			File workingDir = new File("../resources/");			
			System.out.println("Resource dir: " + workingDir);			
			proc = Runtime.getRuntime().exec("/bin/bash -c runlogstash.sh", null, workingDir);						
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
