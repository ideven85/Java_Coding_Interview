package mit.reading6;

import com.google.common.base.Optional;
import javassist.NotFoundException;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.*;
import java.util.List;

public class Specifications {
    /**
     * Find a value in an array.
     * @param arr array to search, requires that val occurs exactly once
     *            in arr
     * @param val value to search for
     * @return index i such that arr[i] = val
     */
    static int find(int[] arr, int val){
        if(arr.length==0)
            return 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==val)
                return i;
        }
        return arr.length;

    }
    static String checkWinner(char[][] board,int i){


        char winner = board[i][0],tie='0';
        //Check Row
        for (int j = 1; i < board.length; i++) {
            if(board[i][j]!=winner){

                tie='t';
                break;
            }

        }
        if(tie!='t')
            return String.valueOf(winner);
        winner=board[0][i];
        //Check Column
        tie='0';
        for (int j = 1; i < board.length; i++) {
            if(board[j][i]!=winner) {

                tie='t';
                break;
            }
        }
        if(tie!='t')
            return String.valueOf(winner);

        tie='0';
      winner=board[0][0];
        for (int j = 1; j < board.length; j++) {
            if(board[j][j]!=winner){
                tie='t';
                break;
            }

        }
        if(tie!='t')
            return String.valueOf(winner);


        winner=board[0][board.length-1];
        tie='0';
        for (int j = board.length-1,cross= 0; j >=0 && cross< board.length ; j--,cross++) {
            if (board[cross][j] != winner) {
                tie='t';
                break;
            }

        }
        if(tie!='t')
            return String.valueOf(winner);

       else
           return String.valueOf(tie);
    }



    /**
     * Find the winner of a standard 3x3 tic-tac-toe game.
     * @param board   a completely-full board of 'X' or 'O', in row-major order
     * @return 'X' or 'O'
     * @throws TieException if the board is a tie
     */
    static String endGame(char[][] board) throws TieException{
        String winner="t";
        for (int i = 0; i < board.length; i++) {
           winner=checkWinner(board,i);
           if(!winner.equals("t"))
               return winner;





        }

            throw new TieException();

    }
}
class TieException extends Exception{
    public TieException(){
        super();
    }
}
class Point{
    int x,y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public Point(){

    }
    public Point(int x, int y){
        this.x= x;
        this.y = y;
    }
    @Override
    public String toString() {
        return x + " " + y;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Point))
            return false;
        obj = (Point) obj;
        return this.x == (((Point) obj).getX()) && this.y == ((Point) obj).getY();
    }
}
class BirthdayBook {
     LocalDate lookup(String name) throws NotFoundException {
        return LocalDate.of((int)(name.charAt(0)),(int)(name.charAt(0)),(int)(name.charAt(0)));
    }

    /**
     *
     * @param initial
     * @param goal
     * @return
     * @throws PathNotFoundException
     */
    public static List<Point> findPath(Point initial, Point goal) {
         List<Point> target = new ArrayList<>();

            Stack<Point> visited = new Stack<>();
            Queue<Point> current = new LinkedList<>();

            target.add(initial);
        var next = new Point(initial.x+1, initial.y+1);
        try {
            while (current.size()<6) {
                var p = current.poll();
                target.add(p);
                if (p.x > goal.x)
                   throw new PathNotFoundException("Goal x crossed");

                next = new Point(p.x + 1, p.y + 1);

                current.add(next);

            }
        }catch (PathNotFoundException pe){
            System.out.println(pe.getMessage());
        }








                return target;




    }
    public void driveRobotAround() {
        Point initial = new Point(1,2),goal = new Point(2,3);
        List<Point> path = new ArrayList<>();
        try {


            path = findPath(initial, goal); // this method throws a checked PathNotFoundException
            if(path.isEmpty())
                throw new NullPointerException();

         // more of Louis's code

        } catch (Exception e) { // Louis makes the compiler happy
            return;
        }
    }

}
class PathNotFoundException extends Exception{
    public PathNotFoundException(String message){
        super(message);
    }
}


class Main{
    static final Specifications specifications = null;
    static final String j=null;
    static String none(){
        return null;
    }
    static String computeSomething(List<String> list){
     //   System.out.println(list.get(0).toUpperCase().equals(list.get(0)));
        return null;
    }
    /**
     * @param tiles     a string of 7 uppercase letters.
     * @param crossings contains only uppercase letters, without duplicates.
     * @return a list of words where each word can be made by taking
     *         letters from tiles and at most 1 letter from crossings.
     */
    public static List<String> scrabble(String tiles, String crossings) {
        if (tiles.length() != 7) { throw new RuntimeException(); }
        return new ArrayList<>();
    }
    public static void main(String[] args) {
        String[] names = new String[]{null};
        List<Double> sizes = new ArrayList<>();
        sizes.add(null);
        System.out.println(names.length);
        System.out.println(sizes + " " + sizes.size());
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        System.out.println(specifications);
        System.out.println(j);
        System.out.println(map.get(1));
        String a = none();
        String b = null;
       // BigInteger big = new BigInteger(b);
       //File f = new File(b);
       // System.out.println(f);
     //   String temp="abc";
//        if(temp.startsWith(null))
//            System.out.println(temp);
      /*  System.out.println("hello".substring(0));
        System.out.println("abc".substring(4));*/
       // System.out.println("hello".startsWith(null));
        System.out.println("Hi");
        System.out.println(computeSomething(List.of()));
        BirthdayBook birthdays = new BirthdayBook();

        String s = null;
        try{
           // System.out.println(s.indexOf(2));

                throw new PathNotFoundException("ie");
        }catch (PathNotFoundException e){
           e.printStackTrace();
        }
        System.out.println("done");

    }
}
