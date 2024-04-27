package propertyUtility;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Properties;

public class PropertyUtility {

    private Properties properties;

    public PropertyUtility (String fileName){
         loadFile(fileName);
    }

    //incarcam un fisier
    //@SneakyThrows tine loc la try and catch
    @SneakyThrows(Exception.class)
    private void loadFile(String fileName){
        properties=new Properties();
        FileInputStream file=
                new FileInputStream("src/test/resources/"+fileName+".properties");
        properties.load(file);
    }


    //citim datele din fisierul incarcat
    public HashMap<String,String>  getAllData (){
        HashMap<String,String> testData=new HashMap<>();
        for (String key:properties.stringPropertyNames()){
            testData.put(key,properties.getProperty(key));
        }
        return  testData;
    }
}
