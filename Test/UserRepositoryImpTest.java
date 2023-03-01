import data.model.User;
import data.repositories.UserRepository;
import data.repositories.UserRepositoryImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserRepositoryImpTest {

        private UserRepository userRepository;
        private User user;

        @BeforeEach
        public void setUp() {
            userRepository = new UserRepositoryImp();
            user = new User();
            user.setEmailAddress("Tinu@gmail.com");
            user.setLastName("Bell");
            user.setFirstname("Tinuade");
            user.setPassword("password");
        }

        @Test
        public void saveOneUser_countIsOneTest() {
            userRepository.save(user);
            assertEquals(1, userRepository.count());
        }

        @Test
        public void saveOneUser_idOfUserIsOneTest() {
            User savedUser = userRepository.save(user);
            assertEquals(1, savedUser.getId());
        }

        @Test
        @DisplayName("Update User test")
        public void saveTwoUsersWithSameId_countIsOneTest() {
            User savedUser = userRepository.save(user);
            assertEquals(1, userRepository.count());
            savedUser.setLastName("Bell");
            userRepository.save(savedUser);
            assertEquals(1, userRepository.count());

        }

        @Test
        public void saveOneUser_findUserByIdTest() {
            User savedUser = userRepository.save(user);
            assertEquals(1, savedUser.getId());
            User foundUser = userRepository.findById(1);
            assertEquals(foundUser, savedUser);
        }

        @Test
        public void saveOneUser_deleteOneUserTest() {
            userRepository.save(user);
            assertEquals(1, userRepository.count());
            userRepository.delete(user);
            assertEquals(0, userRepository.count());
        }

        @Test
        public void saveOneUser_deleteOneUser_countIsZeroTest() {
            userRepository.save(user);
            assertEquals(1, userRepository.count());
            userRepository.delete(1);
            assertEquals(0, userRepository.count());
        }

        @Test
        public void saveThreeUsers_findThreeUser_countIsThreeTest() {
            userRepository.save(user);
            User user1 = new User();
            User user2 = new User();
            userRepository.save(user1);
            userRepository.save(user2);
            assertEquals(3, userRepository.count());
            List<User> list;
            list = userRepository.findAll();
            assertEquals(3, list.size());
            assertTrue(list.contains(user));
            assertTrue(list.contains(user1));
            assertTrue(list.contains(user2));
        }

        @Test
        public void saveThreeUsers_deleteAll_countIsZeroTest() {
            userRepository.save(user);
            User user1 = new User();
            User user2 = new User();
            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.deleteAll();
            assertEquals(0, userRepository.count());
        }
    }

