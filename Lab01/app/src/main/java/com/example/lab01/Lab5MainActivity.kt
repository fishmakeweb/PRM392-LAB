package com.example.lab01

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
            User(1, "Nguyễn Văn An", "an.nguyen@email.com", "0901234567"),
            User(2, "Trần Thị Bình", "binh.tran@email.com", "0912345678"),
            User(3, "Lê Văn Cường", "cuong.le@email.com", "0923456789"),
            User(4, "Phạm Thị Dung", "dung.pham@email.com", "0934567890"),
            User(5, "Hoàng Văn Em", "em.hoang@email.com", "0945678901"),
            User(6, "Vũ Thị Phương", "phuong.vu@email.com", "0956789012"),
            User(7, "Đặng Văn Giang", "giang.dang@email.com", "0967890123"),
            User(8, "Ngô Thị Hoa", "hoa.ngo@email.com", "0978901234"),
            User(9, "Bùi Văn Inh", "inh.bui@email.com", "0989012345"),
            User(10, "Lý Thị Kiều", "kieu.ly@email.com", "0990123456"),
            User(11, "Đinh Văn Long", "long.dinh@email.com", "0901234568"),
            User(12, "Trịnh Thị Mai", "mai.trinh@email.com", "0912345679"),
            User(13, "Dương Văn Nam", "nam.duong@email.com", "0923456780"),
            User(14, "Lâm Thị Oanh", "oanh.lam@email.com", "0934567891"),
            User(15, "Võ Văn Phú", "phu.vo@email.com", "0945678902")
        )
        
        userAdapter = UserAdapter(sampleUsers)
        recyclerView.adapter = userAdapter
    }
}