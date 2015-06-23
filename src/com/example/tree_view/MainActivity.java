package com.example.tree_view;

import java.util.ArrayList;
import java.util.List;

import com.example.bean.Bean;
import com.example.bean.FileBean;
import com.example.tree.bean.Node;
import com.example.tree.bean.TreeListViewAdapter;
import com.example.tree.bean.TreeListViewAdapter.OnTreeNodeClickListener;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;
 
public class MainActivity extends Activity {
	private List<Bean> mDatas = new ArrayList<Bean>();
	private List<FileBean> mDatas2 = new ArrayList<FileBean>();
	private ListView mTree;
	private TreeListViewAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initDatas();
		mTree = (ListView) findViewById(R.id.id_tree);
		try {
			mAdapter = new SimpleTreeAdapter<FileBean>(mTree, this, mDatas2, 0);
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
 

		mDatas2.add(new FileBean(1, 0, "言语理解与表达"));
		mDatas2.add(new FileBean(2, 1, "阅读理解"));
		mDatas2.add(new FileBean(3, 1, "逻辑填空"));
		mDatas2.add(new FileBean(4, 1, "语句表达"));
		mDatas2.add(new FileBean(5, 2, "中心理解题"));
		mDatas2.add(new FileBean(6, 2, "细节判断题"));

		mDatas2.add(new FileBean(7, 3, "实词填空"));
		mDatas2.add(new FileBean(8, 3, "虚词填空"));

		mDatas2.add(new FileBean(9, 5, "语句排序"));
		mDatas2.add(new FileBean(10, 5, "语句填空"));
		mDatas2.add(new FileBean(11, 7, "动词"));
		mDatas2.add(new FileBean(12, 7, "名词"));

	}

}
