package com.example.login.login.view;

import android.os.Bundle;

import com.example.login.R;
import com.example.login.login.LoginContract;
import com.example.login.login.model.User;
import com.example.login.login.presenter.LoginPresenter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity
        implements LoginContract.View {

    @BindView(R.id.id)
    EditText etTitle;
    @BindView(R.id.pwd)
    EditText etPwd;

    @BindView(R.id.btnSave)
    Button btnSave;

    static final String _TAG = "LoginActivity";

    LoginContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        presenter = new LoginPresenter();
        presenter.setView(this);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = etTitle.getText().toString();
                String pwd = etPwd.getText().toString();
                User user = new User();
                user.setId(id);
                user.setPwd(pwd);
                presenter.loginProc(user);
            }
        });

    }

    private void save() {
        Log.d(_TAG, "title: " + etTitle.getText() + " pwd: " + etPwd.getText());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void loginDone() {
        Toast.makeText(this, " Ok! Done ", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        presenter.removeView();
        super.onDestroy();
    }
}
