package servicio;
import java.util.*;

public class GrupoService {

  private static Map<String,GrupoDTO> grupos;

  private static String[][] data = {{"1","1","ADM-001","Elementos de Administración","K,J 7:00-9:00am","A01","101110111"},
{"2","1","ECN-001","Principios de Economía","L,M 9:00-11:00am","B02","202220222"},
{"3","2","MAT-001","Matematica I","K,J 1:00-3:00pm","A02","303330333"},
{"4","1","ADM-101","Administración Avanzada","K,J 13:00-15:00am","A01","101110111"},
{"5","2","ECN-101","Economía I","K,J 9:00-11:00am","B02","202220222"},
{"6","2","MAT-102","Matematica II","K,J 14:00-16:00pm","A02","303330333"}}
;

  GrupoService() {
    grupos = new HashMap<String,GrupoDTO>();
    for (int i=0;i<data.length;i++) {
      GrupoDTO grup = new GrupoDTO();
      grup.setId(data[i][0]);
      grup.setNumero(data[i][1]);
      grup.setSigla(data[i][2]);
      grup.setNombre(data[i][3]);
      grup.setHorario(data[i][4]);
      grup.setAula(data[i][5]);
      grup.setId_profesor(data[i][6]);
      grupos.put(grup.getId(),grup);
    }
  }


protected GrupoDTO create(String id,String numero,String sigla,String nombre,String horario,String aula,String id_profesor) {
      GrupoDTO grup = new GrupoDTO();
      grup.setId(id);
      grup.setNumero(numero);
      grup.setSigla(sigla);
      grup.setNombre(nombre);
      grup.setHorario(horario);
      grup.setAula(aula);
      grup.setId_profesor(id_profesor);
      grupos.put(grup.getId(),grup);
      return grup;
}

protected GrupoDTO update(String id,String numero,String sigla,String nombre,String horario,String aula,String id_profesor) {
      GrupoDTO grup = (GrupoDTO)grupos.remove(id);
      grup.setNumero(numero);
      grup.setSigla(sigla);
      grup.setNombre(nombre);
      grup.setHorario(horario);
      grup.setAula(aula);
      grup.setId_profesor(id_profesor);
      grupos.put(grup.getId(),grup);
      return grup;
}

protected GrupoDTO delete(String id) {
      return grupos.remove(id);
}

protected GrupoDTO find(String id) {
    if (grupos.containsKey(id))
      return (GrupoDTO)grupos.get(id);
    else
      return null;
  }

  protected List<GrupoDTO> findAll() {
    List resultado = new ArrayList();
    for(Iterator<String> it = grupos.keySet().iterator();it.hasNext();) {
      String key = it.next();
      resultado.add(grupos.get(key));
    }
    return resultado;
  }