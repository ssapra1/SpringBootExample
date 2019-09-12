package com.principal.client;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
 
public class helloWorldClient {
    public helloWorldClient() {
        super();
    }
 
    public static void main(String[] args) {
        Client c = Client.create();
        WebResource resource = c.resource("http://localhost:8080/application/users");
        ClientResponse response = resource.get(ClientResponse.class);
        
        
        String entity=response.getEntity(String.class);
        System.out.println(entity);
        
        WebResource resource1 = c.resource("http://localhost:8080/application/getPerson/2");
        ClientResponse response1 = resource.get(ClientResponse.class);
        String entity1=response.getEntity(String.class);
        System.out.println(entity1);
    }
}