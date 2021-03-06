package com.example.myapplication.fragment;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapter.ArticleAdapter;
import com.example.myapplication.Adapter.CategoryAdapter;
import com.example.myapplication.MainActivity;
import com.example.myapplication.Models.Article;
import com.example.myapplication.Models.Category;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class CategoryDetailFragment extends Fragment {
    private RecyclerView row;
    List<Article> list;

    Toolbar toolbar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_detail_category,container,false);
        MainActivity mainActivity = new MainActivity();
        mainActivity.setOnPageCategory(true);
        Intent i = getActivity().getIntent();
        Category category = (Category) i.getSerializableExtra("complexObject");

//        toolbar = view.findViewById(R.id.toolbar);
       // toolbar.setTitle(category.name);

        RecyclerView myrw = (RecyclerView) view.findViewById(R.id.row_detail_category);
        ArticleAdapter articleAdapter = new ArticleAdapter(getContext(),list);
        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(getActivity());
        myrw.setLayoutManager(gridLayoutManager);
        myrw.setAdapter(articleAdapter);
        return  view;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list = new ArrayList<>();
        list.add(new Article(R.drawable.img_1,"Nhi???u ng?????i d??ng Instagram ??ang b??? l??? t??nh n??ng c???c k??? th?? v??? n??y!","thai bang 1","02/01/2000"));
        list.add(new Article(R.drawable.img_1,"H??? n??? n???n s??u th???m ch???ng kh??c g?? Squid Game t???i H??n Qu???c","thai bang 2","02/04/2000"));
        list.add(new Article(R.drawable.img_1,"Kinh h??i vi???c b??? gi???t h???i c??? l??ng ????? tr??? th?? cho con trai","thai bang 3","02/05/2000"));
        list.add(new Article(R.drawable.img_1,"Qu??n qu??n Olympia gi??u c?? b???c nh???t","thai bang 4","02/06/2000"));
        list.add(new Article(R.drawable.img_1,"tGiai tho???i v??? nh???ng chi???c quan t??i v?? nh???ng ng??i m??? d?????i l??ng H??? T??y","thai bang 5","02/07/2000"));

    }
}
