package car.example.ioc;

public class WebServiceProvider implements UserDataProvider{
    @Override
    public String getUserDetails(){
        return "user details from web service data provider";
    }
}
