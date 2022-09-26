public class UsersArrayList implements UsersList {
    private int arrStartSize = START_SIZE;
    private Integer size = 0;
    private User[] users = new User[START_SIZE];

    @Override
    public void addUser(User user) {
        if (size == arrStartSize - 1) {
            users = reallocUsers(users);
        }
        if (user != null) {
            users[size] = user;
            size++;
        } else {
            throw new NullPointerException();
        }
    }

    private User[] reallocUsers(User[] users) {
        arrStartSize *= SCALE;
        User[] ret = new User[arrStartSize];

        for (int i = 0; i <= size; i++) {
            ret[i] = users[i];
        }
        return (ret);
    }

    @Override
    public User getUserById(Integer id) throws UserNotFoundException {
        for (int i = 0; i < size; i++) {
            if (users[i].getIdentifier().equals(id)) {
                return (users[i]);
            }
        }
        throw new UserNotFoundException();
    }

    @Override
    public User getUserByIndex(Integer index) throws UserNotFoundException {
        if (index < 0) {
            System.out.println("Index is too low error");
            System.exit(-1);
        } else if (users[index] == null) {
            throw new UserNotFoundException();
        }
        return (users[index]);
    }

    @Override
    public Integer getSize() {
        return (size);
    }
}
