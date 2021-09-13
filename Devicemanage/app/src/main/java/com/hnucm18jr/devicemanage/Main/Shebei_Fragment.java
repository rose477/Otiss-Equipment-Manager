package com.hnucm18jr.devicemanage.Main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.hnucm18jr.devicemanage.R;

import com.hnucm18jr.devicemanage.Type.TypeActivity;
import com.hnucm18jr.devicemanage.Wo.Bm_Adapter;
import com.hnucm18jr.devicemanage.Wo.Bumen;
import com.hnucm18jr.devicemanage.Wo.Tuijian;
import com.hnucm18jr.devicemanage.Wo.TuijianAdapter;
import com.hnucm18jr.devicemanage.model.Login_;
import com.hnucm18jr.devicemanage.model.Main_;
import com.hnucm18jr.devicemanage.sao.ShebeiActivity;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class Shebei_Fragment extends Fragment {
    RecyclerView recyclerView2;

    List<Bumen> datas;
    Bm_Adapter adapter;
    Banner banner;
    ImageView message;
    List<Tuijian> datas2 = new ArrayList<>();

    TuijianAdapter adapter2;
    private ArrayList<Integer> images = new ArrayList<>(); //设置数据源
    ConstraintLayout mConstraintLayout;

    SwipeRefreshLayout mSwipeRefreshLayout;
    TextView mTextView,mTextView2;
    ConstraintLayout mConstraintLayout3,mConstraintLayout4;
    int i=0;

    int j=0;
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    ConstraintLayout mConstraintLayout1,mConstraintLayout2;
    ConstraintLayout top2,top3,top4,bot1,bot2,bot3,bot4;

    String account="002";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shebei_, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView2=getActivity().findViewById(R.id.recyler2);//实例化
        mTextView=getActivity().findViewById(R.id.bottom);
        mTextView2=getActivity().findViewById(R.id.bottom2);
        mConstraintLayout1=getActivity().findViewById(R.id.tuijian);
        mConstraintLayout2=getActivity().findViewById(R.id.tuijian2);
        message=getActivity().findViewById(R.id.right);
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), MessageActivity.class);
                startActivity(intent);
            }
        });
        try {
            postAsynHttp();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mConstraintLayout4=getActivity().findViewById(R.id.top1);
        mConstraintLayout3=getActivity().findViewById(R.id.constraintLayout2);
        mConstraintLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), TypeActivity.class);
                startActivity(intent);
            }
        });
        mConstraintLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);

            }
        });
        top2=getActivity().findViewById(R.id.constraintLayout);
        top2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), TypeActivity.class);
                startActivity(intent);
            }
        });
        top3=getActivity().findViewById(R.id.constraintLayout3);
        top3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), TypeActivity.class);
                startActivity(intent);
            }
        });
        top4=getActivity().findViewById(R.id.constraintLayout4);
        top4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), TypeActivity.class);
                startActivity(intent);
            }
        });
        bot1=getActivity().findViewById(R.id.constraintLayout22);
        bot1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), TypeActivity.class);
                startActivity(intent);
            }
        });
        bot2=getActivity().findViewById(R.id.constraintLayout1);
        bot2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), TypeActivity.class);
                startActivity(intent);
            }
        });
        bot3=getActivity().findViewById(R.id.constraintLayout33);
        bot3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), TypeActivity.class);
                startActivity(intent);
            }
        });
        bot4=getActivity().findViewById(R.id.constraintLayout44);
        bot4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), TypeActivity.class);
                startActivity(intent);
            }
        });
        mConstraintLayout2.setSelected(true);
        mConstraintLayout1.setSelected(false);
        mConstraintLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mConstraintLayout2.setSelected(false);
                mConstraintLayout1.setSelected(true);
                if (i!=1){
                    datas2.clear();
                    mSwipeRefreshLayout.setRefreshing(true);
                    Tuijian tuijian;
                     String  a[]={"AOG显示屏","雷蛇鼠标","公牛排插","MacBook电脑","U盘","雷蛇键盘"};
                     int b[]={
                       R.drawable.newsb1,R.drawable.tuijian2,R.drawable.newsb2,R.drawable.newsb3,R.drawable.newsb4,R.drawable.tuijian1
                     };


                    for (int i = 0; i < 6; i++) {
                        tuijian= new Tuijian();
                        tuijian.setNum("空闲");
                        tuijian.setName(a[i]);
                        tuijian.setImage(b[i]);
                        datas2.add(tuijian);


                    }

                    recyclerView2.postDelayed(new Runnable() {
                        @Override
                        public void run() {



                            adapter2.notifyDataSetChanged();
                            mSwipeRefreshLayout.setRefreshing(false);
                        }
                    }, 1000);

                }


                i=1;




            }
        });
        mConstraintLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mConstraintLayout2.setSelected(true);
                mConstraintLayout1.setSelected(false);
                if (i!=0){
                    datas2.clear();
                    mSwipeRefreshLayout.setRefreshing(true);

                    String  a[]={"雷蛇键盘","新越昌辉小推车","华为智选台灯","卡夫威尔螺丝刀","惠普散热器","小熊牌咖啡机"};
                    String  b[]={"唐小波","周小吕","罗斯","周天","韩德君","李有为"};
                    int c[]={
                            R.drawable.tuijian1,R.drawable.bumen1,R.drawable.bumen2,R.drawable.bumen3,R.drawable.tuijian5,R.drawable.bumen4
                    };

                    //  Log.i("clike",""+i);
                    Tuijian tuijian;
                    for (int i = 0; i < 6; i++) {
                        tuijian= new Tuijian();
                        tuijian.setNum("使用者：");
                        tuijian.setUser(b[i]);
                        tuijian.setName(a[i]);
                        tuijian.setImage(c[i]);
                        datas2.add(tuijian);


                    }
                    recyclerView2.postDelayed(new Runnable() {
                        @Override
                        public void run() {



                            adapter2.notifyDataSetChanged();
                            mSwipeRefreshLayout.setRefreshing(false);
                        }
                    }, 1000);

                }
                i=0;

            }
        });
        //找到控件
        banner =  getActivity().findViewById(R.id.bannerview);
        mConstraintLayout=getActivity().findViewById(R.id.top1);
        mSwipeRefreshLayout=getActivity().findViewById(R.id.seipe_main);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.main);
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {

                Intent intent=new Intent(getActivity(), ShebeiActivity.class);
                startActivity(intent);
            }
        });

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                datas2.clear();
                if (i==0){
                    //  Log.i("clike",""+i);
                    Tuijian tuijian;
                    String  a[]={"古雷诺斯办公椅","得力计算器","得力美工刀","惠普笔记本","得力剪刀","20L收纳箱"};
                    String  b[]={"李冰冰","肖涛儿","李小国","许多","袁锋树","呙大勇"};
                    int c[]={
                            R.drawable.bumen5,R.drawable.bumen6,R.drawable.bumen7,R.drawable.tuijian4,R.drawable.bumen8,R.drawable.bumen9
                    };
                    for (int i = 0; i < 6; i++) {
                        tuijian= new Tuijian();
                        tuijian.setNum("使用者：");
                        tuijian.setUser(b[i]);
                        tuijian.setName(a[i]);
                        tuijian.setImage(c[i]);
                        datas2.add(tuijian);


                    }
                }else {
                    //模拟数据

                    String  a[]={"惠普音响","会议麦克风","诺尔会议控制笔","极光投影仪","艾瑞尔投影仪幕布","索爱麦克风"};
                    int b[]={
                            R.drawable.tuijian7,R.drawable.tuijian8,R.drawable.tuijian9,R.drawable.tuijian10,R.drawable.tuijian11,R.drawable.tuijian12
                    };
                    for (int i = 0; i < 6; i++) {
                        Tuijian  tuijian= new Tuijian();
                        tuijian.setNum("空闲");

                        tuijian.setName(a[i]);
                        tuijian.setImage(b[i]);
                        datas2.add(tuijian);


                    }
                }




                recyclerView2.postDelayed(new Runnable() {
                    @Override
                    public void run() {



                        adapter2.notifyDataSetChanged();
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                }, 1000);
            }
        });
        bannerView1();
        mConstraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
            }
        });
        Thread thread = new Thread(){//方法1
            @Override
            public void run() {
                super.run();
                //子线程
                /**
                 * 初始化数据
                 */
                Tuijian tuijian;
                String  a[]={"惠普音响","诺尔会议控制笔","艾瑞尔投影仪幕布","惠普笔记本","得力剪刀","极光投影仪"};
                String  b[]={"刘小杰","李德华","周学友","张杰伦","杨三丰","徐浩辰"};
                int c[]={
                        R.drawable.tuijian7,R.drawable.tuijian9,R.drawable.tuijian11,R.drawable.tuijian4,R.drawable.bumen8,R.drawable.tuijian10
                };
                for (int i = 0; i <6 ; i++) {
                    tuijian= new Tuijian();
                    tuijian.setNum("使用者：");
                    tuijian.setUser(b[i]);
                    tuijian.setName(a[i]);
                    tuijian.setImage(c[i]);
                    datas2.add(tuijian);


                }





                //创建布局管理
                recyclerView2.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));//可以表述一行显示item的数量，并且可以设置列表的方向

                //创建适配器
                adapter2 = new TuijianAdapter(R.layout.tuijian_item, datas2);

                //给RecyclerView设置适配器
                recyclerView2.setAdapter(adapter2);
                adapter2.notifyDataSetChanged();
                //设置重复执行动画
                adapter2.isFirstOnly(false);
                //item点击事件
                adapter2.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        Intent intent=new Intent(getActivity(), ShebeiActivity.class);
                        startActivity(intent);
                    }
                });
                //条目子控件点击事件
                adapter2.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                    @Override
                    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

                        if (j==0){
                            view.setSelected(true);
                            Toast.makeText(getActivity(), "收藏成功", Toast.LENGTH_SHORT).show();
                            j++;
                        }else {
                            view.setSelected(false);
                            Toast.makeText(getActivity(), "取消收藏", Toast.LENGTH_SHORT).show();
                            j--;
                        }


                    }
                });






            }
        };
        thread.start();

    }

    private void bannerView1(){//获取本地图片的轮播
        List<Integer> images = new ArrayList<>();//存放轮播的图片
        //在本地获取图片资源
        images.add(R.drawable.a9);
        images.add(R.drawable.a5);
        images.add(R.drawable.a7);
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.DepthPage);
        //设置图片加载器
        banner.setImageLoader(new MyLoader());
        //设置图片集合
        banner.setImages(images);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(2000);
        //小点点居中
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }
    public class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {

            imageView.setScaleType(ImageView.ScaleType.FIT_XY);


            Glide.with(context).load(path).into(imageView);

        }
    }
    private class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {

            imageView.setImageResource((Integer) path);//加载本地文件
        }

        /**
         * 自定义圆角类
         *
         * @param context
         * @return
         */
        @Override
        public ImageView createImageView(Context context) {
            RoundImageView img = new RoundImageView(context);
            return img;

        }
    }
    private void postAsynHttp() throws JSONException {//异步post的使用



        HashMap<String,String> json=new HashMap<String, String>();
        json.put("account",account);
        json.put("nowPage","0");
        json.put("pageNum","0");

        Gson gson=new Gson();
        String r=gson.toJson(json);
        OkHttpClient mOkHttpClient = new OkHttpClient();
        RequestBody requestBody = RequestBody.create(JSON, r);

        Request request = new Request.Builder()
                .url("http://192.168.43.138:8090/messages/userIndex/"+account)
                .post(requestBody)
                .build();
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("fail","post失败"+e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String str = response.body().string();
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Gson gson=new Gson();//创建Gson对象
                        final Main_ main_=gson.fromJson(str,Main_.class);//第一个值传json数据，第二个值传解析的类型



//                        for (int i = 0; i < main_.getData().getNewMachine().size(); i++) {
//                            bumen= new Bumen();
//
//                            bumen.setImage(main_.getData().getNewMachine().);
//                            datas.add(bumen);
//
//
//                        }


                    }
                });
            }


        });
    }
}