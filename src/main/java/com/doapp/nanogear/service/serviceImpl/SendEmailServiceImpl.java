package com.doapp.nanogear.service.serviceImpl;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import com.doapp.nanogear.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.doapp.nanogear.been.ParamService;
import com.doapp.nanogear.entity.User;
import com.doapp.nanogear.repository.UserRepository;
import com.doapp.nanogear.service.SendEmailService;

@Service
public class SendEmailServiceImpl implements SendEmailService {

    @Autowired
    JavaMailSender mailer;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ParamService paramService;

    @Override
    public void sendEmail(String email, String idUser) throws UnsupportedEncodingException, MessagingException {

        User user = userRepository.findByUserForgotPass(idUser);
        String userToken = user.getCode();

            String link = paramService.getURL() + "/form-resetpassword?token=" + userToken;

            user.setCode(userToken);

            user.setActive(true);

            System.out.println(userToken);

            userRepository.save(user);

            System.out.println(paramService.getURL());

            MimeMessage message = mailer.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(message);

            helper.setFrom("shop@gmail.com", "Lấy lại mật khẩu");
            helper.setTo(email);

            String subject = "Lấy lại mật khẩu";

            String content = "<p>Hello,</p>"
                    + "<p>Bạn có yêu cầu lấy lại mật khẩu.</p>"
                    + "<p>Vui lòng bấm vào link để đặt lại mật khẩu.</p>"
                    + "<p>"
                    + "<br>"
                    + "<br>"
                    +link
                    + "<br>"
                    + "<br>"
                    + "<a href='" +link +"'>Nhấn vào đây</p>"
                    + "<br>"
                    + "<p>Vui lòng bảo mật thư này!!!</p>";

            helper.setSubject(subject);

            helper.setText(content, true);

            mailer.send(message);


    }

}
