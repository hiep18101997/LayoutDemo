package com.example.demolayout5food;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
/*
*Người tạo dhhiep vào ngày 3/11/2019
*/
public class MainActivity extends AppCompatActivity {
    private AppBarLayout mAppBarLayout;
    private TextView mTextTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_test);
        mAppBarLayout=findViewById(R.id.app_bar_layout);
        mTextTitle=findViewById(R.id.tv_title);
        initAction();
    }

     /*
     *Người tạo dhhiep vào ngày 3/11/2019
     *Mục đích của hàm: Bắt sự kiện collapse Appbar
     *Tham số truyền vào: Không
     */
    private void initAction() {
        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = true;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    mTextTitle.setText(getString(R.string.title));
                    isShow = true;
                } else if (isShow) {
                    mTextTitle.setText(getString(R.string.empty));
                    isShow = false;
                }
            }
        });
    }
}
