package com.sifang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkerLogin {
    private int id;
    private String num;
    private String pwd;
}
