package org.example;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import static org.springframework.boot.WebApplicationType.SERVLET;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class Application
{
    public static void main( String[] args ) {
        new SpringApplicationBuilder(Application.class).run(args);
    }
}
