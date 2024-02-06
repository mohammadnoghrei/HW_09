package model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User extends base.Model<Integer>{
    String username;
    String password;

    public User(Integer integer, String username, String password) {
        super(integer);
        this.username = username;
        this.password = password;
    }


}
