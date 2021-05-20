package design;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * https://leetcode.com/problems/design-snake-game/
 * Design a Snake game that is played on a device with screen size height x width. Play the game online if you are not familiar with the game.
 *
 * The snake is initially positioned at the top left corner (0, 0) with a length of 1 unit.
 *
 * You are given an array food where food[i] = (ri, ci) is the row and column position of a piece of food that the snake can eat. When a snake eats a piece of food, its length and the game's score both increase by 1.
 *
 * Each piece of food appears one by one on the screen, meaning the second piece of food will not appear until the snake eats the first piece of food.
 *
 * When a piece of food appears on the screen, it is guaranteed that it will not appear on a block occupied by the snake.
 *
 * The game is over if the snake goes out of bounds (hits a wall) or if its head occupies a space that its body occupies after moving (i.e. a snake of length 4 cannot run into itself).
 *
 * Implement the SnakeGame class:
 *
 * SnakeGame(int width, int height, int[][] food) Initializes the object with a screen of size height x width and the positions of the food.
 * int move(String direction) Returns the score of the game after applying one direction move by the snake. If the game is over, return -1.
 *
 *
 * Example 1:
 *
 *
 * Input
 * ["SnakeGame", "move", "move", "move", "move", "move", "move"]
 * [[3, 2, [[1, 2], [0, 1]]], ["R"], ["D"], ["R"], ["U"], ["L"], ["U"]]
 * Output
 * [null, 0, 0, 1, 1, 2, -1]
 *
 * Explanation
 * SnakeGame snakeGame = new SnakeGame(3, 2, [[1, 2], [0, 1]]);
 * snakeGame.move("R"); // return 0
 * snakeGame.move("D"); // return 0
 * snakeGame.move("R"); // return 1, snake eats the first piece of food. The second piece of food appears
 *                      // at (0, 1).
 * snakeGame.move("U"); // return 1
 * snakeGame.move("L"); // return 2, snake eats the second food. No more food appears.
 * snakeGame.move("U"); // return -1, game over because snake collides with border
 */
public class DesignSnakeGame {
    int height;
    int width;
    int[][] food;
    int pts = 0;
    int foodCtr;
    LinkedList<int[]> queue = new LinkedList<>();
    Set<String> set = new HashSet<>();
    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public DesignSnakeGame(int width, int height, int[][] food) {
        this.height = height;
        this.width = width;
        this.food = food;
        queue.add(new int[]{0, 0});
        set.add("00");
    }

    /** Moves the snake.
     @param dir - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String dir) {
        int[] head = queue.peek();
        int[] newHead = new int[] {head[0], head[1]};
        //System.out.println(Arrays.toString(head));
        if ("L".equals(dir)) {
            newHead[1] = head[1] - 1;
        } else if ("R".equals(dir)) {
            newHead[1] = head[1] + 1;
        } else if ("U".equals(dir)) {
            newHead[0] = head[0] - 1;
        } else if ("D".equals(dir)) {
            newHead[0] = head[0] + 1;
        }
        if (newHead[0] < 0 || newHead[0] >= height || newHead[1] < 0 || newHead[1] >= width ) {
            return -1;
        }
        if (set.contains(newHead[0]+""+newHead[1])) {
            int[] tail = queue.peekLast();
            if (!((newHead[0] +""+newHead[1]).equals(tail[0]+""+tail[1]))) {
                return -1;
            }
        }
        if (foodCtr < food.length && food[foodCtr][0] == newHead[0] && food[foodCtr][1] == newHead[1]) {
            pts++;
            foodCtr++;
        } else {
            int[] tail = queue.pollLast();
            set.remove(tail[0]+""+tail[1]);
        }
        queue.offerFirst(newHead);
        set.add(newHead[0]+""+newHead[1]);
        return pts;
    }

    public static void main(String[] args) {
        test1();
        //test2();
    }

    private static void test1() {
        DesignSnakeGame snake = new DesignSnakeGame(3, 3, new int[][]{{2,0}, {0,0}, {0,2},{2,2}});
        System.out.println(snake.move("D"));
        System.out.println(snake.move("D"));
        System.out.println(snake.move("R"));
        System.out.println(snake.move("U"));
        System.out.println(snake.move("U"));
        System.out.println(snake.move("L"));
        System.out.println(snake.move("D"));
        System.out.println(snake.move("R"));
        System.out.println(snake.move("R"));
        System.out.println(snake.move("U"));
        System.out.println(snake.move("L"));
        System.out.println(snake.move("D"));
    }

    private static void test2() {
        DesignSnakeGame snake = new DesignSnakeGame(3, 2, new int[][]{{1,2}, {0,1}, {0,0},{1,0}});
        System.out.println(snake.move("R"));
        System.out.println(snake.move("D"));
        System.out.println(snake.move("R"));
        System.out.println(snake.move("U"));
        System.out.println(snake.move("L"));
        System.out.println(snake.move("L"));
        System.out.println(snake.move("D"));
        System.out.println(snake.move("R"));
        System.out.println(snake.move("U"));
    }
}
