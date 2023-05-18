import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {

    private UsersRepository usersRepository;

    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }
    @Override
    @Transactional
    public List<User> findAll() {
        return usersRepository.findAll();
    }
    @Override
    @Transactional
    public User findById(int id) {
        Optional<Users> result = usersRepository.findById(id);

        User user = null;
        if (result.isPresent()) {
            user = result.get();
        } else {
            throw new RuntimeException("Did not find user id - " + id);
        }

        return user;
    }
    @Override
    @Transactional
    public void save(Users users) {
        usersRepository.save(users);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        usersRepository.deleteById(id);
    }
}
