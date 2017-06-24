package android.lavtaxi.views;

import android.content.Context;
import android.lavtaxi.R;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by rob on 6/25/17.
 */

public class OrderButton extends RelativeLayout {
    private View rootView;
    public OrderButton(Context context) {
        super(context);
        initialize(context);
    }

    public OrderButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context);
    }

    public OrderButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize(context);
    }

    private void initialize(Context context) {
        rootView = LayoutInflater.from(context).inflate(R.layout.order_button, this, true);
        this.setBackgroundResource(R.drawable.green_background_with_corner_radius);
    }
}
