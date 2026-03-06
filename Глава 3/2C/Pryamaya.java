class Pryamaya {
    double k;
    double b;

    Pryamaya(double k, double b) {
        this.k = k;
        this.b = b;
    }

    boolean isParallel(Pryamaya other) {
        return this.k == other.k;
    }

    double crossX() {
        if (k == 0) {
            return Double.NaN; // параллельна оси X
        }
        return -b / k;
    }

    double crossY() {
        return b;
    }

    void printCross() {
        double x = crossX();
        double y = crossY();

        if (Double.isNaN(x)) {
            System.out.println("  С осью X: нет (параллельна)");
        } else {
            System.out.println("  С осью X: (" + x + "; 0)");
        }

        System.out.println("  С осью Y: (0; " + y + ")");
    }

    String findCross(Pryamaya other) {
        if (this.isParallel(other)) {
            return "Прямые параллельны";
        }

        double x = (other.b - this.b) / (this.k - other.k);
        double y = this.k * x + this.b;

        return "(" + x + "; " + y + ")";
    }

    public String toString() {
        if (b > 0) {
            return "y = " + k + "x + " + b;
        } else if (b < 0) {
            return "y = " + k + "x - " + (-b);
        } else {
            return "y = " + k + "x";
        }
    }
}