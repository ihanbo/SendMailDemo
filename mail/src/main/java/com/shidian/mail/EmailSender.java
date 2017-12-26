package com.shidian.mail;

import java.io.File;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

class EmailSender {

    private EmailSender() {
    }

    Properties getProperties(EMail eMail) {
        Properties properties = new Properties();
        //地址
        properties.put("mail.smtp.host",eMail.mMail.getHost());
        //端口号
        properties.put("mail.smtp.port", eMail.mMail.getPort());
        //是否验证
        properties.put("mail.smtp.auth", true);
        return properties;
    }


    /** 设置收件人 */
    private void setReceiver(EMail eMail, Message message) throws MessagingException {
        Address[] address = new InternetAddress[eMail.mReciever.length];
        for (int i = 0; i < eMail.mReciever.length; i++) {
            address[i] = new InternetAddress(eMail.mReciever[i]);
        }
        message.setRecipients(Message.RecipientType.TO, address);
    }

    /** 设置邮件文本内容
     * @param eMail
     * @param multipart*/
    private void setTextContent(EMail eMail, MimeMultipart multipart) throws MessagingException {
        //纯文本的话用setText()就行，不过有附件就显示不出来内容了
        MimeBodyPart textBody = new MimeBodyPart();
        textBody.setContent(eMail.mContent,"text/html;charset=utf-8");
        multipart.addBodyPart(textBody);
    }

    /** 添加附件  */
    private void addAttachment(String filePath,MimeMultipart multipart) throws MessagingException {
        FileDataSource fileDataSource = new FileDataSource(new File(filePath));
        DataHandler dataHandler = new DataHandler(fileDataSource);
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setDataHandler(dataHandler);
        mimeBodyPart.setFileName(fileDataSource.getName());
        multipart.addBodyPart(mimeBodyPart);
    }

    /**
     * 发送邮件
     */
    public void sendEmail(EMail eMail) throws Exception {
        Properties properties= getProperties(eMail);
        Session session= Session.getInstance(properties);
        Message message= new MimeMessage(session);
        MimeMultipart multipart= new MimeMultipart("mixed");

        //设置来源去处
        message.setFrom(new InternetAddress(eMail.mAccount));
        setReceiver(eMail,message);

        //设置邮件主题
        message.setSubject(eMail.mTitle);

        //设置文本内容
        setTextContent(eMail,multipart);

        //发送时间
        message.setSentDate(new Date());
        //发送的内容，文本和附件
        message.setContent(multipart);
        message.saveChanges();

        //创建邮件发送对象，并指定其使用SMTP协议发送邮件
        Transport transport = session.getTransport("smtp");
        //登录邮箱
        transport.connect(eMail.mMail.getHost(), eMail.mAccount, eMail.mPwd);
        //发送邮件
        transport.sendMessage(message, message.getAllRecipients());
        //关闭连接
        transport.close();
    }


    public static EmailSender getInstance() {
        return InstanceHolder.instance;
    }

    private static class InstanceHolder {
        private static EmailSender instance = new EmailSender();
    }

}