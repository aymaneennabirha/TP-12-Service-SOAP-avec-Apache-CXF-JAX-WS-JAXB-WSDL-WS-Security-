package com.example.acme.cxf.impl;

import com.example.acme.cxf.api.HelloService;
import com.example.acme.cxf.model.Person;
import jakarta.jws.WebService;

@WebService(
        serviceName = "HelloService",
        portName = "HelloServicePort",
        endpointInterface = "com.example.acme.cxf.api.HelloService", // ← CORRIGER ICI
        targetNamespace = "http://api.cxf.acme.com/"
)
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        return "Bonjour, " + (name == null ? "inconnu" : name);
    }

    @Override
    public Person findPersonById(String id) {
        return new Person(id, "Ada Lovelace", 36);
    }
}