package ru.pflb.chess;

/**
 * Вход в поток выполнения программы. Принимает один параметр - <a href="https://ru.wikipedia.org/wiki/%D0%9D%D0%BE%D1%82%D0%B0%D1%86%D0%B8%D1%8F_%D0%A4%D0%BE%D1%80%D1%81%D0%B0%D0%B9%D1%82%D0%B0_%E2%80%94_%D0%AD%D0%B4%D0%B2%D0%B0%D1%80%D0%B4%D1%81%D0%B0">FEN</a>
 * представление доски, либо ноль, в таком случае автоматически будет установлена доска "4kr2/8/8/8/8/8/8/3RK3 w - -".
 *
 * @author <a href="mailto:8445322@gmail.com">Ivan Bonkin</a>
 */
public class Main {

    public static void main(String[] args) {
        Board board = new Board(args.length >= 1 ? args[0] : "4kr2/8/8/8/8/8/8/3RK3 w - -");
    }
}
