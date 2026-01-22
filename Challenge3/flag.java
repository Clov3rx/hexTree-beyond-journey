        Uri uri = Uri.parse("https://app.hextree.io/map/android");
        Intent intent = new Intent("io.hextree.action.GIVE_FLAG");
        intent.setClassName("io.hextree.attacksurface","io.hextree.attacksurface.activities.Flag3Activity");
        intent.setData(uri);
        startActivity(intent);