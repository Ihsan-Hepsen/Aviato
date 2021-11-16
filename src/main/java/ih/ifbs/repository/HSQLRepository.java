package ih.ifbs.repository;

import ih.ifbs.domain.Entity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface HSQLRepository <T extends Entity> {

    T mapRow(ResultSet rs, int mapRow) throws SQLException;
    T save(T t);
    List<T> delete(T t);
    List<T> findById(int id);
    List<T> read();
}
