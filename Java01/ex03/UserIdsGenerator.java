public class UserIdsGenerator {
    private static final UserIdsGenerator INSTANCE = new UserIdsGenerator();
    private static int id = 0;

    public static UserIdsGenerator getInstance() {
        return (INSTANCE);
    }

    public static int generateId() {
        id++;
        return (id);
    }
}
