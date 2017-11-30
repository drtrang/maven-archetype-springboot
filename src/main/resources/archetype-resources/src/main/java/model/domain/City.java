package ${package}.model.domain;

import com.google.common.base.MoreObjects;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * City
 *
 * @author trang
 */
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
@Setter
@Table(name = "city")
public class City implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).omitNullValues()
                .add("id", id)
                .add("name", name)
                .add("state", state)
                .add("country", country)
                .toString();
    }

}