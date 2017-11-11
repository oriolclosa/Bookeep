package presentacio;

import domini.ControladorDomini;

/**
 * Created by oriolclosa on 11/11/17.
 */

public class ControladorPresentacio {
    private ControladorDomini ctrlDomini;

    public ControladorPresentacio(){
        ctrlDomini = new ControladorDomini(this);
    }
}
