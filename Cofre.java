import java.util.ArrayList;

public class Cofre {
    private ArrayList<Item> items;
    private boolean obert;
    private boolean illuminat;

    public Cofre() {
        items = new ArrayList<>();
        obert = false;
        illuminat = false;
    }

    public void afegirItem(Item item) {
        items.add(item);
    }

    public String obrir() {
        if (!illuminat) {
            return "El cofre està a les fosques, no pots veure'l bé.";
        }
        obert = true;
        return items.isEmpty() ? "El cofre és buit." : "Contingut: " + items;
    }

    public Item agafarItem(String nom) {
        if (!obert) return null;
        if (!illuminat) return null;

        for (Item item : items) {
            if (item.getNom().equalsIgnoreCase(nom)) {
                items.remove(item);
                return item;
            }
        }
        return null;
    }

    public boolean isObert() {
        return obert;
    }

    public boolean isIlluminat() {
        return illuminat;
    }

    public void illuminar() {
        if (!illuminat) {
            illuminat = true;
            System.out.println("Has il·luminat el cofre amb la llanterna!");
        }
    }

    public void utilitzarItem(Item item) {
        if (item.getNom().equalsIgnoreCase("Llanterna")) {
            illuminar();
        } else {
            System.out.println("No pots utilitzar " + item.getNom() + " al cofre.");
        }
    }

    @Override
    public String toString() {
        if (!illuminat) {
            return "Hi ha un cofre a les fosques, no es veu res.";
        }
        if (!obert) {
            return "Cofre visible. Contingut amagat (tancat).";
        }
        return obert ? "Cofre il·luminat i obert. Contingut: " + items : "Cofre il·luminat i tancat.";
    }
}
