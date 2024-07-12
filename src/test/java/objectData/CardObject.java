package objectData;

import lombok.Data;

import java.util.HashMap;
@Data
public class CardObject {
    private String cardNumber;
    private String cvcNumber;
    private String expirationMonth;
    private String expirationYear;

    public CardObject(HashMap<String, String> testData) {
        populateObject(testData);
    }
    //metoda care populeaza acest obiect
    private void populateObject(HashMap<String,String> testData){

        for (String key: testData.keySet()){
            switch (key){
                case "cardNumber":
                    setCardNumber(testData.get(key));
                    break;
                case "cvcNumber":
                    setCvcNumber(testData.get(key));
                    break;
                case "expirationMonth":
                    setExpirationMonth(testData.get(key));
                    break;
                case "expirationYear":
                    setExpirationYear(testData.get(key));
                    break;
            }
        }
    }
}
