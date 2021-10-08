package cl.kids.entities.data;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Builder
@ToString
@Data
public class Kids {

    public Kids() {

    }

    public Kids(Integer id, String name, Integer age) {
        this.id = id; this.name = name; this.age = age;
    }

    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private Integer age;

}
