package com.ahu21.web;

import com.ahu21.mapper.ManagerMapper;
import com.ahu21.mapper.UserMapper;
import com.ahu21.pojo.User;
import com.alibaba.fastjson.JSON;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 读取请求体中的JSON数据
        request.setCharacterEncoding("UTF-8");
        StringBuilder jsonIn = new StringBuilder();
        String line;
        BufferedReader reader = request.getReader();
        while ((line = reader.readLine()) != null) {
            jsonIn.append(line);
        }
        System.out.println(jsonIn.toString());
        //转换json为java对象
        User user= JSON.parseObject(jsonIn.toString(),User.class);
        System.out.println(user);

        //		1.直接复制
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//      2.
        SqlSession sqlSession=sqlSessionFactory.openSession();
//		3.
        UserMapper userMapper =sqlSession.getMapper(UserMapper.class);

        User u= userMapper.selectByUsername(user.getUACCOUNT());


        if(u==null) {
            userMapper.add(user);

//            提交事务（很重要）
            sqlSession.commit();
            sqlSession.close();
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("注册成功");
        }
        else {
            System.out.println("用户名已存在");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("用户名已存在");
        }

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
