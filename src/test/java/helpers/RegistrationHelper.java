package helpers;

import static helpers.RandomizeHelper.*;


public class RegistrationHelper {
    public String first_name;
    public String last_name;
    public String address1;
    public String postcode;
    public String city;
    public String country;
    public Integer zone;
    public String email;
    public String phone;
    public String password;

    public void initCustomer() {
        this.first_name =  getRandomString(7);
        this.last_name =  getRandomString(7);
        this.address1 =  getRandomString(7);
        this.postcode =  getRandomInt(5);
        this.city =  getRandomString(5);
        this.country =  "United States";
        this.zone = Integer.valueOf(getRandomInt(1));
        this.email =  getRandomEmail();
        this.phone =  getRandomInt(7);
        this.password =  getRandomString(4);
    }
}
