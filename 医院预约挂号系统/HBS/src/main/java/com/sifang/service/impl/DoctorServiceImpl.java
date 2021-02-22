package com.sifang.service.impl;

import com.sifang.mapper.DoctorMapper;
import com.sifang.mapper.WorkerLoginMapper;
import com.sifang.pojo.Doctor;
import com.sifang.pojo.ReturnMessage;
import com.sifang.pojo.WorkerLogin;
import com.sifang.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorMapper doctorMapper;
    @Autowired
    private WorkerLoginMapper workerLoginMapper;

    @Override
    public ReturnMessage addDoctor(Doctor doctor) {
        ReturnMessage returnMessage = new ReturnMessage();
        WorkerLogin workerLogin = new WorkerLogin();
        //添加医生
        //添加医生时自动为医生注册登录账号
        if (doctorMapper.addDoctor(doctor) >= 1){
            workerLogin.setNum(doctor.getNum());
            workerLogin.setPwd(doctor.getNum());
            if (workerLoginMapper.addWorker(workerLogin) >= 1){
                returnMessage.setIsSuccess(0);
                returnMessage.setMessage("添加成功！");
            }else{
                returnMessage.setIsSuccess(1);
                returnMessage.setMessage("添加医生登录账号失败！");
            }

        }else{
            returnMessage.setIsSuccess(1);
            returnMessage.setMessage("添加医生失败！");
        }
        return returnMessage;
    }
}
