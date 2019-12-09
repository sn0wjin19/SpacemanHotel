package com.example.spacemanhotel;

import android.util.Log;

import java.sql.*;

public class DaoThread extends Thread{
    private static String TAG = "DaoThread";
    private Connection conn;
    private String driver;
    private String url;
    private String user;
    private String password;

    public DaoThread() {
        driver = "com.mysql.jdbc.Driver";
        url = "jdbc:mysql://10.0.2.2:3306/大作业1?user=root&password=430421&useUnicode=true&characterEncoding=utf8";
        user = "root";
        password = "430421";
    }
    public void run(){
        try {
            Class.forName(driver);
            Log.d(TAG, "加载JDBC驱动成功");
        } catch (ClassNotFoundException e) {
            Log.d(TAG, "加载JDBC驱动失败");
            return;
        }
//                while (!Thread.interrupted()) {
//                    try {
//                        Thread.sleep(100);  // 每隔0.1秒尝试连接
//                    } catch (InterruptedException e) {
//                        Log.e("调试", e.toString());
//                    }
        try {
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                Log.d(TAG, "连接成功");
                Statement stat = conn.createStatement(); //根据返回的Connection对象创建 Statement对象
                String sql = "select * from Lanmu"; //要执行的sql语句
                ResultSet rs = stat.executeQuery(sql); //使用executeQury方法执行sql语句 返回ResultSet对象 即查询的结果
                while (rs.next()) {
//                            Lanmu lanmu=new Lanmu();
//                            lanmu.setId(Integer.parseInt(rs.getString("Id")));
//                            lanmu.setLname(rs.getString("Lname"));
//                            lanmu.setLdescription(rs.getString("Ldescription"));
//                            lanmus.add(lanmu);
                    Log.d(TAG, rs.getString("Id"));
                    Log.d(TAG, rs.getString("Lname"));
                    Log.d(TAG, rs.getString("Ldescription"));
                }
                rs.close();
                stat.close();
            } else {
                Log.d(TAG, "连接失败");
            }
        }  catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                    conn = null;
                }
            } catch (Exception ex) {

            }
        }
    }
}
