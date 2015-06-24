package com.example.tree_view;

import java.util.ArrayList;
import java.util.List;

import com.example.bean.FileBean;
import com.example.tree.bean.Node;
import com.example.tree.bean.TreeListViewAdapter;
import com.example.tree.bean.TreeListViewAdapter.OnTreeNodeClickListener;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;
 
public class MainActivity extends Activity {
	private List<FileBean> mDatas = new ArrayList<FileBean>();
	private ListView mTree;
	private TreeListViewAdapter mAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initDatas();
		mTree = (ListView) findViewById(R.id.id_tree);
		
		try {
			mAdapter = new SimpleTreeAdapter<FileBean>(mTree, this, mDatas, 0);
			mAdapter.setOnTreeNodeClickListener(new OnTreeNodeClickListener() {
				@Override
				public void onClick(Node node, int position) {
					if (node.isLeaf()) {
						Toast.makeText(getApplicationContext(), node.getName(),
								Toast.LENGTH_SHORT).show();
					}
				}

			});

		} catch (Exception e) {
			e.printStackTrace();
		}
		mTree.setAdapter(mAdapter);
		
	}

	private void initDatas() {
 

		mDatas.add(new FileBean(1, 0, "言语理解与表达"));
		mDatas.add(new FileBean(2, 0, "数量关系"));
		mDatas.add(new FileBean(3, 1, "逻辑填空"));
		mDatas.add(new FileBean(4, 1, "语句表达"));
		mDatas.add(new FileBean(5, 2, "排列组合"));
		mDatas.add(new FileBean(6, 2, "概率计算"));

		mDatas.add(new FileBean(7, 3, "实词填空"));
		
		mDatas.add(new FileBean(8, 3, "虚词填空"));

		mDatas.add(new FileBean(9, 4, "语句排序"));
		mDatas.add(new FileBean(10, 4, "语句填空"));
		mDatas.add(new FileBean(11, 7, "实词-动词"));
		mDatas.add(new FileBean(12, 7, "实词-名词"));

	}

}
