package cn.edu.gdmec.s07150808.mycontacts1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class ContactsMessageActivity extends AppCompatActivity {
    private TextView name,workplace,phone,address,qq;
    private  User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_message);
        setTitle("联系人");
        name= (TextView) findViewById(R.id.name);
        workplace= (TextView) findViewById(R.id.workplace);
        phone= (TextView) findViewById(R.id.phone);
        address= (TextView) findViewById(R.id.adress);
        qq= (TextView) findViewById(R.id.qq);

        Bundle bundle=getIntent().getExtras();

        int id=bundle.getInt("user_ID");

        ContactsTable ct=new ContactsTable(this);

        user=ct.getUserId(id);

        name.setText("姓名"+user.getName());
        phone.setText("电话"+user.getPhone());
        qq.setText("QQ"+user.getQq());
        workplace.setText("工作单位"+user.getWorkplace());
        address.setText("地址"+user.getAddress());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE,1,Menu.NONE,"退出");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
