package id.co.asyst.yeni.chocolateorderyeni;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import id.co.asyst.yeni.chocolateorderyeni.adapter.MenuAdapter;
import id.co.asyst.yeni.chocolateorderyeni.model.Menu;
import id.co.asyst.yeni.chocolateorderyeni.utility.Constant;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView namaaa, namaTV, hargaTV, bayarTV, ppnTV;
    ListView orderLV;
    MenuAdapter menuAdapter;
    int requestOrder = 100;
    int hargaTotal, total, ppn;
    String namaStr, menu, topping;

    ArrayList<Menu> listMenu = new ArrayList<>();

    Button addBtn, doneBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        namaaa = findViewById(R.id.namaaa);
        namaTV = findViewById(R.id.nama_tv);
        hargaTV = findViewById(R.id.harga_tv);
        bayarTV = findViewById(R.id.bayar_tv);
        ppnTV = findViewById(R.id.ppn_tv);

        orderLV = findViewById(R.id.order_listview);

        addBtn = findViewById(R.id.add_btn);
        doneBtn = findViewById(R.id.done_btn);
        addBtn.setOnClickListener(this);
        doneBtn.setOnClickListener(this);
        menuAdapter = new MenuAdapter(this, listMenu);
        orderLV.setAdapter(menuAdapter);


    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.add_btn:
                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                //iki gawe start act for result
                startActivityForResult(intent, requestOrder);
                break;

            case R.id.done_btn:
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
                alertDialog.setTitle("Confirmation")
                        .setCancelable(false)
                        .setMessage("Are You Sure To Finish?")
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                Intent intent = new Intent(MainActivity.this, FinishActivity.class);

                                startActivity(intent);

                            }
                        })
                        .setNegativeButton("NO", null).show();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == requestOrder) {
            if (resultCode == Activity.RESULT_OK) {
                /*Menu menu = data.getExtras().getParcelable("menu");
                listMenu.add(menu);*/
                if (data.getExtras() != null) {
                    Bundle bundle = data.getExtras();
                    namaStr = bundle.getString(Constant.KEY_NAME);
                    menu = bundle.getString(Constant.KEY_MENU);
                    topping = bundle.getString(Constant.KEY_TOPPING);
                    hargaTotal = bundle.getInt(Constant.KEY_HARGA);
                    Menu menu2 = new Menu(namaStr, menu, topping, hargaTotal);

                    total += hargaTotal;
                    ppn = total * 10 / 100;
                    listMenu.add(menu2);
                    hargaTV.setText("Rp " + total);
                    ppnTV.setText("Rp " + ppn);
                    bayarTV.setText("Rp " + (total + ppn));

                    menuAdapter.notifyDataSetChanged();
                }

                /* menuAdapter.notifyDataSetChanged();*/
            }
        }
    }

}
