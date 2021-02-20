package com.example.hbs.dao;

import com.example.hbs.pojo.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//模拟数据库
@Repository
public class doctorDAO {
    private static Map<Integer, Doctor> doctors = null;
    static {
        doctors = new HashMap<Integer, Doctor>();

        doctors.put(10001,new Doctor("2017110405","张三",1,"外科",new Date(1997-02-14),"医生","感冒发烧、头疼脑热","ftggchtjghfjxdtrfgdrftgdtrgfdtrtg"));
        doctors.put(10002,new Doctor("2017110404","李四",0,"五官科",new Date(1980-10-11),"医生","耳科","fgyudhsjfbgdyfgshdsghghgh"));
        doctors.put(10003,new Doctor("2017110401","王五",1,"妇科",new Date(1979-07-01),"医师","妇产科","fgvyuehioedhsdfhwefgyugfsdjhsjh"));

    }

    //医生序号自增
    private static Integer initID = 10004;

    //获得医生所有信息
    public Collection<Doctor> getDoctor(){
        return doctors.values();
    }

    //通过id获得医生信息
    public Doctor getDoctorByID(Integer id){
        return doctors.get(id);
    }

    //通过id删除医生
    public void removeDoctor(Integer id){
        doctors.remove(id);
    }

    //添加医生
    public void addDoctor(Doctor doctor){
        doctors.put(initID, doctor);
        initID ++;
    }
}
