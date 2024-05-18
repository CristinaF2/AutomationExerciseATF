package objectData;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductObject {

    private String title;
    private String price;
    private Integer quantity;
}
