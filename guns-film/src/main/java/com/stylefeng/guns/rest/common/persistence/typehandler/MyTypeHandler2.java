package com.stylefeng.guns.rest.common.persistence.typehandler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyTypeHandler2 implements TypeHandler<String[]> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, String[] strings, JdbcType jdbcType) throws SQLException {
        if(null == strings){
            preparedStatement.setString(i,"");
            return;
        }
        StringBuffer sb = new StringBuffer();
        sb.append("#");
        for (String string : strings) {
            sb.append(string);
            sb.append("#");
        }
        //String substring = sb.substring(0, sb.length() - 1);
        String s = sb.toString();
        preparedStatement.setString(i,s);
    }

    @Override
    public String[] getResult(ResultSet resultSet, String s) throws SQLException {
        String string = resultSet.getString(s);
        return getStrings(string);
    }

    @Override
    public String[] getResult(ResultSet resultSet, int i) throws SQLException {
        String string = resultSet.getString(i);
        return getStrings(string);
    }

    @Override
    public String[] getResult(CallableStatement callableStatement, int i) throws SQLException {
        String string = callableStatement.getString(i);
        return getStrings(string);
    }

    private String[] getStrings(String s){
        if(null == s){
            return null;
        }
        String substring = s.substring(1, s.length() - 1);
        String[] split = substring.split("#");
        return split;
    }
}
