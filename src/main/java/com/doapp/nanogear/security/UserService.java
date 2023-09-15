package com.doapp.nanogear.security;

import com.doapp.nanogear.model.data.ContactUser;
import com.doapp.nanogear.model.data.User;
import com.doapp.nanogear.model.respository.ContactUserRepository;
import com.doapp.nanogear.model.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private ContactUserRepository contactUserRepo;

//    @Autowired
    private PasswordEncoder passwordEncoder;

    private AddImage addImage;

    public User getUserById(int id){
       return userRepo.getUserById(id);
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public User findByUsernameOrEmail(String username) {
        return userRepo.findByUsernameOrEmail(username);
    }
    @Transactional
    public void save(User user) {
        userRepo.save(user);
    }

    public User authenticateUser(String username, String rawPassword) {
        User user = userRepo.findByUsernameOrEmail(username);
        if (user != null) {
            if (checkPassword(rawPassword, user.getPassword())) {
                return user;
            }
        }
        return null;
    }

    @Transactional
    public void changePassword (User user, String newPass){
        String encodedPassword = passwordEncoder.encode(newPass);
        user.setPassword(encodedPassword);

        // Lưu thay đổi vào cơ sở dữ liệu
        userRepo.save(user);
    }
    @Transactional
    public void updateUserAndContactUser(int userId, User updatedUser, ContactUser updatedContactUser, MultipartFile file) {
        // Kiểm tra xem người dùng tồn tại hay không
        Optional<User> existingUser = userRepo.findById(userId);
        if (existingUser.isPresent()) {
            User user = existingUser.get();

            // Kiểm tra xem người dùng muốn cập nhật thông tin User không
            if (updatedUser != null && user.id == updatedUser.id) {
                    // Thực hiện cập nhật thông tin User
                    user.setUsername(updatedUser.getUsername());
                    user.setEmail(updatedUser.getEmail());

                    userRepo.save(user);
            }

            // Kiểm tra xem người dùng muốn cập nhật thông tin ContactUser không
            if (updatedContactUser != null) {
                // Lấy danh sách ContactUser hiện tại của người dùng
                List<ContactUser> contactUsers = user.getContactUsers();

                // Kiểm tra xem người dùng đã có thông tin ContactUser hay chưa
                if (contactUsers != null && !contactUsers.isEmpty()) {
                    // Nếu có thông tin ContactUser, thì tìm ContactUser cần cập nhật
                    for (ContactUser contactUser : contactUsers) {
                        if (contactUser.getId().equals(updatedContactUser.getId())) {
                            // Thực hiện cập nhật thông tin ContactUser
                            contactUser.setFullName(updatedContactUser.getFullName());
                            contactUser.setPhoneNumber(updatedContactUser.getPhoneNumber());
                            contactUser.setImage_url(updatedContactUser.getImage_url());
                            contactUser.setCity(updatedContactUser.getCity());
                            contactUser.setProvince(updatedContactUser.getCity());
                            contactUser.setTotalOrder(updatedContactUser.getTotalOrder());
                            contactUser.setStreet(updatedContactUser.getStreet());
                            contactUser.setTown(updatedContactUser.getTown());
                            addImage.uploadImageU(file);
                            contactUserRepo.save(contactUser);
                            break;
                        }
                    }
                } else {
                    // Nếu người dùng chưa có thông tin ContactUser, thì thêm mới
                    updatedContactUser.setUser(user);
                    contactUserRepo.save(updatedContactUser);
                }
            }

        }
    }

    public boolean checkPassword(String rawPassword, String encodedPassword) {
        return new BCryptPasswordEncoder().matches(rawPassword, encodedPassword);
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
