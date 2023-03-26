package com.example.arwa_shamaly_220212536;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.arwa_shamaly_220212536.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnAction, FragmentDialog.Delete {
    ActivityMainBinding binding;
    ArrayList<Product> arrayList;
    ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        arrayList = new ArrayList<>();
        productAdapter = new ProductAdapter(arrayList, this);

        RoomDatabase roomDatabase = RoomDatabase.getDatabase(getBaseContext());

        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean rbNoChecked = binding.rbNo.isChecked();
                boolean rbYesChecked = binding.rbYes.isChecked();
                String offer;
                if (rbNoChecked) {
                    offer = "No";
                } else {
                    offer = "Yes";
                }
                arrayList.add(new Product(binding.etProuductName.getText().toString(),
                        Integer.parseInt(binding.etQuantityAvailable.getText().toString()),
                        offer));

                productAdapter.getArrayList();

                RoomDatabase.databaseWriteExecutor.execute(new Runnable() {
                    @Override
                    public void run() {
                        roomDatabase.productDAO().insertProduct(
                                new Product(binding.etProuductName.getText().toString(),
                                        Integer.parseInt(binding.etQuantityAvailable.getText().toString()),
                                        offer));
                    }
                });

            }
        });

        roomDatabase.productDAO().getProductASC().observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                arrayList = (ArrayList) products;

                 productAdapter = new ProductAdapter(arrayList,
                        MainActivity.this);
                binding.rc.setAdapter(productAdapter);
            }
        });

//        binding.rc.setAdapter(productAdapter);

        binding.rc.setLayoutManager(new LinearLayoutManager(getBaseContext()
                , RecyclerView.VERTICAL, false));


    }

    @Override
    public void onDelete(int position) {
        FragmentDialog fragmentDialog = FragmentDialog.newInstance1("Delete Product?", position);
        fragmentDialog.show(getSupportFragmentManager(), "");
    }

    @Override
    public void delete(int pos) {
        Log.d("deleteTest", "delete: "+pos);
        arrayList.remove(pos);
        productAdapter.notifyItemRemoved(pos);
        productAdapter.notifyItemRangeChanged(pos, arrayList.size());

    }
}