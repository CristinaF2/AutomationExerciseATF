package objectData;

import lombok.Data;

import java.util.HashMap;

@Data
public class AccountAddressObject {
    private String firstName;
    private String lastName;
    private String company;
    private String address1;
    private String address2;
    private String country;
    private String state;
    private String city;
    private String zipCode;
    private String mobileNumber;
    public AccountAddressObject(HashMap<String,String> testData){
        populateObject(testData);
    }

    //metoda care populeaza acest obiect
    private void populateObject(HashMap<String,String> testData){

        for (String key: testData.keySet()){
            switch (key){
                case "firstName":
                    setFirstName(testData.get(key));
                    break;
                case "lastName":
                    setLastName(testData.get(key));
                    break;
                case "company":
                    setCompany(testData.get(key));
                    break;
                case "address1":
                    setAddress1(testData.get(key));
                    break;
                case "address2":
                    setAddress2(testData.get(key));
                    break;
                case "country":
                    setCountry(testData.get(key));
                    break;
                case "state":
                    setState(testData.get(key));
                    break;
                case "city":
                    setCity(testData.get(key));
                    break;
                case "zipCode":
                    setZipCode(testData.get(key));
                    break;
                case "mobileNumber":
                    setMobileNumber(testData.get(key));
                    break;

            }
        }

    }


}
