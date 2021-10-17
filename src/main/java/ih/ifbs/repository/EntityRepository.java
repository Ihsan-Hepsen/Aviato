package ih.ifbs.repository;

import ih.ifbs.domain.Entity;
import java.util.List;

public interface EntityRepository <T extends Entity> {
    List<T> read();
    T create(T t);
    T findById(int id);
    void delete(T t);
    void update(T t);
}
