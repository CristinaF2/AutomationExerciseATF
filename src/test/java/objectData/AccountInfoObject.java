package objectData;

import lombok.Data;

import java.util.HashMap;

@Data
public class AccountInfoObject {
    private String password;
    private String name;
    private String title;
    private String day;
    private String month;
    private String year;
    private Boolean newsletter;
    private Boolean specialOffers;
    private String accountCreatedMessage;

    public AccountInfoObject(HashMap<String,String> testData){
        populateObject(testData);
    }

    //metoda care populeaza acest obiect
    private void populateObject(HashMap<String,String> testData){

        for (String key: testData.keySet()){
            switch (key){
                case "password":
                    setPassword(testData.get(key));
                    break;
                case "name":
                    setName(testData.get(key));
                    break;
                case "title":
                    setTitle(testData.get(key));
                    break;
                case "day":
                    setDay(testData.get(key));
                    break;
                case "month":
                    setMonth(testData.get(key));
                    break;
                case "year":
                    setYear(testData.get(key));
                    break;
                case "newsletter":
                    setNewsletter(Boolean.parseBoolean(testData.get(key)));
                    break;
                case "specialOffers":
                    setSpecialOffers(Boolean.parseBoolean(testData.get(key)));
                    break;
                case "accountCreatedMessage":
                    setAccountCreatedMessage(testData.get(key));
            }
        }

    }

}
