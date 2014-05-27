package com.ankit;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("resources")
public class Application extends ResourceConfig {
    public Application() {
        packages("com.ankit.db", "com.ankit.rs");
    }
}
