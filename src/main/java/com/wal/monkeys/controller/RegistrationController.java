package com.wal.monkeys.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.wal.monkeys.model.User;
import com.wal.monkeys.processor.KafkaaProducer;


@Controller
public class RegistrationController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("user", new User());
	
		updateElkProperties(System.getenv());
		
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("register");
		mav.addObject("user", new User());
	
		return mav;
	}
	
	@RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response, 
			@ModelAttribute("user") User user) {
		
		KafkaaProducer producer = new KafkaaProducer();
		producer.publishMessage(user);
		
		// Commenting it out because there is a separate logstash container is run which takes care of pusing the data from kafka to elasticsearch.
		//KafkaaConsumer consumer = new KafkaaConsumer();
		//consumer.logstshToElastic();
		
		
		return new ModelAndView("registered");
	}
	
	private void updateElkProperties(Map<String, String> env) {
		
		
		Path path = Paths.get("/exercise/sts-workspace/elk-spring-mvc-web/src/main/resources/elk.properties");
			
		Charset charset = StandardCharsets.UTF_8;
		try {

		
			for (String envName : env.keySet()) {
				System.out.println("Environment variables:");
	            System.out.format("%s=%s%n", envName, env.get(envName));
	            if(envName.equals("PROP_HOME")) 
	            		path = Paths.get(env.get(envName));
	         	String content = new String(Files.readAllBytes(path), charset);
				 if(envName.equals("KAFKA_HOST_NAME")) {
	            		content = content.replaceAll("localhost", env.get(envName));
	            		Files.write(path, content.getBytes(charset));
	            } else if (envName.equals("KAFKA_PORT")) {
	                content = content.replaceAll("9092", env.get(envName));
	                Files.write(path, content.getBytes(charset));
	            } else if (envName.equals("KAFKA_TOPIC_NAME")) {
	            		content = content.replaceAll("eslskibana", env.get(envName));
	            		Files.write(path, content.getBytes(charset));
	            }          	
			}
			System.out.println("Path to elk.properties: "+path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

