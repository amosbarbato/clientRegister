package projectCrud.method;

import javax.swing.*;

public class Util {

    public static boolean isValid(String option) {
        return "1".equals(option)
                || "2".equals(option)
                || "3".equals(option)
                || "4".equals(option)
                | "5".equals(option);
    }

    public static void exit() {
        JOptionPane.showMessageDialog(
                null,
                "Obrigado por utilizar nosso programa. Até logo!");
    }
}
