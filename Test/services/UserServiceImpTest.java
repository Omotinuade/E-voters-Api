package services;

import com.evoters.data.model.User;
import com.evoters.data.repositories.UserRepository;
import com.evoters.dtos.request.SignUpRequest;
import com.evoters.services.UserService;
import com.evoters.services.UserServiceImpl;
import com.evoters.utils.AgeCalculatorClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserServiceImpTest {

    @Autowired
    private UserService userService = new UserServiceImpl();
    @Autowired
    private UserRepository userRepository;
        private SignUpRequest request;

        @BeforeEach
        public void setUp() {
            request = new SignUpRequest();
            request.setPassword("1234");
            request.setFirstname("Tinu");
            request.setLastName("Bell");
            request.setAddress("312, herbert macaulay road, Sabo, Yaba");
            request.setEmailAddress("speaktoyin5@gmail.com");
        }

        @Test
        public void saveOneUser_countIsOneTest() {
            User user = new User();
            user.setId("1");
            System.out.println(user.getDateRegistered());
            userService.findById("1");
            assertEquals(1, userService.count());
        }
//
//        @Test
//        public void saveOneUser_idOfUserIsOneTest() {
//            User savedUser = userRepository.save(user);
//            assertEquals(1, savedUser.getId());
//        }
//
//        @Test
//        @DisplayName("Update User test")
//        public void saveTwoUsersWithSameId_countIsOneTest() {
//            User savedUser = userRepository.save(user);
//            assertEquals(1, userRepository.count());
//            savedUser.setLastName("Bell");
//            userRepository.save(savedUser);
//            assertEquals(1, userRepository.count());
//
//        }
//
//        @Test
//        public void saveOneUser_findUserByIdTest() {
//            User savedUser = userRepository.save(user);
//            assertEquals(1, savedUser.getId());
//            User foundUser = userRepository.findById(1);
//            assertEquals(foundUser, savedUser);
//        }
//
//        @Test
//        public void saveOneUser_deleteOneUserTest() {
//            userRepository.save(user);
//            assertEquals(1, userRepository.count());
//            userRepository.delete(user);
//            assertEquals(0, userRepository.count());
//        }
//
//        @Test
//        public void saveOneUser_deleteOneUser_countIsZeroTest() {
//            userRepository.save(user);
//            assertEquals(1, userRepository.count());
//            userRepository.delete(1);
//            assertEquals(0, userRepository.count());
//        }
//
//        @Test
//        public void saveThreeUsers_findThreeUser_countIsThreeTest() {
//            userRepository.save(user);
//            User user1 = new User();
//            User user2 = new User();
//            userRepository.save(user1);
//            userRepository.save(user2);
//            assertEquals(3, userRepository.count());
//            List<User> list;
//            list = userRepository.findAll();
//            assertEquals(3, list.size());
//            assertTrue(list.contains(user));
//            assertTrue(list.contains(user1));
//            assertTrue(list.contains(user2));
//        }
//
//        @Test
//        public void saveThreeUsers_deleteAll_countIsZeroTest() {
//            userRepository.save(user);
//            User user1 = new User();
//            User user2 = new User();
//            userRepository.save(user1);
//            userRepository.save(user2);
//            userRepository.deleteAll();
//            assertEquals(0, userRepository.count());
//        }
    }

