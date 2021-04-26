import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(9200).addService(new GreetingServiceImpl()).build();
        server.start();
        server.awaitTermination();
    }
}
