package you.xiaochen.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import you.xiaochen.R;

/**
 * Created by you on 2017/9/11.
 */

public class ContactHolder extends RecyclerView.ViewHolder {

    public final ImageView iv_header;

    public final TextView tv_name;

    public ContactHolder(View itemView) {
        super(itemView);
        iv_header = (ImageView) itemView.findViewById(R.id.iv_header);
        tv_name = (TextView) itemView.findViewById(R.id.tv_name);
    }
}
