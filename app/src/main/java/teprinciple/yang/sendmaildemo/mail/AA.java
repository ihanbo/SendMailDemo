package teprinciple.yang.sendmaildemo.mail;

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
                    EMail.wy163( "ihanbo@163.com", "hb919119")
                            .setTitle("新浪邮箱")
                            .setContent("测试发送")
                            .setReciever("330880496@qq.com").send();
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
