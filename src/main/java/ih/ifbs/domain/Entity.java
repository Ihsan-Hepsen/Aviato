package ih.ifbs.domain;

public abstract class Entity {
    protected int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entity entity)) return false;

        return id == entity.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
