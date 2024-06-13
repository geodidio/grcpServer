package myapp;

import com.acc.grpc.CompanyServiceGrpc;
import com.acc.grpc.UserProto;
import inteface.Company;
import inteface.CompanyServ;
import inteface.InterestService;
import io.grpc.stub.StreamObserver;

import javax.inject.Inject;

public class CompanyService extends CompanyServiceGrpc.CompanyServiceImplBase {
    private final InterestService interestService;
    private final CompanyServ companyServ;
    @Inject
    public CompanyService(InterestService interestService, CompanyServ companyServ) {
        this.interestService = interestService;
        this.companyServ = companyServ;
    }
    @Override
    public void getTax(UserProto.CompanyRequest request, StreamObserver<UserProto.Response> responseObserver) {
        double amount = interestService.calculateInterest(request.getAmount());
        int rank = companyServ.rank(request.getRank());
        UserProto.Response response = UserProto.Response.newBuilder()
                .setMessage("The total calculated is :" + (request.getAmount() + (amount * rank)) + " for " + request.getName() + " company")
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
