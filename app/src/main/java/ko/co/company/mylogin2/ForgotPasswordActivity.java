package ko.co.company.mylogin2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class ForgotPasswordActivity extends AppCompatActivity {

    EditText edit_email;
    Button Btn;

    FirebaseAuth mAuth;



    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        edit_email = (EditText) findViewById(R.id.edit_email);
        mAuth = FirebaseAuth.getInstance();

    }

    public void forgotPasswordBtnPressed(View v){
        resetPassWord();

    }

    private void   resetPassWord()
    {
        //유효성 검사추가
        String txtEmail = edit_email.getText().toString().trim();

        mAuth.sendPasswordResetEmail(txtEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(ForgotPasswordActivity.this,"비밀번호 재설정시 이메일을 확인하십시오",Toast.LENGTH_LONG);
                    Intent intent = new Intent(ForgotPasswordActivity.this,LoginActivity.class);
                    startActivity(intent);
                }
                else{
                    //유저가 암호를 재설정하지 못한 경우
                    Toast.makeText(ForgotPasswordActivity.this,"비밀번호 재설정을 실패했습니다",Toast.LENGTH_LONG);

                }
            }
        });


    }


}