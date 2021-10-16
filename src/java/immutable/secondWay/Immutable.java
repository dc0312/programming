package immutable.secondWay;

import java.io.Serializable;

public final class Immutable implements Serializable {
    private final Integer id;

    public Immutable(Integer id) {
        this.id = id;
        //this line prevent it form serialization and reflection
        System.setSecurityManager(new SecurityManager());
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Immutable{" +
                "id=" + id +
                '}';
    }
}
