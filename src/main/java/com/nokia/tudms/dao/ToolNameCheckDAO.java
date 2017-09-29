package com.nokia.tudms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/6/25.
 */
public class ToolNameCheckDAO {

    public static boolean toolNameCheck(String toolName){
        boolean flag = false;
        try {
            Connection con = DBPool.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT `tool-name` FROM tool WHERE `tool-name` = ?");
            ps.setString(1,toolName);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                flag = true;
            }
            rs.close();
            ps.close();
            con.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return flag;
    }
}
