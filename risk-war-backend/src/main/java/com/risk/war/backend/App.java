package com.risk.war.backend;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sun.jersey.simple.container.SimpleServerFactory;

/**
 * Hello world!
 *
 */
public class App {

	private final static Logger log = LoggerFactory.getLogger(App.class);

	private final static String DEFAULT_CONTEXT = "META-INF/context.xml";

	private final static String PROPERTIES_FILE_KEY = "properties.file";
	private final static String DEFAULT_PROPERTIES_FILE = "risk_war_backend.properties";

	public static void main(String[] args) {
		try {
			log.info("Application starting...");
			App.createContext(DEFAULT_CONTEXT);
			System.out.println("Initialization done");
			createJaxServer();
		} catch (Throwable ex) {
			log.error("Unhandled exception. Terminating application.", ex);
		}
		try {
			new CountDownLatch(1).await(); // wait until process killed
		} catch (InterruptedException e) {
			log.info("Process interrupted");
		}
	}

	public static ClassPathXmlApplicationContext createContext(
			String contextName) throws IllegalArgumentException, IOException {
		if (System.getProperty(PROPERTIES_FILE_KEY) == null) {
			System.setProperty(PROPERTIES_FILE_KEY, DEFAULT_PROPERTIES_FILE);
		}
		log.info("Classpath: \n{}", System.getProperty("java.class.path")
				.replace(File.pathSeparatorChar, '\n'));
		log.info("Loading context: {}", contextName);
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				contextName);

		context.registerShutdownHook();
		return context;
	}

	private static void createJaxServer() throws IllegalArgumentException,
			IOException {
		Closeable server = null;
		try {
			server = SimpleServerFactory.create("http://localhost:5555");
			System.out.println("Server started on port 5555...");
			System.in.read();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (server != null) {
					server.close();
				}
			} finally {
				;
			}
		}
	}

}
