package U1_Multiproceso;


import U1_Multiproceso._01_LanzaProcesos.LanzaProcesos;

import java.util.logging.Logger;

public class uso_de_logger {
    private static final Logger logger = Logger.getLogger(uso_de_logger.class.getName());

    public static void main(String[] args) {

        logger.info("Este es un mensaje de información");
        logger.warning("Este es un mensaje de aviso");
        logger.severe("Este es un mensaje de error");
    }
}
