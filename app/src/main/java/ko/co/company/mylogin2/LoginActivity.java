package ko.co.company.mylogin2;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.IgnoreExtraProperties;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.ktx.Firebase;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth; //파이어베이스인증
    private DatabaseReference mDatabaseREf; //실시간 데이터베이스 인증
    private EditText mEtmail, mEtpwd;
    private Button mBtnRegister,mBtnLogin,Btn_forgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseREf = FirebaseDatabase.getInstance().getReference("message");




        mEtmail = findViewById(R.id.mEtmail);
        mEtpwd = findViewById(R.id.mEtpwd);
        mBtnRegister = findViewById(R.id.mBtnRegister);
        mBtnLogin = findViewById(R.id.mBtnLogin);
        Btn_forgotPassword = findViewById(R.id.Btn_forgotPassword);

        
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strEmail = mEtmail.getText().toString().trim();
                String strpwd = mEtpwd.getText().toString().trim();

                mFirebaseAuth.signInWithEmailAndPassword(strEmail, strpwd).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //로그인 성공
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(LoginActivity.this, "로그인 실패", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });


mBtnRegister.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }
});


    }
    public void txtSignInforgotPassword(View v){
    Intent intent = new Intent(this,ForgotPasswordActivity.class);
    startActivity(intent);
        }


}