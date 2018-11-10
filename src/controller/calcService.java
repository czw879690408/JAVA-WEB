package controller;

import java.sql.SQLException;

public class calcService {
    private calcDao dao=new calcDao();

    public double calc(double x,String op,double y) throws SQLException, ClassNotFoundException {
        double result=1.0;
        switch (op){
            case "+" : result = x + y;break;
            case "-" : result = x - y;break;
            case "*" : result = x * y;break;
            case "/" : result = y==0 ? 0 : x / y;break;
        }
        calcEntity en=new calcEntity(x,op,y,result);
        dao.save(en);
        return result;
    }

}
