package py.com.codium.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.NetworkResponse;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvList;

    HttpHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvList = findViewById(R.id.rv_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvList.setLayoutManager(layoutManager);

        handler = new HttpHandler(this);
        handler.getPersons(new HttpHandler.HttpCallback<Person[]>() {
            @Override
            public void onSuccess(Person[] response) {
                PersonAdapter adapter = new PersonAdapter(response);
                rvList.setAdapter(adapter);
            }

            @Override
            public Boolean onError(NetworkResponse error) {
                return false;
            }
        });


    }
}
