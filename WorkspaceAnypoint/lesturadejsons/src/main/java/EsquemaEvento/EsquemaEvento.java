package EsquemaEvento;

import java.util.ArrayList;

import propiedades.Propiedad;

public class EsquemaEvento extends Esquema {
	
    private String nombreEvento;

    private ArrayList<String> eventosHeredados;

    private ArrayList<Propiedad> propiedades;

    private String finalTimeStamp;

    private String inicioTimeStamp;

    private ArrayList<String> eventosCopiados;

    public String getNombreEvento ()
    {
        return nombreEvento;
    }

    public void setNombreEvento (String nombreEvento)
    {
        this.nombreEvento = nombreEvento;
    }

    public ArrayList<String> getEventosHeredados ()
    {
        return eventosHeredados;
    }

    public void setEventosHeredados (ArrayList<String> eventosHeredados)
    {
        this.eventosHeredados = eventosHeredados;
    }

    public ArrayList<Propiedad> getPropiedades ()
    {
        return propiedades;
    }

    public void setPropiedades (ArrayList<Propiedad> propiedades)
    {
        this.propiedades = propiedades;
    }

    public String getFinalTimeStamp ()
    {
        return finalTimeStamp;
    }

    public void setFinalTimeStamp (String finalTimeStamp)
    {
        this.finalTimeStamp = finalTimeStamp;
    }

    public String getInicioTimeStamp ()
    {
        return inicioTimeStamp;
    }

    public void setInicioTimeStamp (String inicioTimeStamp)
    {
        this.inicioTimeStamp = inicioTimeStamp;
    }

    public ArrayList<String> getEventosCopiados ()
    {
        return eventosCopiados;
    }

    public void setEventosCopiados (ArrayList<String> eventosCopiados)
    {
        this.eventosCopiados = eventosCopiados;
    }

    @Override
    public String toString()
    {
        return "EsquemaEvento [nombreEvento = "+nombreEvento+", eventosHeredados = "+eventosHeredados+", propiedades = "+propiedades+", finalTimeStamp = "+finalTimeStamp+", inicioTimeStamp = "+inicioTimeStamp+", eventosCopiados = "+eventosCopiados+"]";
    }
}
