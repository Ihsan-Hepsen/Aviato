package ih.ifbs.repository;

import ih.ifbs.domain.Entity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public abstract class ListRepository <T extends Entity> implements EntityRepository<T> {

    private static final Logger logger = LoggerFactory.getLogger(ListRepository.class);
    protected final List<T> entities = new ArrayList<>();
    // TODO: Implement the methods!!

    @Override
    public List<T> read() {
        logger.debug("Reading all entities");
        return entities;
    }

    @Override
    public T create(T entity) {
        logger.debug("Creating entity: "  + entity + " in: " + this);
        int maxId = entities.stream().mapToInt(Entity::getId).max().orElse(0);
        entity.setId(maxId + 1);
        entities.add(entity);
        return entity;
    }

    @Override
    public T findById(int id) {
        logger.debug("Finding the entity with the id: " + id);
        return entities.stream().filter(e -> e.getId() == id).findFirst().get();
    }

    @Override
    public void delete(T entity) {
        logger.debug("Deleting " + entity);
        entities.remove(entity);
    }

    @Override
    public void update(T entity) {
        logger.debug("Updating: " + entity);
        int index = entities.indexOf(entity);
        entities.set(index, entity);
    }
}
