package com.example.hbs.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.example.hbs.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//模拟数据库中的数据
@Repository
public class deptDAO {
    private static Map<Integer, Dept> depts = null;
    static {
        depts = new HashMap<Integer, Dept>();

        depts.put(101, new Dept("内科",0,"内科是XXXXXXXXXXXXXXXXXXXXX"));
        depts.put(102,new Dept("五官科",0,"五官科包括耳、鼻、喉等XXXXXXXXXXXX"));
        depts.put(103,new Dept("眼科",102,"眼科XXXXXXXXXXXXXXXXXXXX"));
        depts.put(104,new Dept("妇科",0,"妇科包括XXXXXXXXXXXXXXXXXXXXX"));
        depts.put(105,new Dept("外科",0,"外科XXXXXXXXXXXXXXXXXXXXXXXXXX下"));
    }

    //科室id自增
    private static Integer initID = 106;

    //获得部门所有信息
    public Collection<Dept> getDept(){
        return depts.values();
    }

    //通过id获得部门信息
    public Dept getDeptByID(Integer id){
        return depts.get(id);
    }

    //通过ID删除部门信息
    public void removeDept(Integer id){
        depts.remove(id);
    }

    //添加部门信息
    public void addDept(Dept dept){
        depts.put(initID, dept);
        initID ++;
    }
}

