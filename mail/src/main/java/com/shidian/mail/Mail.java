package com.shidian.mail;

import java.util.Properties;

/**
 * Created by hanbo on 2017/12/26.
 */

public interface Mail {
    String getHost();
    String getPort();


    Mail SINA_MAIL_CN  = new  Mail(){
        @Override
        public String getHost() {
            return "smtp.sina.cn";
        }

        @Override
        public String getPort() {
            return "25";
        }

    };

    Mail MAIL_163  = new  Mail(){
        @Override
        public String getHost() {
            return "smtp.163.com";
        }

        @Override
        public String getPort() {
            return "25";
        }

    };
}
