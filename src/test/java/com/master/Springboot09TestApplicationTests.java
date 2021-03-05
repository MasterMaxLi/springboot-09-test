package com.master;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class Springboot09TestApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    void contextLoads() {
        //发送邮件给自己
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("发给自己的邮件");    //邮件主题
        simpleMailMessage.setText("这是发送的内容");   //邮件内容

        simpleMailMessage.setTo("1763118074@qq.com");   //接收人
        simpleMailMessage.setFrom("1763118074@qq.com"); //发送人
        mailSender.send(simpleMailMessage);
    }

    @Test
    public void sendMailTest() throws MessagingException {
        //复杂的邮件发送
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //组装
        //正文
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setSubject("这是邮件主题");    //邮件主题
        helper.setText("<p style='color:red'>这是邮件的内容</p>", true);   //邮件内容，html为true表示以html语言格式发送

        //附件
        helper.addAttachment("1.jpg", new File("E:/pictures/1.jpg"));
        helper.addAttachment("2.jpg", new File("E:/pictures/2.jpg"));

        helper.setTo("1763118074@qq.com");   //接收人
        helper.setFrom("1763118074@qq.com"); //发送人

        mailSender.send(mimeMessage);
    }

    /**
     * @param subject:邮件主题
     * @param context:邮件内容
     * @param html:是否支持html格式
     * @throws MessagingException
     */

    public void sendMail(String subject, String context, Boolean html) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //组装
        //正文
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setSubject("这是邮件主题");    //邮件主题
        helper.setText("<p style='color:red'>这是邮件的内容</p>", true);   //邮件内容，html为true表示以html语言格式发送

        //附件
        helper.addAttachment("1.jpg", new File("E:/pictures/1.jpg"));
        helper.addAttachment("2.jpg", new File("E:/pictures/2.jpg"));

        helper.setTo("1763118074@qq.com");   //接收人
        helper.setFrom("1763118074@qq.com"); //发送人

        mailSender.send(mimeMessage);

    }

}
