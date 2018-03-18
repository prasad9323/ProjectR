package dozer.com.projectr.Admin;
/**
 * Created by Prasad on 18-Mar-18.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import dozer.com.projectr.R;

public class FragmentWithOneImage extends Fragment {
    private String title;
    private int image;

    public static FragmentWithOneImage newInstance(String title, int resImage) {
        FragmentWithOneImage fragment = new FragmentWithOneImage();
        Bundle args = new Bundle();
        args.putInt("image", resImage);
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        image = getArguments().getInt("image", 0);
        title = getArguments().getString("title");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one_img, container, false);
        TextView tvLabel = view.findViewById(R.id.txtMain);
        tvLabel.setText(title);
        ImageView imageView = view.findViewById(R.id.imgMain);
        imageView.setImageResource(image);
        return view;
    }
}