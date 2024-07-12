package objectData;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ProductObject {

    private String title;
    private String price;
    private Integer quantity;
    private Integer finalPrice;

    public ProductObject(String title, String price, Integer quantity) {
        this.title = title;
        this.price = price;
        this.quantity = quantity;
        calculateFinalPrice();
    }

    private void calculateFinalPrice(){
        String priceValue=price.split(" ")[1];
        if (quantity>1) {
            finalPrice = Integer.parseInt(priceValue) * quantity;
        }else{
            finalPrice=Integer.parseInt(priceValue);
        }
    }
}
