import java.util.Objects;

public class LifeStateEvent implements Event {
    private final boolean isAlive;

    LifeStateEvent(boolean isAlive) {
        this.isAlive = isAlive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LifeStateEvent that = (LifeStateEvent) o;
        return isAlive == that.isAlive;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isAlive);
    }

    @Override
    public String toString() {
        return "LifeStateEvent{" +
            "isAlive=" + isAlive +
            '}';
    }

    @Override
    public void dispatch(EventHandler handler) {
        handler.handle(this);
    }
}
