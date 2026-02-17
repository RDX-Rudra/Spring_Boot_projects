package car.example.ioc;

public class NewDataProvider implements UserDataProvider{
    @Override
    public String getUserDetails(){
        return "user details from new data provider";
    }
}
