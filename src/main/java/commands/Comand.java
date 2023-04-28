package commands;

/**
 * Является абстрактным классом, от которого наследуются все команды.
 */
public abstract class Comand {
    /**
     * The Key.
     */
    int key;

    /**
     * Sets key.
     *
     * @param key the key
     */
    public void setKey(int key) {
        this.key = key;
    }

    /**
     * The Id.
     */
    int id;

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * The Name.
     */
    String name;

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Execute.
     */
    public abstract void execute();
}