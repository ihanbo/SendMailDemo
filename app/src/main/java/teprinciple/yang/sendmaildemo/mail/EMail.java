package teprinciple.yang.sendmaildemo.mail;

/**
 * Created by hanbo on 2017/12/26.
 */

public class EMail {
    Mail mMail;
    String mAccount;
    String mPwd;
    String mTitle;
    String mContent;
    String[] mReciever;

    public static EMail sina(String account, String pwd){
        EMail email = new EMail();
        email.mMail = Mail.SINA_MAIL_CN;
        email.mAccount = account;
        email.mPwd = pwd;
        return email;
    }

    public static EMail wy163(String account, String pwd){
        EMail email = new EMail();
        email.mMail = Mail.MAIL_163;
        email.mAccount = account;
        email.mPwd = pwd;
        return email;
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

    public void send() throws Exception{
        if(!check()){
            throw new RuntimeException("检查未通过!");
        }
        EmailSender.getInstance().sendEmail(this);
    }

    private boolean check(){
        return checkStrs(mAccount,mPwd)
                &&mMail!=null
                &&mMail.checkAccount(mAccount)
                &&mReciever!=null;
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
