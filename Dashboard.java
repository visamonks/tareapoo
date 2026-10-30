import java.util.ArrayList;
import java.util.Collections;

public class Dashboard {
    private ArrayList<Widget> widgets;

    public Dashboard() {
        widgets = new ArrayList<>();
    }

    public void init() {
        widgets.add(new WeatherWidget(1, "Clima Guatemala", 48, "Guatemala", 22.5));
        widgets.add(new WeatherWidget(2, "Clima Antigua", 46, "Antigua", 19.0));
        widgets.add(new ClockWidget(3, "Reloj principal", 12));
        widgets.add(new ClockWidget(4, "Reloj oficina", 10));
        widgets.add(new QuoteWidget(5, "Frase del día", 20,
                "Ten un buen día", "Daniel Villatoro"));
        widgets.add(new QuoteWidget(6, "Frase motivacional", 18,
                "Divide y vencerás", "Tiago"));
        widgets.add(new AlertWidget(7, "Alerta servidor", 16,
                "El servidor está al 90% de su capacidad", "ALTA"));
        widgets.add(new AlertWidget(8, "Alerta reunión", 14,
                "Reunión de equipo en 15 minutos", "MEDIA"));

        TaskWidget tareasHoy = new TaskWidget(9, "Pendientes de hoy", 32);
        tareasHoy.agregarTarea("Revisar correos");
        tareasHoy.agregarTarea("Subir avance al repositorio");
        tareasHoy.agregarTarea("Preparar presentación");
        widgets.add(tareasHoy);

        TaskWidget tareasSemana = new TaskWidget(10, "Pendientes de la semana", 36);
        tareasSemana.agregarTarea("Terminar el diagrama UML");
        tareasSemana.agregarTarea("Hacer pruebas del dashboard");
        widgets.add(tareasSemana);
    }

    public void agregarWidget(Widget w) {
        widgets.add(w);
    }

    public ArrayList<Widget> getWidgets() {
        return widgets;
    }

    public String listar() {
        String texto = "";
        for (Widget w : widgets) {
            String tipo = (w instanceof Interactivo) ? "Interactivo" : "Estático";
            texto += w.getId() + " | " + w.getNombre() + " | " + tipo
                    + " | " + w.getMemoriaKB() + " KB | " + w.renderizar() + "\n";
        }
        return texto;
    }

    public Widget buscarPorId(int id) {
        for (Widget w : widgets) {
            if (w.getId() == id) {
                return w;
            }
        }
        return null;
    }

    public Widget buscarPorNombre(String nombre) {
        for (Widget w : widgets) {
            if (w.getNombre().equalsIgnoreCase(nombre)) {
                return w;
            }
        }
        return null;
    }

    public boolean interactuar(int id) {
        Widget w = buscarPorId(id);
        if (w instanceof Interactivo) {
            ((Interactivo) w).interactuar();
            return true;
        }
        return false;
    }

    public void ordenarPorMemoria() {
        Collections.sort(widgets);
    }
}
