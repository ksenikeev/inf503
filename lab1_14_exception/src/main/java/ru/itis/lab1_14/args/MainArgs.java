package ru.itis.lab1_14.args;

/*
    -t DARK
    WHITE

    ESC[38
    ESC[48
 */
public class MainArgs {
    public static void main(String[] args) {

        for(int i = 0; i < args.length; ++i)
            if (args[i].equals("-t")) {

            }
            System.out.println(args[0]);
    }
}
