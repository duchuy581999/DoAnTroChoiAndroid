package com.example.bestchoose;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.content.pm.PackageInfo;
        import android.content.pm.PackageManager;
        import android.content.pm.Signature;
        import android.graphics.drawable.AnimationDrawable;
        import android.os.Bundle;
        import android.util.Base64;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;


        import com.facebook.FacebookSdk;

        import java.security.MessageDigest;
        import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {
    private Button btnDangnhap;
    private AnimationDrawable anim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_dang_nhap);
        init();
        anim = (AnimationDrawable) btnDangnhap.getBackground();
        anim.setEnterFadeDuration(2300);
        anim.setExitFadeDuration(2300);

        try {
            PackageInfo info = null;
            try {
                info = getPackageManager().getPackageInfo(
                        "com.example.bestchoose",
                        PackageManager.GET_SIGNATURES);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        }  catch (NoSuchAlgorithmException e) {

        }
    }

    private void init() {
        this.btnDangnhap =findViewById(R.id.dangnhap_button);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(anim != null && !anim.isRunning()){
            anim.start();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(anim != null && anim.isRunning()){
            anim.stop();
        }
    }

    public void xuly_dangnhap(View view) {
        Intent intent = new Intent(this,ManHinhChinh.class);
        startActivity(intent);
    }

    public void xuly_quenmk(View view) {
        Intent intent = new Intent(this,QuenMatKhau.class);
        startActivity(intent);
    }

    public void xuly_dangky(View view) {
        Intent intent = new Intent(this,DangKy.class);
        startActivity(intent);
    }
}
