package modulos;

public class Sala {

    private int layout[][];
    private String id_sala;
    private String id_cine;

    public int[][] getLayout() {
        return layout;
    }

    public void setLayout(int[][] layout) {
        this.layout = layout;
    }

    public String getId_sala() {
        return id_sala;
    }

    public void setId_sala(String id_sala) {
        this.id_sala = id_sala;
    }

    public String getId_cine() {
        return id_cine;
    }

    public void setId_cine(String id_cine) {
        this.id_cine = id_cine;
    }

}
