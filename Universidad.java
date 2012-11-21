package servicio;
import java.util.*;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService (targetNamespace ="http://service", name="universidad")
public class Universidad {

  

  private static ProfesorService profesor;
  private static GrupoService grupo;

  @WebMethod (action="urn:findProfesor", operationName="findProfesor")
  public ProfesorDTO findProfesor(@WebParam (partName = "profesorId") String profesorId) {
    checkProfesor();
    return profesor.find(profesorId);
  }

  @WebMethod (action="urn:findAllProfesor", operationName="findAllProfesor")
  public List<ProfesorDTO> findAllProfesor() {
    checkProfesor();
    return profesor.findAll();
  }
  
  
  @WebMethod (action="urn:updateProfesor", operationName="updateProfesor")
  public ProfesorDTO updateProfesor(@WebParam (partName = "Cedula") String Cedula,@WebParam (partName = "Area") String Area,@WebParam (partName = "Nombre") String Nombre,@WebParam (partName = "Titulo") String Titulo,@WebParam (partName = "Correo") String Correo,@WebParam (partName = "Telefono") String Telefono) {
    checkProfesor();
    return profesor.update(Cedula,Area,Nombre,Titulo,Correo,Telefono);
  }
  @WebMethod (action="urn:addProfesor", operationName="addProfesor")
  public ProfesorDTO addProfesor(@WebParam (partName = "Cedula") String Cedula,@WebParam (partName = "Area") String Area,@WebParam (partName = "Nombre") String Nombre,@WebParam (partName = "Titulo") String Titulo,@WebParam (partName = "Correo") String Correo,@WebParam (partName = "Telefono") String Telefono) {
    checkProfesor();
    return profesor.create(Cedula,Area,Nombre,Titulo,Correo,Telefono);
  }
  @WebMethod (action="urn:deleteProfesor", operationName="deleteProfesor")
  public ProfesorDTO deleteProfesor(@WebParam (partName = "profesorId") String profesorId) {
    checkProfesor();
    return profesor.delete(profesorId);
  }


  
  
  @WebMethod (action="urn:findGrupo", operationName="findGrupo")
  public GrupoDTO findGrupo(@WebParam (partName = "grupoId") String grupoId) {
    checkGrupo();
    return grupo.find(grupoId);
  }

  @WebMethod (action="urn:findAllGrupo", operationName="findAllGrupo")
  public List<GrupoDTO> findAllGrupo() {
    checkGrupo();
    return grupo.findAll();
  }


  @WebMethod (action="urn:updateGrupo", operationName="updateGrupo")
  public GrupoDTO updateGrupo(@WebParam (partName = "id") String id,@WebParam (partName = "numero") String numero,@WebParam (partName = "sigla") String sigla,@WebParam (partName = "nombre") String nombre,@WebParam (partName = "horario") String horario,@WebParam (partName = "aula") String aula,@WebParam (partName = "id_profesor") String id_profesor)
  {
    checkGrupo();
    return grupo.update(id,numero,sigla,nombre,horario,aula,id_profesor);
  }
  @WebMethod (action="urn:addGrupo", operationName="addGrupo")
  public GrupoDTO addGrupo(@WebParam (partName = "id") String id,@WebParam (partName = "numero") String numero,@WebParam (partName = "sigla") String sigla,@WebParam (partName = "nombre") String nombre,@WebParam (partName = "horario") String horario,@WebParam (partName = "aula") String aula,@WebParam (partName = "id_profesor") String id_profesor)
  {
    checkGrupo();
    return grupo.create(id,numero,sigla,nombre,horario,aula,id_profesor);
  }
  @WebMethod (action="urn:deleteGrupo", operationName="deleteGrupo")
  public GrupoDTO deleteGrupo(@WebParam (partName = "grupoId") String grupoId) {
    checkGrupo();
    return grupo.delete(grupoId);
  }




  private void checkProfesor() {
    if (profesor == null)
      profesor = new ProfesorService();
  }
  private void checkGrupo() {
    if (grupo == null)
      grupo = new GrupoService();
  }
}