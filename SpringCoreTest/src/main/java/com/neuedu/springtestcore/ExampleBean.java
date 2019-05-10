package com.neuedu.springtestcore;

public class ExampleBean {
    private int years = 4000;
    private String ultimateAnswer = "aaa";

    public ExampleBean(int years, String ultimateAnswer) {
        this.years = years;
        this.ultimateAnswer = ultimateAnswer;
    }

    public void outPutInfo(){
        System.out.println(this.years+"\t"+this.ultimateAnswer);
    }
}
