/**
 * Created by ilyes on 23/11/15.
 */
public class Others {

    public static boolean isMatriceColumnsNumbersEqual(int[][] matrice) throws Exception {
        // init with first row columns number
        int columnNumber = matrice[0].length;

        // testing if all the columns are equal
        for (int i = 0; i < matrice[i].length; i++) {

            if (matrice[i].length != columnNumber) {
                throw new Exception("Columns numbers are different");
            }
        }
        return true;

    }

    public static boolean isRowsNumberEqualToColumnsNumber(char[] array, int[][] matrice) throws Exception {
        if (array.length == matrice[0].length) {
            return true;
        }
        throw new Exception("Alphabet number is different form the state number");
    }

}
