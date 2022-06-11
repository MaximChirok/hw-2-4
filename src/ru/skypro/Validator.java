package ru.skypro;

import java.util.Objects;

public class Validator {

    private static final String VALID_SYMBOLS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890_";

    private Validator () {

    }

    public static boolean check (String login, String password, String confirmPassword) {
        try {
            validate(login, password, confirmPassword);
            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    private static void validate (String login, String password, String confirmPassword) throws WrongPasswordException, WrongLoginException {
        if (Objects.isNull(login) || login.length()>20) {
            throw new WrongLoginException("Dlina logina doljna byt <= 20");
        }
        if (!containsValidSymbols(login)) {
            throw new WrongLoginException("Login soderjit nedopustimye symvoly");
        }

        if (Objects.isNull(password) || password.length()>=20 ||
                Objects.isNull(confirmPassword) || confirmPassword.length()>=20) {
            throw new WrongPasswordException("Dlina parola doljna byt < 20");
        }
        if (!containsValidSymbols(password)) {
            throw new WrongPasswordException("Parol soderjit nekorrektnye simvoly");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Paroli doljny sovpadat");
        }

    }


    private static boolean containsValidSymbols (String s) {
        char[] symbols = s.toCharArray();
        for (char symbol : symbols) {
            if (!VALID_SYMBOLS.contains(String.valueOf(symbol))) {
                return false;
            }
        }
        return true;
    }

}
