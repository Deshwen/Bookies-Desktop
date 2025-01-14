//Konstruktory nadklasy nie są dziedziczone przez podklasy w Javie. 
//Jednak podklasa może wywołać konstruktor nadklasy za pomocą super().

//Wywołanie super() w konstruktorze podklasy służy do wywołania odpowiedniego konstruktora nadklasy. 
//Może być używane do przekazywania argumentów do nadklasy i inicjalizacji pól, które są w nadklasie.
import java.awt.Point;
import java.awt.Rectangle;


import java.awt.Point;
import java.awt.Rectangle;

public class Main {
    public static class Prostokat extends Rectangle {
        public Prostokat(Point wierzcholek, int dlugosc, int szerokosc) {
            super(wierzcholek.x, wierzcholek.y, dlugosc, szerokosc);
        }

        @Override
        public String toString() {
            return "Prostokat o wierzchlłku w punkcie (" + this.x + ", " + this.y +
                   "), dlugosci: " + this.width + ", szerokosci: " + this.height;
        }

        public boolean czyPrzylegaDo(Prostokat inny) {
            boolean przylegaZGory = (this.y + this.height == inny.y) && (this.x < inny.x + inny.width && this.x + this.width > inny.x);
            boolean przylegaZDolu = (this.y == inny.y + inny.height) && (this.x < inny.x + inny.width && this.x + this.width > inny.x);
            boolean przylegaZLewej = (this.x + this.width == inny.x) && (this.y < inny.y + inny.height && this.y + this.height > inny.y);
            boolean przylegaZPrawej = (this.x == inny.x + inny.width) && (this.y < inny.y + inny.height && this.y + this.height > inny.y);

            return przylegaZGory || przylegaZDolu || przylegaZLewej || przylegaZPrawej;
        }
    }

    public static void main(String[] args) {
        Prostokat prostokat1 = new Prostokat(new Point(0, 0), 50, 30);
        Prostokat prostokat2 = new Prostokat(new Point(50, 0), 50, 30); // Przylega z prawej strony
        Prostokat prostokat3 = new Prostokat(new Point(0, 30), 50, 30); // Przylega z góry
        Prostokat prostokat4 = new Prostokat(new Point(100, 100), 20, 20); // Nie przylega

        System.out.println("Czy prostokat 1 przylega do prostokata 2? " + prostokat1.czyPrzylegaDo(prostokat2)); // true
        System.out.println("Czy prostokat 1 przylega do prostokata 3? " + prostokat1.czyPrzylegaDo(prostokat3)); // true
        System.out.println("Czy prostokat 1 przylega do prostokata 4? " + prostokat1.czyPrzylegaDo(prostokat4)); // false
    }
}