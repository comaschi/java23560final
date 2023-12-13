/*
 netstat -aon |find /i "listening" |find "8080"
 taskkill /F /PID 23488

 */
package entities;

import com.codoacodo.modelo.Orador;
import com.codoacodo.modeloDAO.OradorDAO;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 *
 * @author LocalUser
 */
public class OradorTest {

    static Logger logger = LoggerFactory.getLogger(OradorTest.class);

    public static void main(String[] args) {

        Orador orador = new Orador();
        OradorDAO oradorDAO = new OradorDAO();
        List<Orador> oradores = new ArrayList();

        //Creo un orador para insertarlo a la db
//        Orador oraUno = new Orador("Julio", "Iglesias", "jiglesias@mail.com", "Como cantar en un avión a 2000 metros de altura", "imagen1");
//        oradorDAO.crearOrador(oraUno);
//        oradorDAO.crearOrador(oraUno);
//        oradorDAO.crearOrador(oraUno);
//        oradorDAO.crearOrador(oraUno);
//        oradorDAO.crearOrador(oraUno);

        oradores = oradorDAO.listarOradores();

        for (Orador ora : oradores) {
            System.out.println(ora.toString());
            logger.info("----------------------");
            logger.info(ora.toString());
        }
    }
}
