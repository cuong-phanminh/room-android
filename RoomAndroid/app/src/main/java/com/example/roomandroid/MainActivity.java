package com.example.roomandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    List listUser;
    TextView tvUser;
    UserDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = Room.databaseBuilder(getApplicationContext(),
                UserDatabase.class, "database-name").build();

        new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... voids) {
                User user = new User("tu");
                db.userDao().insert(user);

               final List<User> users= db.userDao().getAll();
                Log.i("database1","size"+users.size());
                displayUser(users);


                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        displayUser(users);
                    }
                });
                return null;
            }

        }.execute();

//        User user = new User("Nam");
//        db.userDao().insert(user);
    }
//    void displayUser(List<User> users){
//        for(int i=0; i<users.size();i++) {
//            tvUser = findViewById(R.id.tvUser);
//            User user = users.get(i);
//            tvUser.setText(user.name);
//        }
//    }
void displayUser(List<User> users){
        String data="";
        for(int i=0; i<users.size();i++) {

            User user = users.get(i);
            data =data + user.name+"\n";

        }
            tvUser = findViewById(R.id.tvUser);
            tvUser.setText(data);
    }
}
