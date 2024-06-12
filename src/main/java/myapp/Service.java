package myapp;

import com.google.inject.Guice;
import com.google.inject.Injector;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import module.InterestModule;

import java.io.IOException;

public class Service {


    public static void main(String[] args) throws IOException, InterruptedException {
        //Inject module
        Injector inject = Guice.createInjector(new InterestModule());
        //After get the instance of the object, it's allowed to access their methods
        Server server = ServerBuilder.forPort(9090).addService(inject.getInstance(CompanyService.class)).build();
        server.start();
        System.out.println("Server started on port 9090.");
        System.out.println("Waiting for incoming requests...");
        server.awaitTermination();

    }
}
