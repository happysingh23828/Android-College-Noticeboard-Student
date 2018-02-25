package dynamicdrillers.collegenoticeboard;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class FacultyDashboard extends AppCompatActivity {

    Button button;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView navigationicon;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_dashboard);


        button = findViewById(R.id.a);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FacultyDashboard.this,FacultyRegistrationActivity.class));
            }
        });

    //Setting Toolbar
    toolbar = (Toolbar)findViewById(R.id.facultyMainToolbar);
    setSupportActionBar(toolbar);



    drawerLayout = (DrawerLayout)findViewById(R.id.drawerfacultyroot);
    navigationicon = (ImageView)findViewById(R.id.navigationicon);

    // When Navigation Icon Clicks
        navigationicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.START);
            }
        });

     //checking Which Navigationitem Selected
        navigationView = (NavigationView)findViewById(R.id.navigation_drawer);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.editProfile:
                        Toast.makeText(getBaseContext(),"Editprofile Clicked",Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.ProfileLogout:
                        SharedpreferenceHelper sharedPreferenceHelper = SharedpreferenceHelper.getInstance(getBaseContext());

                        sharedPreferenceHelper.logout();
                        Toast.makeText(getBaseContext(),"Logout Successfully",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                        startActivity(intent);
                        finish();
                        break;

                    case R.id.feedback:
                        Toast.makeText(getBaseContext(),"Feedback Clicked",Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.aboutus:
                        Toast.makeText(getBaseContext(),"Aboutus Clicked",Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.sharethisapp:
                        Toast.makeText(getBaseContext(),"Share Clicked",Toast.LENGTH_SHORT).show();
                        break;





                }

                return true;
            }
        });

        String noticenames1[] = {"College","Scholarship","Events"};
        String noticenames2[] = {"Accounts","Tnp","Dept"};
        int noticeicons1[] = {R.drawable.collegenotice,R.drawable.schlorship,R.drawable.events};
        int noticeicons2[] = {R.drawable.viewnotice,R.drawable.tnp,R.drawable.dept};
        recyclerView = (RecyclerView)findViewById(R.id.notice_recylerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this  ));
        recyclerView.setAdapter(new DashboardNoticeAdaptor(noticenames1,noticenames2,noticeicons1,noticeicons2));




    }
}
