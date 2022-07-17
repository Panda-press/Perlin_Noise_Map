

public class Perlin{
    protected Vector[][] Grid;
    protected int w; //Width and height
    protected int h;
    protected int square_size;
    public Perlin(int w, int h, int square_size){
        this.square_size = square_size;
        this.w = w;
        this.h = h;
        Grid = new Vector[w+1][h+1];
        for (int i = 0; i<w+1; i++){
            for (int j = 0; j<h+1; j++){
                Grid[i][j] = new Vector();
            }
        }
    }
    public double GetPixel(int x, int y){
        int Gridx = (int) Math.floor(x/square_size);
        int Gridy = (int) Math.floor(y/square_size);

        double relativeX = (double)x/(double)square_size - Gridx;
        double relativeY = (double)y/(double)square_size - Gridy;

        double a0 = Vector.Dot(new Vector(relativeX, relativeY), Grid[Gridx][Gridy])/2;
        double a1 = Vector.Dot(new Vector(relativeX - 1, relativeY), Grid[Gridx +1][Gridy])/2;
        double b0 = Vector.Dot(new Vector(relativeX, relativeY - 1), Grid[Gridx][Gridy +1])/2;
        double b1 = Vector.Dot(new Vector(relativeX - 1, relativeY - 1), Grid[Gridx +1][Gridy +1])/2;
        

        double x0 = a0 + Smoothstep(relativeX) * (a1 - a0);
        double x1 = b0 + Smoothstep(relativeX) * (b1 - b0);

        double result = x0 + Smoothstep(relativeY) * (x1 - x0);

        return result;
    }
    public int GetPixelWidth(){
        return w * square_size;
    }
    public int GetPixelHeight(){
        return h * square_size;
    }
    protected double Smoothstep(double x){
        if (x <= 0){
            return 0;
        }else if (x >= 1){
            return 1;
        }else{
            return x * x * (3 - 2*x);
        }
    }
}