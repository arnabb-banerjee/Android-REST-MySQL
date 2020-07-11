package arnab.evol.general;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import arnab.evol.Entity.LoggedUserInfo;

public class common {

    //public static final String ServiceUrl = "http://localhost:8080/rest/";
    public static final int NoOfProductsInARow_MainPage = 3;

    public static final String ErrorMsg_On_NULL = "Some error happend. Please try again";
    public static final String ErrorMsg_No_Record_Found = "No record to be previewed!";
    public static final String ErrorLogPath = "C:/test/ErrorLog.txt";

    public static LoggedUserInfo GetLoggedUserInfo(Context context){
        LoggedUserInfo obj = LoggedUserInfo.GetInstance();

        SharedPreferences sharedPreferences = context.getSharedPreferences("user_session", Context.MODE_PRIVATE);
        obj.setUser_type(sharedPreferences.getString("user_type", null));
        obj.setuser_code(sharedPreferences.getString("user_code", null));
        obj.setEmail(sharedPreferences.getString("email", null));
        obj.setMobile(sharedPreferences.getString("mobile", null));
        obj.setUser_password_status(sharedPreferences.getString("user_password_status", null));
        obj.setUser_status(sharedPreferences.getString("user_status", null));

        return obj;
    }

    public static void SetLoggedUserInfo(Context context, String user_type, String user_code, String email, String mobile,
                                         String user_password_status, String user_status){
        try {
            SharedPreferences.Editor sharedPreferences = context.getSharedPreferences("user_session", Context.MODE_PRIVATE).edit();
            sharedPreferences.putString("user_type", user_type);
            sharedPreferences.putString("user_code", user_code);
            sharedPreferences.putString("email", email);
            sharedPreferences.putString("mobile", mobile);
            sharedPreferences.putString("user_password_status", user_password_status);
            sharedPreferences.putString("user_status", user_status);

            sharedPreferences.commit();
        }
        catch (Exception ex){
            throw ex;
        }
    }

    public static void LogoutUser(Context context){
        try {
            SharedPreferences.Editor sharedPreferences = context.getSharedPreferences("user_session", Context.MODE_PRIVATE).edit();
            sharedPreferences.remove("user_type");
            sharedPreferences.remove("user_code");
            sharedPreferences.remove("email");
            sharedPreferences.remove("mobile");
            sharedPreferences.remove("user_password_status");
            sharedPreferences.remove("user_status");

            sharedPreferences.commit();
        }
        catch (Exception ex){
            throw ex;
        }
    }


    public static void ShowToast(Context context, String msg)
    {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }

    public static void open(final Context context){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setMessage("Are you sure, You wanted to make decision");
                alertDialogBuilder.setPositiveButton("yes",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                Toast.makeText(context,"You clicked yes button",Toast.LENGTH_LONG).show();
                            }
                        });

        alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //finish();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public static String EditText_GetText(View v, int id){
        return ((EditText) v.findViewById(id)).getText().toString().trim();
    }

    public static void ErrorLog(String Module, Exception e)
    {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(ErrorLogPath, true));
            writer.newLine();
            writer.write(Module);
            writer.newLine();
            writer.write(e.toString());
            writer.close();

        } catch (IOException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
    }

    public static void ErrorLog(String Module, String e)
    {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(ErrorLogPath, true));
            writer.newLine();
            writer.write(Module);
            writer.newLine();
            writer.write(e.toString());
            writer.close();

        } catch (IOException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
    }

}
