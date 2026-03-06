import java.util.Objects;

class Koleso {
    private String proizvoditel;
    private int radius;

    public Koleso(String proizvoditel, int radius) {
        this.proizvoditel = proizvoditel;
        this.radius = radius;
    }

    public String getProizvoditel() {
        return proizvoditel;
    }

    public int getRadius() {
        return radius;
    }

    public void setProizvoditel(String proizvoditel) {
        this.proizvoditel = proizvoditel;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Колесо{" +
                "производитель='" + proizvoditel + '\'' +
                ", радиус=" + radius +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Koleso koleso = (Koleso) obj;
        return radius == koleso.radius &&
                Objects.equals(proizvoditel, koleso.proizvoditel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(proizvoditel, radius);
    }
}