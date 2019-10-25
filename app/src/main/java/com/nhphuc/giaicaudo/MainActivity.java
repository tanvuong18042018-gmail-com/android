package com.nhphuc.giaicaudo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gvTraiTim;
    AdapterLuotChoi adapterLuotChoi;
    ArrayList<HinhAnhLuotChoi> hinhAnhLuotChoiArrayList;
    Button btnDangKy;

    ListView lvLichSuChoi,lvBangXepHang;
    AdapterLichSuChoi adapterLichSuChoi;
    ArrayList<LichSuNguoiChoi> lichSuNguoiChoiArrayList;

    AdapterXepHang adapterXepHang;
    ArrayList<BangXepHang> bangXepHangArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
    }

    public void ShowPopupDangKy(){
        final Dialog dialogPopupDangKy = new Dialog(this);
        Button btnDong;
        dialogPopupDangKy.setContentView(R.layout.popup_dang_ky);
        btnDong = (Button) dialogPopupDangKy.findViewById(R.id.buttonDong);
        dialogPopupDangKy.show();
        btnDong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogPopupDangKy.dismiss();
            }
        });
    }

    public void AnhXa(){
        btnDangKy = (Button) findViewById(R.id.buttonDangKy);

        gvTraiTim = (GridView) findViewById(R.id.gridViewTraiTim);
        hinhAnhLuotChoiArrayList = new ArrayList<>();
        hinhAnhLuotChoiArrayList.add(new HinhAnhLuotChoi("Lượt 1",R.drawable.icotraitim));
        hinhAnhLuotChoiArrayList.add(new HinhAnhLuotChoi("Lượt 2",R.drawable.icotraitim));
        hinhAnhLuotChoiArrayList.add(new HinhAnhLuotChoi("Lượt 3",R.drawable.icotraitim));
        hinhAnhLuotChoiArrayList.add(new HinhAnhLuotChoi("Lượt 4",R.drawable.icotraitim));
        hinhAnhLuotChoiArrayList.add(new HinhAnhLuotChoi("Lượt 5",R.drawable.icotraitim));

        lvLichSuChoi = (ListView) findViewById(R.id.listViewLichSuChoi);
        lichSuNguoiChoiArrayList = new ArrayList<>();
        lichSuNguoiChoiArrayList.add(new LichSuNguoiChoi("25/10","9","1000"));
        lichSuNguoiChoiArrayList.add(new LichSuNguoiChoi("24/10","8","2000"));
        lichSuNguoiChoiArrayList.add(new LichSuNguoiChoi("23/10","7","3000"));
        lichSuNguoiChoiArrayList.add(new LichSuNguoiChoi("21/10","6","4000"));
        lichSuNguoiChoiArrayList.add(new LichSuNguoiChoi("22/10","5","5000"));

        lvBangXepHang = (ListView) findViewById(R.id.listViewBangXepHang);
        bangXepHangArrayList = new ArrayList<>();
        bangXepHangArrayList.add(new BangXepHang(R.mipmap.ic_launcher,"nhphuc","5000"));
        bangXepHangArrayList.add(new BangXepHang(R.mipmap.ic_launcher,"vnninh","4000"));
        bangXepHangArrayList.add(new BangXepHang(R.mipmap.ic_launcher,"nnminh","3000"));
        bangXepHangArrayList.add(new BangXepHang(R.mipmap.ic_launcher,"nmphuong","2000"));
        bangXepHangArrayList.add(new BangXepHang(R.mipmap.ic_launcher,"btvuong","1000"));
        bangXepHangArrayList.add(new BangXepHang(R.mipmap.ic_launcher,"ntam","10000"));
    }

    public void BangXepHang(){
        adapterXepHang = new AdapterXepHang(this,R.layout.dong_bang_xep_hang,bangXepHangArrayList);
        lvBangXepHang.setAdapter(adapterXepHang);
    }

    public void LichSuChoi(){
        adapterLichSuChoi = new AdapterLichSuChoi(this,R.layout.dong_lich_su_choi,lichSuNguoiChoiArrayList);
        lvLichSuChoi.setAdapter(adapterLichSuChoi);
    }

    public void LuotChoi(){
        adapterLuotChoi = new AdapterLuotChoi(this,R.layout.dong_luot_choi,hinhAnhLuotChoiArrayList);
        gvTraiTim.setAdapter(adapterLuotChoi);
    }
}
