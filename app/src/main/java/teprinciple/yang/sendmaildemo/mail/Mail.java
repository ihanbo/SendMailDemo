package teprinciple.yang.sendmaildemo.mail;

/**
 * Created by hanbo on 2017/12/26.
 */

public interface Mail {
    String getHost();
    String getPort();
    boolean checkAccount(String account);

    Mail SINA_MAIL_CN  = new  Mail(){
        @Override
        public String getHost() {
            return "smtp.sina.cn";
        }

        @Override
        public String getPort() {
            return "25";
        }

        @Override
        public boolean checkAccount(String account) {
            return account.endsWith("@sina.cn");
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
        @Override
        public boolean checkAccount(String account) {
            return account.endsWith("@163.com");
        }

    };


}
