/**
 * Created by student on 27.10.2014.
 */
public class Physics {

    private int x = 0;
    private int cadre = 0;

    void update(int dx) {
        int newcadre = cadre + dx;
        if (newcadre < 0) {
            cadre = 5;
        } else if (newcadre >= 6) {
            cadre = 0;
        } else {
            cadre = newcadre;
        }
        x += dx * 10;
    }

    public int getX() {
        return x;
    }

    public int getCadre() {
        return cadre;
    }
}
