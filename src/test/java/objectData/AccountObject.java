package objectData;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Data
public class AccountObject {

    private String email;
    private String password;
    private AccountInfoObject accountInfo;
    private AccountAddressObject accountAddress;
    private List<String> products;

    public AccountObject(HashMap<String,String> testData){
        populateObject(testData);
        accountInfo=new AccountInfoObject(testData);
        accountAddress=new AccountAddressObject(testData);
    }

    //metoda care populeaza acest obiect
    private void populateObject(HashMap<String,String> testData){

        for (String key: testData.keySet()){
            switch (key){
                case "email":
                    setEmail(System.currentTimeMillis()+testData.get(key));
                    break;
                case "password":
                    setPassword(testData.get(key));
                    break;
                case "products":
                    prepareProducts(testData.get(key));
                    break;

            }
        }

    }

    private void prepareProducts(String value){

        String[] productsArray=value.split(",");
        products =new ArrayList<>( Arrays.asList( productsArray));

    }



}
