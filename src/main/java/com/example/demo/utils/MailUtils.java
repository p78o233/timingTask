package com.example.demo.utils;/*
 * @author p78o2
 * @date 2019/8/29
 */

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

//发送邮件工具类
public class MailUtils  {

    public static void sendSimpleMail(JavaMailSender sender,String to,String subject,String content){
        MimeMessage message = null;
        try {
            message = sender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("953712390@qq.com");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content);
            sender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }


}
