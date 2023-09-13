package Package1;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

public class Proect2 {
    public static Scanner sc = new Scanner(System.in);

    public static String slovo = random();
    public static String slovo1 = shifr();

    public static void main(String[] args) {
        System.out.println(slovo);
        System.out.println(slovo1);

        vhodVigru();


    }


    public static String random() {
        var random = new SecureRandom();
        var list = Arrays.asList("система", "город", "деньги", "машина", "возможность", "результат", "область", "группа",
                "развитие", "средство", "качество", "действие", "государство", "любовь", "взгляд", "школа", "деятельность");
        String s = list.get(random.nextInt(list.size()));
        return s;
    }

    public static String shifr() {
        String s = "";
        for (int i = 0; i < slovo.length(); i++) {
            s += "*";
        }
        return s;

    }

    public static void vhodVigru() {

        while (true) {
            System.out.println("[N]ew game or [E]xit");
            String a1 = "N";
            String a2 = "E";
            String s;

            do {
                System.out.println("Введите [N] чтобы начать игру!");
                System.out.println("Введите [E] чтобы выйти из игры!");
                s = sc.nextLine();
                if (a2.equals(s.toUpperCase())) {
                    System.out.println("Вы вышли из игры!");
                }
            } while (!a1.equals(s.toUpperCase()));
            System.out.println(slovo1);


            int z = 0;
            int k = 3; //колличество ошибок

            while (true) {

                System.out.println("Введите букву");
                s = sc.nextLine();

                char lett = s.charAt(0);
                int index = -1;
                while ((index = slovo.indexOf(s, index + 1)) != -1) {
                    char[] chars = slovo1.toCharArray();
                    chars[index] = lett;
                    slovo1 = String.valueOf(chars);
                }
                System.out.println(slovo1.toUpperCase());

                boolean isExist = slovo.indexOf(lett) != -1;

                    if (!isExist) {
                        System.out.println("Такой буквы в слове нет: " + lett);

                        if (z < k) {
                            k--;
                            System.out.println("Ошибок осталось: " + k);
                        }
                        if (z >= k) {
                            System.out.println();
                            System.out.println("Вы проиграли!");
                            System.out.println();
                            break;
                        }
                    }
                boolean i = slovo1.contains("*");
                if (i == false) {
                    System.out.println();
                    System.out.println("Вы выиграли!!!");
                    System.out.println();
                    break;
                }
            }
        }
    }
}
