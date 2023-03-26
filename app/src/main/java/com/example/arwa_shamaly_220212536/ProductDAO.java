package com.example.arwa_shamaly_220212536;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ProductDAO {
@Insert
    void insertProduct(Product product);
@Query("select * from Product order by productName asc ")
    LiveData<List<Product>> getProductASC();
}
