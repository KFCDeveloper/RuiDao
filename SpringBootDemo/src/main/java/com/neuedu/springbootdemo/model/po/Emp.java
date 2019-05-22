package com.neuedu.springbootdemo.model.po;

import java.sql.Date;

public class Emp {
    private Integer empno;
    private String ename;
    private String job;

    private Date hiredate;
    private String hiredatestr;

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public String getHiredatestr() {
        return hiredatestr;
    }

    public void setHiredatestr(String hiredatestr) {
        this.hiredatestr = hiredatestr;
    }
    //    when we combine com.neuedu.springbootdemo.mappers with vo, we have this dilemma, what type of hiredate we should use
    /*
        1. define hiredate as Date, in page, we need to use java or javascript to format it
        2. define two field, hiredate->Date used to database, hiredatestr->String used

     */

    @Override
    public String toString() {
        return "Emp{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", hiredate=" + hiredate +
                ", hiredatestr='" + hiredatestr + '\'' +
                '}';
    }
}

