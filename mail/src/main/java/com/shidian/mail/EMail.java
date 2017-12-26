package com.shidian.mail;

import java.util.Properties;

/**
 * Created by hanbo on 2017/12/26.
 */

public class EMail {
    private Mail mMail;
    private String mAccount;
    private String mPwd;
    private String mTitle;
    private String mContent;
    private String[] mReciever;

    public EMail sina(String account,String pwd){
        mMail = Mail.SINA_MAIL_CN;
        mAccount = account;
        mPwd = pwd;
        return this;
    }

    public EMail wy163(String account,String pwd){
        mMail = Mail.MAIL_163;
        mAccount = account;
        mPwd = pwd;
        return this;
    }

    public EMail setTitle(String title){
        mTitle = title;
        return this;
    }

    public EMail setContent(String content){
        mContent = content;
        return this;
    }

    public EMail setReciever(String... reciever){
        mReciever = reciever;
        return this;
    }

    public boolean test(){
        return checkStrs(mAccount,mPwd)&&mMail!=null&&mReciever!=null;
    }

    public EMail set(String s){


        return this;
    }

    private Properties getProperties() {
        Properties properties = new Properties();
        //地址
        properties.put("mail.smtp.host",mMail.getHost());
        //端口号
        properties.put("mail.smtp.port", mMail.getPort());
        //是否验证
        properties.put("mail.smtp.auth", true);
        return properties;
    }


    private boolean checkStrs(String... s){
        if(s==null||s.length==0){
            return false;
        }
        for (int i = 0; i < s.length; i++) {
            if(s[i]==null||s[i].length()==0){
                return false;
            }
        }
        return true;
    }
}
