public class AplicacionMascota {

    public static void main(String[] args) {

        Mascota michi = new Mascota("Michi", "mixta", "calico", "gato", 3, 2.05);

        Mascota miu = new Mascota("Miu", "persa combinada", "cafe claro", "gato", 8, 4.5);

        System.out.println("Nombre gatita 1:"+michi.getNombre());

        String nombreGatita1 = michi.getNombre();

        System.out.println("Raza gatita 2:"+miu.getRaza());

        //NO miu.nombre = "Miusita";

        miu.setNombre("Miusita"); //editar el nombre

        michi.setEdad(4); //editar la edad

        System.out.println("Edad de michi:"+michi.getEdad());

    }

}