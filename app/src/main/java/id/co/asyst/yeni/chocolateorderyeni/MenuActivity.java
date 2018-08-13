package id.co.asyst.yeni.chocolateorderyeni;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

import id.co.asyst.yeni.chocolateorderyeni.utility.Constant;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener, CompoundButton.OnCheckedChangeListener {

    EditText nameET;
    TextView nameTV;
    String nameStr;
    RadioGroup radioCoklat;
    String selectCoklat;
    CheckBox checkOreo, checkBeng, checkMarshmellow, checkPeanut;
    String topping = "";
    Button submitBtn;
    int hargaMenu = 0, hargaTopping = 0, hargaTotal = 0;
    ArrayList<String> listTopping = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        nameET = findViewById(R.id.name_et);
        nameTV = findViewById(R.id.nama_tv);

        radioCoklat = findViewById(R.id.radio_coklat);
        radioCoklat.setOnCheckedChangeListener(this);

        checkOreo = findViewById(R.id.check_oreo);
        checkBeng = findViewById(R.id.check_beng);
        checkMarshmellow = findViewById(R.id.check_marshmellow);
        checkPeanut = findViewById(R.id.check_peanut);

        checkOreo.setOnCheckedChangeListener(this);
        checkBeng.setOnCheckedChangeListener(this);
        checkMarshmellow.setOnCheckedChangeListener(this);
        checkPeanut.setOnCheckedChangeListener(this);

        submitBtn = findViewById(R.id.submit_btn);
        submitBtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        nameStr = nameET.getText().toString();

        if (TextUtils.isEmpty(nameStr)) {
            nameET.setError("Nama Harus Diisi");

        } else {
            hargaTotal = hargaMenu + hargaTopping;
            topping = " ";
            for (int i = 0; i < listTopping.size(); i++) {
                topping = topping + " " + listTopping.get(i);
            }

            AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
            alertDialog.setTitle("Confirmation")
                    .setCancelable(false)
                    .setMessage("Are You Sure to Order?")
                    .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
//
//                            Intent returnIntent = new Intent(MenuActivity.this, MainActivity.class);
//                            Menu menu = new Menu(nameStr, selectCoklat, topping, hargaTotal);

                            Intent returnIntent = getIntent();
                            returnIntent.putExtra(Constant.KEY_NAME, nameStr);
                            returnIntent.putExtra(Constant.KEY_MENU, selectCoklat);
                            returnIntent.putExtra(Constant.KEY_TOPPING, topping);
                            returnIntent.putExtra(Constant.KEY_HARGA, hargaTotal);

                            setResult(Activity.RESULT_OK, returnIntent);

                            finish();

                        }
                    })
                    .setNegativeButton("NO", null).show();
        }


    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.radio_ori:
                selectCoklat = " Menu : Original Chocolate";
                hargaMenu = 10000;
                break;
            case R.id.radio_milk:
                selectCoklat = " Menu : Milk Chocolate";
                hargaMenu = 11000;
                break;
            case R.id.radio_dark:
                selectCoklat = " Menu : Dark Chocolate";
                hargaMenu = 12000;
                break;
            case R.id.radio_hazelnut:
                selectCoklat = " Menu : Hazelnut Chocolate";
                hargaMenu = 13000;
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        int id = buttonView.getId();
        switch (id) {
            case R.id.check_oreo:
                if (isChecked) {
                    listTopping.add("Topping : Oreo");
                    hargaTopping += 5000;
                } else {
                    listTopping.remove("Oreo");
                }

                break;
            case R.id.check_beng:
                if (isChecked) {
                    listTopping.add("Topping : Beng-Beng");
                    hargaTopping += 5000;
                } else {
                    listTopping.remove("Beng-Beng");
                }
                break;
            case R.id.check_marshmellow:
                if (isChecked) {
                    listTopping.add("Topping : Marshmellow");
                    hargaTopping += 5000;
                } else {
                    listTopping.remove("Marshmellow");
                }
                break;
            case R.id.check_peanut:
                if (isChecked) {
                    listTopping.add("Topping : Peanut");
                    hargaTopping += 5000;
                } else {
                    listTopping.remove("Peanut");
                }
                break;
        }
    }
}
