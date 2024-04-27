package tests;

import objectData.AccountObject;
import org.testng.annotations.Test;
import propertyUtility.PropertyUtility;

public class BuyProductTest {

    @Test
    public void testMethod(){

        PropertyUtility propertyUtility=new PropertyUtility("testData/BuyProductData");
        AccountObject accountObject=new AccountObject(propertyUtility.getAllData());
        System.out.println();


    }


}
