package ko.co.company.mylogin2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class UserAccount{

   private String idToken;
   private String emailID;
   private String password;

   public UserAccount(){

   }

   public String getIdToken(){ return idToken;}
   public void setIdToken(String idToken){
      this.idToken = idToken;
   }

   public String getEmailId(){return emailID;}
   public void setEmailID(String emailId) {this.emailID = emailId;}

   public String getPassword() {return password;}
   public void setPassword(String password){this.password = password;}


}