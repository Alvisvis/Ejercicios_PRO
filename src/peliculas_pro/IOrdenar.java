package peliculas_pro;

import java.util.Comparator;

/**
 *
 * @author mgb
 */
public interface IOrdenar
{

    void ordenarLista(Comparator criterio);

    void cargarFichero(String nombreFichero);
}
