package ru.gb.dataBaseUsers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/**
 * Сервисный класс для работы с пользователями.
 */
@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;
    /**
     * Получить список всех пользователей.
     *
     * @return список всех пользователей
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    /**
     * Получить пользователя по идентификатору.
     *
     * @param id идентификатор пользователя
     * @return пользователь, если найден
     */
    public Optional<User> getUserByID(Long id) {
        return userRepository.findById(id);
    }

    /**
     * Создать нового пользователя.
     *
     * @param user данные нового пользователя
     * @return созданный пользователь
     */
    public User createUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Обновить данные пользователя.
     *
     * @param id идентификатор пользователя
     * @param userDetails данные для обновления
     * @return обновленный пользователь, если найден и обновлен
     */
    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());
            return userRepository.save(user);
        }
        return null;
    }

    /**
     * Удалить пользователя по идентификатору.
     *
     * @param id идентификатор пользователя
     */
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
