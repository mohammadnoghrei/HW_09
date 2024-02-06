package base;

import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Model <ID extends Serializable> {
    private ID id;
}
