package teprinciple.yang.sendmaildemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import teprinciple.yang.sendmaildemo.mail.AA;


public class MainActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.toAddEt);
    }


    public void senTextMail(View view) {
//        SendMailUtil.send("330880496@qq.com");
//        MailManager.getInstance().sendMail("测试测试","我发的邮件");
        AA.onCreate();
    }

    public void sendFileMail(View view) {
    }




}
