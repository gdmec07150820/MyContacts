package cn.edu.gdmec.s07150808.mycontacts1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class AddcontactsActivity extends AppCompatActivity {
    private EditText name,workplace,phone,address,qq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);
        name= (EditText) findViewById(R.id.name);
        workplace= (EditText) findViewById(R.id.workplace);
        phone= (EditText) findViewById(R.id.phone);
        address= (EditText) findViewById(R.id.adress);
        qq= (EditText) findViewById(R.id.qq);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE,1,Menu.NONE,"保存");
        menu.add(Menu.NONE,2,Menu.NONE,"退出");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                if(!name.getText().toString().trim().equals("")){
                    User user=new User();
                    user.setName(name.getText().toString().trim());
                    user.setPhone(phone.getText().toString());
                    user.setQq(qq.getText().toString());
                    user.setAddress(address.getText().toString());
                    user.setWorkplace(workplace.getText().toString());
                    ContactsTable contactsTable=new ContactsTable(AddcontactsActivity.this);

                    if( contactsTable.addData(user)){
                        Toast.makeText(this,"保存成功",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(this,"保存失败",Toast.LENGTH_SHORT).show();
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
