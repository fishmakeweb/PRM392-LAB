package com.example.lab45

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Lab5MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var userAdapter: UserAdapter
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab5_main)
        
        initViews()
        setupRecyclerView()
        loadSampleData()
    }
    
    private fun initViews() {
        recyclerView = findViewById(R.id.recyclerViewUsers)
    }
    
    private fun setupRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
    
    private fun loadSampleData() {
        val sampleUsers = listOf(
            User("NguyenTT", "Tran Thanh Nguyen", "nguyentt@ftp.edu.vn"),
            User("Antv", "Tran Van An", "antv@gmail.com"),
            User("BangTT", "Tran Thanh Bang", "bangtt@gmail.com"),
            User("KhangTT", "Tran Thanh Khang", "khangtt@gmail.com"),
            User("BaoNT", "Nguyen Thanh Bao", "baont@gmail.com"),
            User("PhucND", "Nguyen Duc Phuc", "phucnd@gmail.com"),
            User("ThanhLD", "Le Duc Thanh", "thanhld@gmail.com"),
            User("HungNV", "Nguyen Van Hung", "hungnv@gmail.com"),
            User("DungPT", "Pham Thanh Dung", "dungpt@gmail.com"),
            User("LinhNT", "Nguyen Thi Linh", "linhnt@gmail.com")
        )
        
        userAdapter = UserAdapter(sampleUsers)
        recyclerView.adapter = userAdapter
    }
}