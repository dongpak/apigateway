/**
 * 
 */
package com.churchclerk.apigateway;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @author dongp
 *
 */
@SpringBootApplication
public class ApiGatewayApplication {

	private static Logger logger = LoggerFactory.getLogger(ApiGatewayApplication.class);

	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}


}
