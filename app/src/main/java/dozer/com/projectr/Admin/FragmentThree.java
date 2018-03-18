package dozer.com.projectr.Admin;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import dozer.com.projectr.R;

/**
 * Created by Prasad on 18-Mar-18.
 */
public class FragmentThree extends Fragment {
    private String title;
    private int image;

    public static FragmentThree newInstance(String title, int resImage) {
        FragmentThree fragment = new FragmentThree();
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
        View view = inflater.inflate(R.layout.fragment_three, container, false);
        TextView tvLabel = view.findViewById(R.id.txtMain);
        tvLabel.setText(title);
        ImageView imageView = view.findViewById(R.id.imgMain);
        imageView.setImageResource(image);
        return view;
    }
}
