/**
 * 
 */
package com.churchclerk.apigateway;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

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


	@Bean
	public RouteLocator churchClerkRouteLocator(RouteLocatorBuilder builder) {

		//@formatter:off
		// String uri = "http://httpbin.org:80";
		// String uri = "http://localhost:9080";

		return builder.routes()
				.route(r -> r.path("/api/auth/jwt")
						.filters(f ->
								f.addRequestHeader("X-ReqAnotherHeader", "baz"))
						.uri("http://react:3000")
				)
				.build();

		//@formatter:on

	}


}
