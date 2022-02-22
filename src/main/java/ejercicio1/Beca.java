package ejercicio1;

public class Beca {

    Utils utils;

    public Beca() {
        utils = new Utils();
    }

    public Beca(Utils utils) {
        this.utils = utils;
    }

    public String recomendacionBeca(int ci) {

        if (Helpers.applicaBeca(ci)) {
            if (utils.getNota(ci) >= 90) {
                return "SI APLICA A BECA";
            } else {
                return "NO APLICA A BECA POR PROMEDIO ACADEMICO";
            }
        } else {
            return "EL ESTUDIANTE NO CURSO AUN EL 60% DE LAS MATERIAS";
        }
    }
}
