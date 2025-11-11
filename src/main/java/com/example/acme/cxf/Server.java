package com.example.acme.cxf;

import com.example.acme.cxf.impl.HelloServiceImpl;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

public class Server {
    public static void main(String[] args) {
        System.out.println("🚀 Starting Apache CXF SOAP Server...");

        String address = "http://localhost:8080/services/hello";
        JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();

        // CORRECTION : Utiliser seulement setServiceBean
        factory.setServiceBean(new HelloServiceImpl());
        factory.setAddress(address);
        // SUPPRIMER : factory.setServiceClass(HelloServiceImpl.class);

        factory.create();

        System.out.println("✅ SOAP Service successfully published!");
        System.out.println("📍 Service URL: " + address);
        System.out.println("📖 WSDL URL: " + address + "?wsdl");
        System.out.println("⏹️  Press Ctrl+C to stop the server...");

        // Garde le serveur actif
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            System.out.println("Server stopped.");
        }
    }
}