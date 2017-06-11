package com.bawei.zhoukao1_b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.google.gson.Gson;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by Administrator on 2017/6/11/0011.
 */

public class Second extends Activity implements ViewAdapter.OnItemClickListener {


    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private List<Students.StudentsBean.StudentBean> student;
    private ViewAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

//        recyclerView.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);


        try {
            String string = new IAsyncTask().execute("").get();
            System.out.println(string);

            Gson gson = new Gson();
            Students students = gson.fromJson(string, Students.class);

            student = students.getStudents().getStudent();

            //设置适配器
            adapter = new ViewAdapter(this, student);
            recyclerView.setAdapter(adapter);

        } catch (Exception e) {
            e.printStackTrace();
        }

        //表格管理器
        GridLayoutManager gridLayoutManager = new GridLayoutManager(Second.this,2);

        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);

        //添加分割线
        recyclerView.addItemDecoration(new HorizontalDividerItemDecoration.Builder(this).build());

        //RecyclerView条目监听
        adapter.setOnItemClickListener(this);



    }


    @Override
    public void onItemClickListener(int position, View view) {

        Intent intent = new Intent(Second.this, Three.class);
        intent.putExtra("name", student.get(position).getName());
        intent.putExtra("text", student.get(position).getContent());
        intent.putExtra("img", student.get(position).getImg());
        startActivity(intent);

    }

    @Override
    public void onItemLongClickListener(int position, View view) {

    }
}
