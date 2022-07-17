
public class Fractal extends Perlin{
    protected Perlin[] layers;

    public Fractal(int w, int h, int square_size_to_n, int num_layers){
        this.layers = new Perlin[num_layers];
        for (int i = 0; i<num_layers; i++){
            layers[i] = new Perlin(w * 2**i, h * 2**i, square_size_to_n / 2**i);
        }
    }
}