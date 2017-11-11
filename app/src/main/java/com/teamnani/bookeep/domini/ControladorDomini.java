package com.teamnani.bookeep.domini;

import com.teamnani.bookeep.dades.ControladorDades;
import com.teamnani.bookeep.presentacio.ControladorPresentacio;

/**
 * Created by oriolclosa on 11/11/17.
 */

public class ControladorDomini {
    private ControladorPresentacio ctrlPresentacio;
    private ControladorDades ctrlDades;

    public ControladorDomini(ControladorPresentacio pCtrlPresentacio){
        ctrlPresentacio = pCtrlPresentacio;
        ctrlDades = new ControladorDades(this);
    }
}
