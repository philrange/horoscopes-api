package horoscopes.api;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Horoscope {

    private @Id Long id;

    private String content;

    Horoscope(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    public Long id() {
        return id;
    }

    public String content() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horoscope horoscope = (Horoscope) o;
        return Objects.equals(id, horoscope.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }


}
