package com.shidian.mail;

import javax.mail.internet.AddressException;

/**
 * Created by hanbo on 2017/12/26.
 */

public class AA {

    public static  void onCreate() {
        //耗时操作要起线程...有几个新手都是这个问题
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    EmailSender sender = new EmailSender();
                    //设置服务器地址和端口，网上搜的到
                    sender.setProperties("smtp.163.com", "25");
                    //分别设置发件人，邮件标题和文本内容
                    sender.setMessage("ihanbo@163.com", "EmailSender", "Java Mail ！");
                    //设置收件人
                    sender.setReceiver("330880496@qq.com");
                    //添加附件
                    //这个附件的路径是我手机里的啊，要发你得换成你手机里正确的路径
                    //sender.addAttachment("/sdcard/DCIM/Camera/asd.jpg");
                    //发送邮件
                    sender.sendEmail("smtp.163.com", "ihanbo@163.com", "hb919119");//<span style="font-family: Arial, Helvetica, sans-serif;">sender.setMessage("你的163邮箱账号", "EmailS//ender", "Java Mail ！");这里面两个邮箱账号要一致</span>

                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
