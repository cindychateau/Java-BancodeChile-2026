public class Mascota {

    //public: CUALQUIER archivo puede acceder
    //private: Solamente el archivo actual puede acceder
    //protected: Solamente el archivo y sus derivados pueden acceder
    private String nombre;
    private String raza;
    private String color;
    private String especie;
    private int edad;
    private double peso;

    //Método Constructor
    //this = miu
    //nombre = "Miu"
    //raza = "persa combinada"
    //color = "cafe claro"
    //especie = "gato"
    //edad = 8
    //peso = 4.5
    public Mascota(String nombre, String raza, String color, String especie, int edad, double peso) {
        this.nombre = nombre; //miu.nombre = "Miu"
        this.raza = raza; //miu.raza = c
        this.color = color; //miu.color = "cafe claro"
        this.especie = especie; //miu.especie = "gato"
        this.edad = edad; //miu.edad = 8
        this.peso = peso; //miu.peso = 4.5
    }


    //Getters y Setters

    //Métodos Getters: Regresar el valor de un atributo de mi objeto. 1 método por cada atributo
    //this = michi 
    public String getNombre() {
        return this.nombre; //regresa michi.nombre. "Michi"
    }

    //this = miu
    public String getRaza(){
        return this.raza; //regresa miu.raza. "persa combinado"
    }

    public String getColor() {
        return this.color;
    }

    public String getEspecie() {
        return this.especie;
    }

    public int getEdad() {
        return this.edad;
    }

    public double getPeso() {
        return this.peso;
    }

    //Método Setters: Establece un nuevo valor para el atributo de mi objeto. Un setter por cada atributo. SIEMPRE SON VOID, y siempre reciben el nuevo valor
    //this = miu
    //nombre = "Miusita"
    public void setNombre(String nuevoNombre) {
        this.nombre = nuevoNombre; //miu.nombre = "Miusita"
    }

    public void setRaza(String nuevaRaza) {
        this.raza = nuevaRaza;
    }

    public void setColor(String nuevoColor) {
        this.color = nuevoColor;
    }

    public void setEspecie(String nuevaEspecie) {
        this.especie = nuevaEspecie;
    }

    //this = michi
    public void setEdad(int nuevaEdad) { //nuevaEdad = 4
        this.edad = nuevaEdad; //michi.edad = 4
    }

    public void setPeso(double nuevoPeso) {
        this.peso = nuevoPeso;
    }

    public void maullar() {
        System.out.println(this.nombre+" hace miau!");
    }

}