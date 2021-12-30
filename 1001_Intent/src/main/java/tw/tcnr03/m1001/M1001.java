package tw.tcnr03.m1001;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.Contacts;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;


public class M1001 extends AppCompatActivity implements View.OnClickListener {

    private Button b01;
    private Button b02;
    private Button b03;
    private Uri uri;
    private Intent it;
    private Button b04;
    private Button b05;
    private Button b06;
    private Button b07;
    private Button b08;
    private Button b09;
    public static final int CAMERA_REQUEST_CODE = 102;
    private Button b10;
    private Button b11;
//    private Button b12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        enableStrictMode(this);
        setContentView(R.layout.m1001);
        setupViewComponent();
    }

    //**********************************************************
    private void enableStrictMode(Context context) {
        //-------------抓取遠端資料庫設定執行續------------------------------
        StrictMode.setThreadPolicy(new
                StrictMode.ThreadPolicy.Builder().
                detectDiskReads().
                detectDiskWrites().
                detectNetwork().
                penaltyLog().
                build());
        StrictMode.setVmPolicy(
                new
                        StrictMode.
                                VmPolicy.
                                Builder().
                        detectLeakedSqlLiteObjects().
                        penaltyLog().
                        penaltyDeath().
                        build());
    }

    //**********************************************************

    private void setupViewComponent() {
        b01=(Button)findViewById(R.id.m1001_b001);
        b02=(Button)findViewById(R.id.m1001_b002);
        b03=(Button)findViewById(R.id.m1001_b003);
        b04=(Button)findViewById(R.id.m1001_b004);
        b05=(Button)findViewById(R.id.m1001_b005);
        b06=(Button)findViewById(R.id.m1001_b006);
        b07=(Button)findViewById(R.id.m1001_b007);
        b08=(Button)findViewById(R.id.m1001_b008);
        b09=(Button)findViewById(R.id.m1001_b009);
        b10=(Button)findViewById(R.id.m1001_b010);
        b11=(Button)findViewById(R.id.m1001_b011);
//        b12=(Button)findViewById(R.id.m1001_b012);
        b01.setOnClickListener(this);
        b02.setOnClickListener(this);
        b03.setOnClickListener(this);
        b04.setOnClickListener(this);
        b05.setOnClickListener(this);
        b06.setOnClickListener(this);
        b07.setOnClickListener(this);
        b08.setOnClickListener(this);
        b09.setOnClickListener(this);
        b10.setOnClickListener(this);
        b11.setOnClickListener(this);
//        b12.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.m1001_b001:
                uri = Uri.parse("http://google.com");
                it = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(it);
                break;
            case R.id.m1001_b002:
                uri = Uri.parse("geo:24.24187340548068, 120.53088786891198");
                it = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(it);
                break;
            case R.id.m1001_b003:
                double startLat = 24.172127;
                double startLng = 120.610313;
                double endLat = 24.22002917070026;
                double endLng = 120.58038460962133;
                uri = Uri.parse("http://maps.google.com/maps?f=d&saddr="+startLat+","+startLng+"&daddr="+endLat+","+endLng+"&hl=tw");
                it = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(it);
//where startLat, startLng, endLat, endLng are a long with 6 decimals like: 50.123456
                Uri uri = Uri.parse("http://maps.google.com/maps?f=d&saddr=起點位置&daddr=終點位置&hl=tw");
                startActivity(it);
                break;
            case R.id.m1001_b004:
                Intent it = new Intent(Intent.ACTION_VIEW, Contacts.People.CONTENT_URI);
                startActivity(it);
                break;
            case R.id.m1001_b005:
                it = new Intent(Intent.ACTION_SEND);
                it.putExtra(Intent.EXTRA_SUBJECT, "The email subject text");
                it.putExtra(Intent.EXTRA_STREAM, Uri.parse("file:///storage/emulated/0/Download/g101_button.9.png"));
                it.setType("image/png");
                startActivity(Intent.createChooser(it, "Choose Email Client"));
                break;
            case R.id.m1001_b006:
                it = new Intent(Intent.ACTION_VIEW);
                uri = Uri.parse("file:///storage/emulated/0/Download/s01.mp3");
                it.setDataAndType(uri, "audio/mp3");
                startActivity(it);
                break;
            case R.id.m1001_b007:
                uri = Uri.withAppendedPath(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, "1");
                it = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(it);

                //叫出撥號程式
                uri = Uri.parse("tel:0912389513");
                it = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(it);

                //直接打電話出去
//                uri = Uri.parse("tel:0800000123");
//                it = new Intent(Intent.ACTION_CALL, uri);
//                startActivity(it);
                //用這個，要在 AndroidManifest.xml 中，加上
//<uses-permission id="android.permission.CALL_PHONE" />
                break;
            case R.id.m1001_b008:
                it = new Intent(Intent.ACTION_GET_CONTENT);
                it.addCategory(Intent.CATEGORY_OPENABLE);
                it.setType("image/*");
                startActivityForResult(it, 0);
//回傳的圖片可透過it.getData() 取得圖片之Uri
                break;
            case R.id.m1001_b009:
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY,"阿伯出事了");
                startActivity(intent);
                break;

            case R.id.m1001_b010:
                it = new Intent(Intent.ACTION_SEND);
                it.putExtra(Intent.EXTRA_SUBJECT, "The email subject text");
                it.putExtra(Intent.EXTRA_STREAM, Uri.parse("file:///storage/emulated/0/Download/s01.mp3"));
                it.setType("audio/mp3");
                startActivity(Intent.createChooser(it, "Choose Email Client"));
                break;

            case R.id.m1001_b011:
                it = new Intent(Intent.ACTION_VIEW);
                uri = Uri.parse("http://play.google.com/store/search?q=104");
                it.setData(uri);
                startActivity(it);
                break;

//            case R.id.m1001_b012:
//                uri = Uri.fromParts("package", "tw.tcnr03.m0501", null);
//                it = new Intent(Intent.ACTION_DELETE, uri);
//                startActivity(it);
//                break;
        }
    }
}