package com.neuedu.springtestcore;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ExampleBean {
    private int years = 4000;
    private String ultimateAnswer = "aaa";

    //typed collection
    private List<String> list;
    private Set<String> set;
    //第一个是String 第二个什么都可以
    private Map<String,String>map;

//    public ExampleBean(int years, String ultimateAnswer) {
//        this.years = years;
//        this.ultimateAnswer = ultimateAnswer;
//    }


    public void setList(List<String> list) {
        this.list = list;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public void setUltimateAnswer(String ultimateAnswer) {
        this.ultimateAnswer = ultimateAnswer;
    }

    public void outPutInfo(){
        System.out.println(this.years+"\t"+this.ultimateAnswer);

        //Iterate list
        for(String item:list){
            System.out.println(item);
        }
        System.out.println("================================");
        //iterator set //foreach is implemented by iterator,so set can use foreach
        for (String s : set) {
            System.out.println(s);
        }
        System.out.println("================================");

        //iterate map
        //Map是一个接口，Entry是一个嵌套接口
        Set<Map.Entry<String,String>> entries = map.entrySet();
        Iterator<Map.Entry<String,String>> it2 = entries.iterator();
        while (it2.hasNext()){
            Map.Entry<String,String>entry = it2.next();
            System.out.println(entry.getKey()+"\t"+entry.getValue());
        }

    }
}
