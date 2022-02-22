package testEjercicio1;

import ejercicio1.Beca;
import ejercicio1.Helpers;
import ejercicio1.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class BecaTest {
    Utils mock = Mockito.mock(Utils.class);
    MockedStatic<Helpers> helpersStatic= Mockito.mockStatic(Helpers.class);

    @ParameterizedTest
    @CsvSource({
            "1234567,SI APLICA A BECA",
            "7654321,NO APLICA A BECA POR PROMEDIO ACADEMICO",
            "1928374,EL ESTUDIANTE NO CURSO AUN EL 60% DE LAS MATERIAS",
    })
    public void recomendacionBecaTest(int ci, String expectedResult) {
        Mockito.when(mock.getNota(1234567)).thenReturn(91);
        Mockito.when(mock.getNota(7654321)).thenReturn(89);
        Mockito.when(mock.getNota(3333333)).thenReturn(95);

        helpersStatic.when(() -> Helpers.applicaBeca(1234567)).thenReturn(true);
        helpersStatic.when(() -> Helpers.applicaBeca(7654321)).thenReturn(true);
        helpersStatic.when(() -> Helpers.applicaBeca(1928374)).thenReturn(false);

        Beca beca = new Beca(mock);
        String actualResult = beca.recomendacionBeca(ci);
        Assertions.assertEquals(expectedResult, actualResult, "ERROR");

        helpersStatic.close();
    }
}
