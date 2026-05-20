public class HabitacioFosca extends Habitacio {
    private boolean iluminada;

    public HabitacioFosca(String nom, String descripcio) {
        super(nom, descripcio);
        this.iluminada = false;
    }

    public String iluminarHabitacio(Jugador jugador) {
        if (jugador.getItemInventari("Llanterna")) {
            iluminada = true;
            return "Encens la llanterna i la foscor desapareix.\n" + super.toString();
        } else {
            return "No pots veure res. Et falta una llanterna.\nSortides visibles: cap";
        }
    }

    @Override
    public String toString() {
        if (!iluminada) {
            return "Estàs en una habitació completament fosca. No es veu res.";
        }
        return super.toString();
    }

    @Override
    public Item getItem() {
        if (!iluminada) {
            return null;
        }
        return super.getItem();
    }
}
