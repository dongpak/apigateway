/**
 * 
 */
package com.churchclerk.apigateway;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author dongp
 *
 */
@Configuration
public class GatewayConfig {

	private static Logger logger = LoggerFactory.getLogger(GatewayConfig.class);


	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder builder) {

		//@formatter:off

		return builder.routes()
				.route(r -> r.path("/api/auth/jwt")
						.filters(f ->
								f.addRequestHeader("X-ReqAnotherHeader", "jwt"))
						.uri("http://userapi:8080")
				)
				.route(r -> r.path("/api/auth/info")
						.filters(f ->
								f.addRequestHeader("X-ReqAnotherHeader", "info"))
						.uri("http://userapi:8080")
				)
				.route(r -> r.path("/api/user/**")
						.filters(f ->
								f.addRequestHeader("X-ReqAnotherHeader", "user"))
						.uri("http://userapi:8080")
				)
				.route(r -> r.path("/api/church/**")
						.filters(f ->
								f.addRequestHeader("X-ReqAnotherHeader", "church"))
						.uri("http://churchapi:8080")
				)
				.route(r -> r.path("/api/member/**")
						.filters(f ->
								f.addRequestHeader("X-ReqAnotherHeader", "member"))
						.uri("http://memberapi:8080")
				)
				.route(r -> r.path("/api/contact")
						.filters(f ->
								f.addRequestHeader("X-ReqAnotherHeader", "contact"))
						.uri("http://contactapi:8080")
				)
				.route(r -> r.path("/**")
						.filters(f ->
								f.addRequestHeader("X-ReqAnotherHeader", "react"))
						.uri("http://react:3000")
				)
				.build();

		//@formatter:on

	}


}
