package com.xcommon.commonadapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.xcommon.commonadapter.adapter.DataViewHolder;
import com.xcommon.commonadapter.adapter.XBaseAdapter;

//封装adapter使用例子，无需理会传入的list类型,直接省略其他无关紧要的代码，对象只需在获取的时候进行强转。
public class AdapterUseDemo extends XBaseAdapter {

	public AdapterUseDemo(Context c, List lst) {
		super(c, lst);
	}

	/** 把需要操作的控件id都放此处，没放回空指针异常 */
	@Override
	public int[] getFindViewByIDs() {
		return new int[] { R.id.test_imageicon, R.id.test_name };
	}

	/** Layout布局id */
	@Override
	public View getLayout(int position, DataViewHolder vh) {
		return getResourceView(R.layout.test_baseadapter_view);
	}

	/** 与getView方法相同 */
	@Override
	public void renderData(int position, DataViewHolder vh) {
		/** 直接在获取的时候进行强转类型 */
		TestEntity c = (TestEntity) getItem(position);
		vh.getView(TextView.class, R.id.test_name).setText(c.netpath);
		ImageView img = vh.getView(ImageView.class, R.id.test_imageicon);
		img.setBackgroundResource(c.resId);
		// bitmapUtils.display(img, c.netpath);
	}
}
