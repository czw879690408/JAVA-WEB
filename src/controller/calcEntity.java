package controller;

public class calcEntity {
    private long id;
    private double x;
    private double y;
    private String op;

    public long getId() {
        return id;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setId(long id) {
        this.id = id;
    }

    private double result;
    public calcEntity() {
        super();
    }
    public  calcEntity(double x,String op,double y,double result){
        this.x=x;
        this.y=y;
        this.op=op;
        this.result=result;
    }
    @Override
    public String toString() {
        return "CalcEntity [op=" + op + ", result=" + result + ", x=" + x
                + ", y=" + y + "]";
    }
}
