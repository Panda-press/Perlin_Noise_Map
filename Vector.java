

public class Vector{
    private double x;
    private double y;
    public Vector(double x, double y){
        this.x = x;
        this.y = y;
    }
    public Vector(){
        Random();
    }
    public void Normalise(){
        double len = Math.sqrt(x*x + y*y);
        x /=len;
        y /=len;
    }
    public void Random(){
        x = 2*Math.random()-1;
        y = 2*Math.random()-1;
        Normalise();
    }
    public static double Dot(Vector a, Vector b){
        double result = a.GetX() * b.GetX() + a.GetY() * b.GetY();
        return result;
    }
    public double GetX(){
        return x;
    }
    public double GetY(){
        return y;
    }
}