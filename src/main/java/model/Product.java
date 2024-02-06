package model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Product extends base.Model<Integer>{
    String productName;
    int categoryIdFk;
    int productCount;
    int ProductPrice;

    public Product(Integer integer, String productName, int categoryIdFk, int productCount, int productPrice) {
        super(integer);
        this.productName = productName;
        this.categoryIdFk = categoryIdFk;
        this.productCount = productCount;
        this.ProductPrice = productPrice;
    }

    public int getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(int productPrice) {
        ProductPrice = productPrice;
    }
}
