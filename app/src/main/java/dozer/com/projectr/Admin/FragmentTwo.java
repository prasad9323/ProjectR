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

public class FragmentTwo extends Fragment {
    private String title;
    private int imageMain;
    private int imageSecondary;

    public static FragmentTwo newInstance(String title, int resMainImage, int resSecondaryImage) {
        FragmentTwo fragment = new FragmentTwo();
        Bundle args = new Bundle();
        args.putInt("imageMain", resMainImage);
        args.putInt("imageSecondary", resSecondaryImage);
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        imageMain = getArguments().getInt("imageMain", 0);
        imageSecondary = getArguments().getInt("imageSecondary", 0);
        title = getArguments().getString("title");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        TextView tvLabel = view.findViewById(R.id.txtMain);
        tvLabel.setText(title);
        ImageView imageView = view.findViewById(R.id.imgMain);
        imageView.setImageResource(imageMain);
        ImageView imageViewSecondary = view.findViewById(R.id.imgSecondary);
        imageViewSecondary.setImageResource(imageSecondary);
        return view;
    }
}