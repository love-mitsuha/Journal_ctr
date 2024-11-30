package com.ahu21.web;

import com.ahu21.mapper.ManagerMapper;
import com.ahu21.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        User user=new User();
        user.setMACCOUNT(username);
        user.setMPASSWORD(password);

        //		1.直接复制
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//      2.
        SqlSession sqlSession=sqlSessionFactory.openSession();
//		3.
        ManagerMapper managerMapper =sqlSession.getMapper(ManagerMapper.class);

        User u= managerMapper.selectByUsername(username);


        if(u==null) {
            managerMapper.add(user);

//            提交事务（很重要）
            sqlSession.commit();
            sqlSession.close();
        }
        else {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("用户名已存在");
        }

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
