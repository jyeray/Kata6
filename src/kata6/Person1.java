package kata6;

public class Person1 {
    private final Integer id;
    private final String name;
    private final String genero;
    private final String fechaNacimiento;
    private final float peso;
    private final String mail;

    public Person1(Integer id, String name, String genero, String fechaNacimiento, float peso, String mail) {
        this.id = id;
        this.name = name;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.peso = peso;
        this.mail = mail;
    }

    public String getGenero() {
        return genero;
    }

    public String getName() {
        return name;
    }

    public float getPeso() {
        return peso;
    }

    public String getMail() {
        return mail;
    }

}
