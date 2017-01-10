package cn.edu.gdmec.s07150808.mycontacts1;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateContatcsActivity extends AppCompatActivity {
    private EditText name,workplace,phone,address,qq;
    private  User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);
        name= (EditText) findViewById(R.id.name);
        workplace= (EditText) findViewById(R.id.workplace);
        phone= (EditText) findViewById(R.id.phone);
        address= (EditText) findViewById(R.id.adress);
        qq= (EditText) findViewById(R.id.qq);

        Bundle bundle=getIntent().getExtras();

        int id=bundle.getInt("user_ID");

        ContactsTable ct=new ContactsTable(this);

        user=ct.getUserId(id);
        name.setText(user.getName());
        phone.setText(user.getPhone());
        qq.setText(user.getQq());
        workplace.setText(user.getWorkplace());
        address.setText(user.getAddress());


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,1,0,"确定");
        menu.add(0,2,0,"退出");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                if(!name.getText().toString().trim().equals("")){
                    user.setName(name.getText().toString().trim());
                    user.setPhone(phone.getText().toString());
                    user.setQq(qq.getText().toString());
                    user.setAddress(address.getText().toString());
                    user.setWorkplace(workplace.getText().toString());
                    ContactsTable contactsTable=new ContactsTable(this);

                    if( contactsTable.UpdateUser(user)){
                        Toast.makeText(this,"更新成功",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(this,"更新失败",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(this,"请输入数据",Toast.LENGTH_SHORT).show();
                }

                break;
            case 2:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
