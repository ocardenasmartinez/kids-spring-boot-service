package cl.kids.entities.data.kids;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Builder
public class Kids {

    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private Integer age;

}
