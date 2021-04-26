import com.grpc_test_server.grpc.GreetingServiceGrpc;
import com.grpc_test_server.grpc.GreetingServiceOuterClass;
import io.grpc.stub.StreamObserver;

public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {

    @Override
    public void greeting(GreetingServiceOuterClass.HelloRequest request,
                         StreamObserver<GreetingServiceOuterClass.HelloResponse> responseObserver) {
        for(int i = 0; i<100; i++) {
            GreetingServiceOuterClass.HelloResponse response = GreetingServiceOuterClass.HelloResponse
                    .newBuilder()
                    .setGreeting("Hello from server, " + request.getName() + " " + i)
                    .build();
            responseObserver.onNext(response);
        }
        responseObserver.onCompleted();
    }
}
