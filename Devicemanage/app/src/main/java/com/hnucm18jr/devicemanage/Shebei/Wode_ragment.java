package com.hnucm18jr.devicemanage.Shebei;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.fastjson.JSON;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hnucm18jr.devicemanage.R;
import com.hnucm18jr.devicemanage.sao.ShebeiActivity;

import java.util.ArrayList;
import java.util.List;


public class Wode_ragment extends Fragment {


    private RecyclerView mRvClass;
    private RecyclerView mRvStudent;
    private ClassifyAdapter classAdapter;
    private SubclassAdapter studentAdapter;
    private String jsonData;
    private List<SubclassModel> studentList;
    private List<ClassifyModel> classAllList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_wode_ragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        simulationsData();
        initView();
        initData();
        initAdapter();
    }
    private void initView() {
        mRvClass = getActivity().findViewById(R.id.rv_class);
        mRvStudent = getActivity().findViewById(R.id.rv_student);
    }

    private void initData() {
        //解析 - 模拟数据
        studentList = new ArrayList<>();
        classAllList = JSON.parseArray(jsonData, ClassifyModel.class);

        //设置 - 初始默认数据
        studentList.clear();
        for (int i = 0; i < classAllList.size(); i++) {
            studentList.addAll(classAllList.get(i).getList());
        }
    }

    private void initAdapter() {
        classAdapter = new ClassifyAdapter(R.layout.item_classify, classAllList);
        mRvClass.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRvClass.setAdapter(classAdapter);
        //设置默认的选取状态
        classAdapter.setSelection(0);

        studentAdapter = new SubclassAdapter(R.layout.item_subclass, studentList);
        mRvStudent.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRvStudent.setAdapter(studentAdapter);

        /**
         * 左侧列表的事件处理
         * */
        classAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                classAdapter.setSelection(position);
                //临时变量记录当前左侧选中条目的子集数据长度
                int sum = 0;
                for (int i = 0; i < position; i++) {
                    sum += classAllList.get(i).getList().size();
                }
                //根据左侧，定位右侧的展示数据
                LinearLayoutManager layoutManager = (LinearLayoutManager) mRvStudent.getLayoutManager();
                layoutManager.scrollToPositionWithOffset(sum, 0);
            }
        });

        /**
         * 注意 - 双标联动关键
         * */
        mRvStudent.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                //获取滚动时的第一条展示的position
                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();
                //获取右侧数据的关联id
                SubclassModel subclassModel = studentList.get(firstVisibleItemPosition);
                int outId = subclassModel.getOutId();
                //记录外部id， 更新左侧状态栏状态
                int pos = 0;
                for (int i = 0; i < classAllList.size(); i++) {
                    int id = classAllList.get(i).getId();
                    if (outId == id) {
                        pos = i;
                    }
                }
                classAdapter.setSelection(pos);
            }
        });
    }

    /**
     * 数据模拟 - 可忽略 ，一般这里的数据都是后台网络请求之后返回的
     */
    private void simulationsData() {
        List<ClassifyModel> classList = new ArrayList<>();
        List<SubclassModel> studentList1 = new ArrayList<>();
        List<SubclassModel> studentList2 = new ArrayList<>();
        List<SubclassModel> studentList3 = new ArrayList<>();
        List<SubclassModel> studentList4 = new ArrayList<>();
        List<SubclassModel> studentList5 = new ArrayList<>();
        List<SubclassModel> studentList6 = new ArrayList<>();
        List<SubclassModel> studentList7 = new ArrayList<>();
        List<SubclassModel> studentList8 = new ArrayList<>();
        List<SubclassModel> studentList9 = new ArrayList<>();
        List<SubclassModel> studentList10 = new ArrayList<>();
        List<SubclassModel> studentList11 = new ArrayList<>();
        List<SubclassModel> studentList12 = new ArrayList<>();
        String  a[]={"惠普电脑","红米手机","三星平板","萤石监控摄像头","小米电子黑板","戴尔电脑","戴尔笔记本","雷神显示屏"};
        int b[]={
                R.drawable.tuijian4,R.mipmap.dianzi1,R.mipmap.dianzi2,R.mipmap.dianzi3,R.mipmap.dianzi4,R.mipmap.dianzi5,R.mipmap.dianzi6,R.drawable.tuijian3,
        };
        for (int i = 0; i < 8; i++) {
            SubclassModel subclassModel = new SubclassModel();
            subclassModel.setTitle(a[i]);
            subclassModel.setDes("");
            subclassModel.setAuthor("空闲" );
            subclassModel.setImage(b[i]);
            subclassModel.setOutId(1);
            studentList1.add(subclassModel);
        }
        String  c[]={"得力计算器","得力美工刀","得力剪刀","惠普打印机","会议麦克风","诺为会议笔","索爱麦克风","得力胶棒"};
        int d[]={
                R.drawable.bumen6,R.drawable.bumen7,R.drawable.bumen8,R.drawable.tuijian6,R.drawable.tuijian8,R.drawable.tuijian9,R.drawable.tuijian12,R.drawable.bangong,
        };
        for (int i = 0; i < 8; i++) {
            SubclassModel subclassModel = new SubclassModel();
            subclassModel.setTitle(c[i]);
            subclassModel.setDes("" );
            subclassModel.setAuthor("空闲" );
            subclassModel.setImage(d[i]);
            subclassModel.setOutId(2);
            studentList2.add(subclassModel);
        }


        for (int i = 0; i < 8; i++) {
            SubclassModel subclassModel = new SubclassModel();
            subclassModel.setDes("" );
            subclassModel.setAuthor("空闲" );
            subclassModel.setOutId(3);
            studentList3.add(subclassModel);
        }

        for (int i = 0; i < 8; i++) {
            SubclassModel subclassModel = new SubclassModel();
            subclassModel.setDes("" );
            subclassModel.setAuthor("空闲" );
            subclassModel.setOutId(4);
            studentList4.add(subclassModel);
        }

        for (int i = 0; i < 8; i++) {
            SubclassModel subclassModel = new SubclassModel();
            subclassModel.setDes("" );
            subclassModel.setAuthor("空闲" );
            subclassModel.setOutId(5);
            studentList5.add(subclassModel);
        }
        for (int i = 0; i < 8; i++) {
            SubclassModel subclassModel = new SubclassModel();
            subclassModel.setDes("" );
            subclassModel.setAuthor("空闲" );
            subclassModel.setOutId(6);
            studentList6.add(subclassModel);
        }
        for (int i = 0; i < 8; i++) {
            SubclassModel subclassModel = new SubclassModel();
            subclassModel.setDes("" );
            subclassModel.setAuthor("空闲" );
            subclassModel.setOutId(7);
            studentList7.add(subclassModel);
        }
        for (int i = 0; i < 8; i++) {
            SubclassModel subclassModel = new SubclassModel();
            subclassModel.setDes("" );
            subclassModel.setAuthor("空闲" );
            subclassModel.setOutId(8);
            studentList8.add(subclassModel);
        }
        for (int i = 0; i < 8; i++) {
            SubclassModel subclassModel = new SubclassModel();
            subclassModel.setDes("" );
            subclassModel.setAuthor("空闲" );
            subclassModel.setOutId(9);
            studentList9.add(subclassModel);
        }

        for (int i = 0; i < 8; i++) {
            SubclassModel subclassModel = new SubclassModel();
            subclassModel.setDes("" );
            subclassModel.setAuthor("空闲" );
            subclassModel.setOutId(10);
            studentList10.add(subclassModel);
        }

        for (int i = 0; i < 8; i++) {
            SubclassModel subclassModel = new SubclassModel();
            subclassModel.setDes("" );
            subclassModel.setAuthor("空闲" );
            subclassModel.setOutId(11);
            studentList10.add(subclassModel);
        }

        for (int i = 0; i < 8; i++) {
            SubclassModel subclassModel = new SubclassModel();
            subclassModel.setDes("" );
            subclassModel.setAuthor("空闲" );
            subclassModel.setOutId(12);
            studentList10.add(subclassModel);
        }

        ClassifyModel classModel = new ClassifyModel();
        classModel.setList(studentList1);
        classModel.setId(1);
        classModel.setName("电子设备");

        ClassifyModel classMode2 = new ClassifyModel();
        classMode2.setList(studentList2);
        classMode2.setId(2);
        classMode2.setName("办公用品");

        ClassifyModel classMode3 = new ClassifyModel();
        classMode3.setList(studentList3);
        classMode3.setId(3);
        classMode3.setName("电脑笔记");
        ClassifyModel classMode10 = new ClassifyModel();
        classMode10.setList(studentList4);
        classMode10.setId(10);
        classMode10.setName("键盘鼠标");
        ClassifyModel classMode5 = new ClassifyModel();
        classMode5.setList(studentList4);
        classMode5.setId(5);
        classMode5.setName("重要设备");
        ClassifyModel classMode6 = new ClassifyModel();
        classMode6.setList(studentList4);
        classMode6.setId(6);
        classMode6.setName("手机平板");
        ClassifyModel classMode7 = new ClassifyModel();
        classMode7.setList(studentList4);
        classMode7.setId(7);
        classMode7.setName("数码投影");
        ClassifyModel classMode8 = new ClassifyModel();
        classMode8.setList(studentList4);
        classMode8.setId(8);
        classMode8.setName("台灯照明");
        ClassifyModel classMode9 = new ClassifyModel();
        classMode9.setList(studentList4);
        classMode9.setId(9);
        classMode9.setName("托载搬运");
        ClassifyModel classMode4 = new ClassifyModel();
        classMode4.setList(studentList4);
        classMode4.setId(4);
        classMode4.setName("打扫清理");
        ClassifyModel classMode11 = new ClassifyModel();
        classMode11.setList(studentList4);
        classMode11.setId(9);
        classMode11.setName("会议演讲");
        ClassifyModel classMode12 = new ClassifyModel();
        classMode12.setList(studentList4);
        classMode12.setId(4);
        classMode12.setName("茶水咖啡");
        classList.add(classModel);
        classList.add(classMode2);
        classList.add(classMode3);
        classList.add(classMode10);
        classList.add(classMode5);
        classList.add(classMode6);
        classList.add(classMode7);
        classList.add(classMode8);
        classList.add(classMode9);
        classList.add(classMode4);
        classList.add(classMode11);
        classList.add(classMode12);

        jsonData = JSON.toJSONString(classList);


    }


}