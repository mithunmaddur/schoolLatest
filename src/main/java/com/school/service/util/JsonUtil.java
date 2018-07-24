package com.school.service.util;

import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource.Builder;

public class JsonUtil {

	public static final String  BASE_SERVICE_URL = Properties.getProperty("service.url"); 

	public static final String BASE_SERVICE_REST_URL = BASE_SERVICE_URL + "/rest";

	private static final String AUTH_HEADER = "Authorization";

	private static final String TOKEN_TYPE_BEARER = "Bearer "; 

	private JsonUtil() {
		// Do nothing
	}

	public static ClientResponse postRequest(Object request, String serviceEndPoint) {
		Client client = Client.create();
		Builder webResource = client.resource(serviceEndPoint).header(AUTH_HEADER, TOKEN_TYPE_BEARER);

		ObjectWriter objectPrettyWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String input = "";
		ClientResponse response = null;
		try {
			input = objectPrettyWriter.writeValueAsString(request);
			response = webResource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, input);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;

	}

}
