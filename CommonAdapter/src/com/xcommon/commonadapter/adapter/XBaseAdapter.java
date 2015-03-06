package com.xcommon.commonadapter.adapter;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public abstract class XBaseAdapter extends BaseAdapter {
	protected LayoutInflater inflater = null;
	protected Context mContext;
	protected Activity mActivity;
	private List<Object> lst;

	public XBaseAdapter(Context c, List lst) {
		this.mContext = c;
		mActivity = (Activity) mContext;
		this.lst = lst;
		this.inflater = LayoutInflater.from(c);
	}

	@Override
	public int getCount() {
		return lst.size();
	}

	public void insert(Object data) {
		lst.add(0, data);
		this.notifyDataSetChanged();
	}

	public void append(Object data) {
		lst.add(data);
		this.notifyDataSetChanged();
	}

	public void replace(Object data) {
		int idx = this.lst.indexOf(data);
		this.replace(idx, data);
	}

	public void replace(int index, Object data) {
		if (index < 0)
			return;
		if (index > lst.size() - 1)
			return;
		lst.set(index, data);
		this.notifyDataSetChanged();
	}

	public List<Object> getItems() {
		return lst;
	}

	@Override
	public Object getItem(int position) {
		return lst.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	public void removeItem(int position) {
		if (lst.size() <= 0)
			return;
		if (position < 0)
			return;
		if (position > lst.size() - 1)
			return;

		lst.remove(position);
		this.notifyDataSetChanged();
	}

	public void clear() {
		lst.clear();
		this.notifyDataSetChanged();
	}

	public abstract int[] getFindViewByIDs();

	public abstract View getLayout(int position, DataViewHolder vh);

	public final View getResourceView(int id) {
		return inflater.inflate(id, null);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		DataViewHolder vh;
		if (convertView == null) {
			vh = new DataViewHolder();
			convertView = this.getLayout(position, vh);
			if (convertView == null)
				return null;

			int[] idAry = this.getFindViewByIDs();
			if (idAry == null)
				idAry = new int[] {};
			for (int id : idAry) {
				vh.setView(id, convertView.findViewById(id));
			}
			convertView.setTag(vh);
		} else
			vh = (DataViewHolder) convertView.getTag();

		this.renderData(position, vh);
		return convertView;
	}

	public abstract void renderData(int position, DataViewHolder vh);

	public void setlist(List list) {
		this.lst = list;
	}

	/**
	 * 设置值
	 * 
	 * @param id
	 *            控件id标识
	 * @param content
	 *            设置的内容
	 * @param holder
	 *            缓存控件类
	 */
	protected void setValue(int id, String content, DataViewHolder holder) {
		holder.getView(TextView.class, id).setText(content);
	}

}
