package model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Cart extends base.Model<Integer>{
    int productIdFk;
    int count;
    int totalPrice;

    public Cart(Integer integer, int productIdFk, int count, int totalPrice) {
        super(integer);
        this.productIdFk = productIdFk;
        this.count = count;
        this.totalPrice = totalPrice;
    }


}
