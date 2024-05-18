package objectData;


import lombok.Data;
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
    private List<ProductObject> products;

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
        products = new ArrayList<>();
        String[] productsArray=value.split(",");
        for (int index = 0; index<productsArray.length; index++){
            String currentElement = productsArray[index];
            String[] productArray = currentElement.split("-");

            String title = productArray[0];
            String price = productArray[1];
            Integer quantity = Integer.valueOf(productArray[2]);
            products.add(new ProductObject(title, price, quantity));
        }
    }
}
