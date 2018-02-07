package com.wal.monkeys.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		File fromFile = new File("/usr/local/scripts/elk.properties");
//		File toFile = new File("/usr/local/tomcat/webapps/elk-spring-mvc-web/resources");
	
		String from = "/exercise/sts-workspace/elk-spring-mvc-web/Readme.txt";
		String to = "/exercise/sts-workspace/elk-spring-mvc-web/src/main/resources";
		File fromFile = new File(from);
		File toFile = new File(to);

		if (toFile.isDirectory()) {
			System.out.println("Yes...");
			System.out.println("fromFile.getName() = "+fromFile.getName());
            toFile = new File(toFile, fromFile.getName());
            System.out.println("to file = "+toFile);
            
            FileInputStream fis = null;
            FileOutputStream fos = null;
            try {

                fis = new FileInputStream(fromFile);
                fos = new FileOutputStream(toFile);
                byte[] buffer = new byte[4096];
                int bytesRead;

                while ((bytesRead = fis.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }

            } catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
                if (from != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                      System.out.println(e);
                    }
                }
                if (to != null) {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                }
            }
        }

	}

}
