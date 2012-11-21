package servicio;
import java.util.*;

public class ProfesorService {

  private static Map<String,ProfesorDTO> profesores;

  private static String[][] data = {
    {"101110111","Estadistica","Carlos Perez","Licenciado","carlos@xyz.com","3456-7890"},
    {"202220222","Matematica","Luis Torres","Master","luis@xyz.com","6677-3456"},
    {"303330333","Administracion","Juan Castro","Licenciado","castro@xyz.com","67455-7788"},
    {"404440444","Quimica","Joaquin Soto","Ingeniero","joaquin@xyz.com","3333-7890"}};

  ProfesorService() {
    profesores = new HashMap<String,ProfesorDTO>();
    for (int i=0;i<data.length;i++) {
      ProfesorDTO prof = new ProfesorDTO();
      prof.setCedula(data[i][0]);
      prof.setArea(data[i][1]);
      prof.setNombre(data[i][2]);
      prof.setTitulo(data[i][3]);
      prof.setCorreo(data[i][4]);
      prof.setTelefono(data[i][5]);
      profesores.put(prof.getCedula(),prof);
    }
  }


protected ProfesorDTO create(String Cedula,String Area,String Nombre,String Titulo,String Correo,String Telefono) {
      ProfesorDTO prof = new ProfesorDTO();
      prof.setCedula(Cedula);
      prof.setArea(Area);
      prof.setNombre(Nombre);
      prof.setTitulo(Titulo);
      prof.setCorreo(Correo);
      prof.setTelefono(Telefono);
      profesores.put(prof.getCedula(),prof);
      return prof;
}

protected ProfesorDTO update(String Cedula,String Area,String Nombre,String Titulo,String Correo,String Telefono) {
      ProfesorDTO prof = (ProfesorDTO)profesores.remove(Cedula);
      //prof.setCedula(Cedula);
      prof.setArea(Area);
      prof.setNombre(Nombre);
      prof.setTitulo(Titulo);
      prof.setCorreo(Correo);
      prof.setTelefono(Telefono);
      profesores.put(prof.getCedula(),prof);
      return prof;
}

protected ProfesorDTO delete(String Cedula) {
      return profesores.remove(Cedula);
}

protected ProfesorDTO find(String profesorID) {
    if (profesores.containsKey(profesorID))
      return (ProfesorDTO)profesores.get(profesorID);
    else
      return null;
  }

  protected List<ProfesorDTO> findAll() {
    List resultado = new ArrayList();
    for(Iterator<String> it = profesores.keySet().iterator();it.hasNext();) {
      String key = it.next();
      resultado.add(profesores.get(key));
    }
    return resultado;
  }
}