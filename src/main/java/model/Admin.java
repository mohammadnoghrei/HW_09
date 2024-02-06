package model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Admin extends base.Model<Integer>{
    String username;
    String password;

    public Admin(Integer integer, String username, String password) {
        super(integer);
        this.username = username;
        this.password = password;
    }

}
