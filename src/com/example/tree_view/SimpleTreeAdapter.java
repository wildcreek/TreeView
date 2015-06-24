package com.example.tree_view;

import java.util.List;

import com.example.tree.bean.Node;
import com.example.tree.bean.TreeListViewAdapter;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SimpleTreeAdapter<T> extends TreeListViewAdapter<T> {
	Context context;
	public SimpleTreeAdapter(ListView mTree, Context context, List<T> datas,
			int defaultExpandLevel) throws IllegalArgumentException,
			IllegalAccessException {
		super(mTree, context, datas, defaultExpandLevel);
		this.context = context;
	}

	@Override
	public View getConvertView(final Node node, int position, View convertView,
			ViewGroup parent) {

		ViewHolder viewHolder = null;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.list_item, parent, false);
			viewHolder = new ViewHolder();
			viewHolder.icon = (ImageView) convertView
					.findViewById(R.id.id_treenode_icon);
			viewHolder.label = (TextView) convertView
					.findViewById(R.id.id_treenode_label);
			viewHolder.line_Top = (View) convertView
					.findViewById(R.id.line_top);
			viewHolder.line_Bottom = (View) convertView
					.findViewById(R.id.line_bottom);
			viewHolder.ib_practice = (ImageButton) convertView
					.findViewById(R.id.ib_practice);
			convertView.setTag(viewHolder);

		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}

		viewHolder.icon.setVisibility(View.VISIBLE);
		viewHolder.line_Top.setVisibility(node.getLineTopVisiblity());
		viewHolder.line_Bottom.setVisibility(node.getLineBottomVisiblity());
		viewHolder.icon.setImageResource(node.getIcon());
		viewHolder.label.setText(node.getName());
		
		viewHolder.ib_practice.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Toast.makeText(context, "该节点的id为"+node.getId(), Toast.LENGTH_SHORT).show();
			}
		});
		return convertView;
	}

	private final class ViewHolder {
		ImageView icon;
		TextView label;
		View line_Top;
		View line_Bottom;
		ImageButton ib_practice;
	}

}
