package com.it.studentsystem;


import java.util.ArrayList;
import java.util.Scanner;

public class StudentSystem {
    public static void main(String[] args) {

        //创建集合
        ArrayList<Student> list = new ArrayList<>();



        loop: while (true) {
            System.out.println("------------欢迎来到学生管理系统---------------");
            System.out.println("1.添加学生");
            System.out.println("2.删除学生");
            System.out.println("3.修改学生");
            System.out.println("4.查询学生");
            System.out.println("5.退出");
            System.out.println("请输入你的选择：");

            Scanner sc = new Scanner(System.in);
            String choose = sc.next();

             switch (choose){
                case "1" -> addStudent(list);
                case "2" -> deleteStudent(list);
                case "3" -> updateStudent(list);
                case "4" -> queryStudent(list);
                case "5" -> {
                    System.out.println("退出");
                    //System.exit(0); 停止虚拟机运行
                    break loop;
                }
                default -> System.out.println("没有这个选项");
            }
        }
    }

    //添加学生
    public static void addStudent(ArrayList<Student> list){
        Scanner sc = new Scanner(System.in);
        //创建学生对象
        Student student = new Student();
        //键盘录入
        String id = null;
        while (true) {
            System.out.println("请输入学生id：");
            id = sc.next();

            if(contains(list,id)){
                System.out.println("id重复，请重新输入");
            }else {
                break;
            }
        }

        System.out.println("请输入学生姓名：");
        String name = sc.next();
        System.out.println("请输入学生年龄：");
        int age = sc.nextInt();
        System.out.println("请输入学生家庭地址：");
        String address = sc.next();
        //添加到学生对象中
        student.setId(id);
        student.setName(name);
        student.setAge(age);
        student.setAddress(address);
        //将学生对象添加到集合中
        list.add(student);

        //提示添加成功
        System.out.println("添加成功");
    }

    //删除学生
    public static void deleteStudent(ArrayList<Student> list){
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入需要删除学生信息的id：");
        String id = sc.next();

        //判断id是否在集合中
        if(!contains(list,id)){
            System.out.println("id不存在！");
        }else {
            //id在集合中，遍历集合
            for (int i = 0; i < list.size(); i++) {
                 if(list.get(i).getId().equals(id)){
                     //删除id对应的集合
                     list.remove(i);
                     System.out.println("删除成功");
                 }
            }
        }

    }

    //修改学生
    public static void updateStudent(ArrayList<Student> list){
        //1.键盘录入
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要修改学生的id：");
        String id = sc.next();


        //判断id是否存在
        if(contains(list,id)){
            //id存在
            System.out.println("更改姓名为：");
            String name = sc.next();
            System.out.println("更改年龄为：");
            int age = sc.nextInt();
            System.out.println("更改地址为：");
            String address = sc.next();
            //创建学生对象，并将输入的值添加到学生对象中
            Student student = new Student(id, name, age, address);

            //遍历集合
            for (int i = 0; i < list.size(); i++) {
                //查找集合中与输入相同的id
                if (list.get(i).getId().equals(id)){
                    //重新为集合的元素赋值
                    list.set(i,student);
                }
            }

        }else {
            //不存在
            System.out.println("id不存在");
        }
    }

    //查询学生
    public static void queryStudent(ArrayList<Student> list){
        if (list.size() == 0){
            System.out.println("无学生信息");
        }
        System.out.println("id\t\t姓名\t年龄\t家庭住址");
        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            System.out.println(student.getId()+ "\t"+ student.getName()+"\t"+student.getAge()+"\t"+student.getAddress());
        }
    }

    //判断id在集合中是否存在
    public static boolean contains(ArrayList<Student> list,String id){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)){
                return true;
            }
        }
        return false;
    }
}
