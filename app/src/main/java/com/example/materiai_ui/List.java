package com.example.materiai_ui;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class List extends AppCompatActivity {
    Button btnAdd;
    TextView tvTenMon, tvChiTietMon, tvGia;
    ListView lvItem;
    ArrayList<Item> itemArrayList;
    ItemAdapter adapter;
    int viTri= -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        lvItem = (ListView) findViewById(R.id.listViewIItem);
        itemArrayList = new ArrayList<>();
        btnAdd = (Button) findViewById(R.id.buttonAdd);
        tvTenMon = (TextView) findViewById(R.id.textViewTenMon);
        tvChiTietMon = (TextView) findViewById(R.id.textViewChiTietMon);
        tvGia = (TextView) findViewById(R.id.textViewGiaMon);

        itemArrayList.add(new Item(R.drawable.mon1,"Món 1","Thông tin chi tiết của món ăn","8$", "+", "-"));
        itemArrayList.add(new Item(R.drawable.mon2,"Món 2","Thông tin chi tiết của món ăn","8$", "+", "-"));
        itemArrayList.add(new Item(R.drawable.mon3,"Món 3","Thông tin chi tiết của món ăn","8$", "+", "-"));
        itemArrayList.add(new Item(R.drawable.mon4,"Món 4","Thông tin chi tiết của món ăn","8$", "+", "-"));
        itemArrayList.add(new Item(R.drawable.mon5,"Món 5","Thông tin chi tiết của món ăn","8$", "+", "-"));
        itemArrayList.add(new Item(R.drawable.mon6,"Món 6","Thông tin chi tiết của món ăn","8$", "+", "-"));

        adapter = new ItemAdapter(this, itemArrayList);
        lvItem.setAdapter(adapter);

        lvItem.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                viTri = i;
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(List.this);
                alertDialog.setTitle("Xóa Item?");
                alertDialog.setMessage("Bạn chắc chắn muốn xóa?");
                alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(List.this, "Xóa thành công", Toast.LENGTH_SHORT).show();
                        itemArrayList.remove(viTri);
                        adapter.notifyDataSetChanged();
                    }
                });
                alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                alertDialog.show();
                return true;
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tvTenMon.getText().toString().equals("") || tvChiTietMon.getText().toString().equals("") || tvGia.getText().toString().equals(""))
                {
                    Toast.makeText(List.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }else {
                    itemArrayList.add(new Item(R.drawable.img,tvTenMon.getText().toString(),tvChiTietMon.getText().toString(),tvGia.getText().toString(), "+", "-"));
                    adapter.notifyDataSetChanged();
                    Toast.makeText(List.this, "Thêm món thành công", Toast.LENGTH_SHORT).show();
                    tvTenMon.setText("");
                    tvChiTietMon.setText("");
                    tvGia.setText("");
                }
            }
        });
    }
}