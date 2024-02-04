package model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Category extends base.Model<Integer>{
    String categoryName;

    public Category(Integer integer, String categoryName) {
        super(integer);
        this.categoryName = categoryName;
    }


}
