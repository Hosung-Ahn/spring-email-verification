package com.emailverification;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmailSendService {
    private final JavaMailSender emailSender;

    public void sendEmail(String toEmail, String title, String context) {
        SimpleMailMessage emailForm = createEmailForm(toEmail, title, context);
        // 버그가 발생하지 않는다고 가정
        // 이메일을 전송했을 때 알 수 없는 버그의 예외처리 필요
        emailSender.send(emailForm);
    }

    private SimpleMailMessage createEmailForm(String toEmail,
                                              String title,
                                              String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject(title);
        message.setText(text);
        return message;
    }
}
