public interface UsersList  {
    Integer START_SIZE = 10;
    float SCALE = 1.5F;

    void addUser(User user);
    User getUserById(Integer id);
    User getUserByIndex(Integer index);
    Integer getSize();
}
