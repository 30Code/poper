package cn.linhome.poper;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.fanwe.library.activity.SDBaseActivity;
import cn.linhome.poper.dialog.TestDialog;

public class DialogActivity extends SDBaseActivity
{
    private Button btn_dialog;

    @Override
    protected void init(Bundle savedInstanceState)
    {
        setContentView(R.layout.act_dialog);
        btn_dialog = findViewById(R.id.btn_dialog);
        btn_dialog.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                TestDialog dialog = new TestDialog(DialogActivity.this);
                dialog.show();
            }
        });
    }
}
