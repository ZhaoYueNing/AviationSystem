package com.zhao.aviationsystem;

import java.util.Scanner;

/**
 * 查询类:
 * 查询每个航班的情况:queryFlight
 * 查询每个用户的信息
 * 显示所有航班信息
 * 根据出发地和目的地筛选航班
 * @author zhao
 *
 */
public class Query {
	static Scanner sc;
	
	public static void query(){
		sc=new Scanner(System.in);
		int opt=1;
		while(opt!=0){
			opt=meanOpt();
			switch (opt) {
			case 1:
				queryFlight();//查询一趟航班信息
				break;
			case 2:
				queryUser();//查询用户信息
				break;
			case 3:
				queryAllFlight();//显示所有航班信息
				break;
			case 4:
				queryAllUser();//显示所有用户信息
				break;
			case 5:
				queryFligthLine();
				break;
			default:
				break;
			}
		}
	}
	/**
	 * 通过输入航班班次 查询某趟航班
	 */
	public static void queryFlight() {
		String str="y";
		while (true) {
			System.out.println("请输入航班班次:");
			String id=sc.next();
			Flight.disFlight(id);
			System.out.println("是否继续查询(结束请输入 n 或 N):");
			str=sc.next();
			if(str.equals("N")||str.equals("n"))
				break;
		}
	}
	/**
	 * 显示所有航班
	 */
	public static void queryAllFlight(){
		Flight.disAllFlight();
	}
	/**
	 * 查询某个乘客
	 * @return void
	 */
	public static void queryUser(){
		int id=sc.nextInt();
		User.disUser(id);
	}
	/**
	 * 显示所有乘客的信息
	 * @return void
	 */
	public static void queryAllUser(){
		User.disAllUser();
	}
	/**
	 * 查询某条航线上的航班
	 * @return
	 */
	public static void queryFligthLine(){
		System.out.println("请输入出发地:");
		String origin=sc.next();
		System.out.println("请输入目的地:");
		String destination=sc.next();
		Flight.disFlightLine(origin, destination);
	}
	public static int meanOpt(){
		int opt=1;
		System.out.println("=====查询=====");
		System.out.println("1.查询某个航班信息;");
		System.out.println("2.查询某个用户信息;");
		System.out.println("3.显示所有航班信息;");
		System.out.println("4.显示所有用户信息;");
		System.out.println("5.根据出发地和目的地筛选航班;");
		System.out.println("0.返回;");
		System.out.println("请输入选择:");
		opt=sc.nextInt();
		return opt;//返回选择值
	}
	public static void main(String[] args) {
		Write.write();
		query();
	}
}
