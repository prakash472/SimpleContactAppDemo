package com.example.prakash472.contactappdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.prakash472.contactappdemo.data.MySQLiteHelper;
import com.example.prakash472.contactappdemo.model.UserContact;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class ContactDetailActivity extends AppCompatActivity {

    @BindView(R.id.create_contact_first_name)
    TextView first_name;

    @BindView(R.id.create_contact_last_name)
    TextView last_name;

    @BindView(R.id.create_contact_address)
    TextView address;

    @BindView(R.id.create_contact_phn_num)
    TextView phn_num;

    @BindView(R.id.create_contact_image)
    CircleImageView image;

    @BindView(R.id.edit)
    FloatingActionButton edit;

    UserContact userContact;
    MySQLiteHelper mySQLiteHelper;
    String contactUserId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Details");

      getIntentData();
      retrieveContact();
    }

    private void retrieveContact() {
        mySQLiteHelper=new MySQLiteHelper(this);
        userContact=new UserContact();
        userContact=mySQLiteHelper.getContact(Long.parseLong(contactUserId));

        first_name.setText(userContact.getContactUserFirstName());
        last_name.setText(userContact.getContactUserLastName());
        phn_num.setText(userContact.getContactUserPhone());
        address.setText(userContact.getContactUserAddress());

    }

    private void getIntentData() {
        Intent intent=getIntent();
        if (intent!=null){
            contactUserId=intent.getStringExtra("contactUserID");

        }
    }
    @OnClick(R.id.edit)
    void onFabEditContactClicked(){
        Intent intent=new Intent(ContactDetailActivity.this,EditContactActivity.class);
        intent.putExtra("contactUserId",contactUserId);
        startActivity(intent);
    }

}
