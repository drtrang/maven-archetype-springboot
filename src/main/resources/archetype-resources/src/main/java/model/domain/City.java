package ${package}.model.domain;

import com.google.common.base.MoreObjects;
import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "city")
public class City implements Serializable {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    private String name;

    private String state;

    private String country;

    private static final long serialVersionUID = 1L;

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