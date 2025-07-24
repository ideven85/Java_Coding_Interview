package com.cleo.revision.visitorPattern;

//todo clean up
sealed interface Node{
    int eval();
}
record Symbol(char x){
    @Override
    public String toString() {
        return String.valueOf(x);
    }
}
record BinOp(Node left, Node right){

}
record NegNode(int node) implements Node{
    @Override
    public int eval() {
        return -node;
    }
}
interface NodeVisitor{
    Integer visit(IntNode node);
    Integer visit(SubNode left,SubNode right);
    Integer visit(AddNode left, AddNode right);
    Integer visit(MulNode left, MulNode right);
    Integer visit(DivNode left, DivNode right);
}

class Visitor implements NodeVisitor{
    @Override
    public Integer visit(IntNode node) {
        return node.eval();
    }

    @Override
    public Integer visit(SubNode left, SubNode right) {
        return left.eval() - right.eval();
    }

    @Override
    public Integer visit(AddNode left, AddNode right) {
        return left.eval()+ right.eval();
    }

    @Override
    public Integer visit(MulNode left, MulNode right) {
        return left.eval()* right.eval();
    }

    @Override
    public Integer visit(DivNode left, DivNode right) {
        return left.eval()/ right.eval();
    }
}
record IntNode(int node) implements Node{

    @Override
    public int eval() {
        return node;

    }
}
record SubNode(Node left,Node right) implements Node{

    @Override
    public int eval() {
        return left().eval()- right().eval();
    }

    @Override
    public String toString() {
        return String.valueOf(left().eval() - right().eval());
    }
}
record AddNode(Node left,Node right) implements Node{
    @Override
    public int eval() {
        return left.eval() + right().eval();

    }
}
record MulNode(Node left,Node right) implements Node{
    @Override
    public int eval() {
        return left.eval() * right().eval();
    }
}
record DivNode(Node left,Node right) implements Node{
    @Override
    public int eval() {
        return left.eval()/right().eval();
    }
}
class ClassNotFoundException extends Exception{
    public ClassNotFoundException(String message){
        System.out.println(message);
    }
}
public class EvalVisitor{

    public int eval(Node n) {
        try {
            return switch (n) {
                case IntNode(var i) -> i;
                case NegNode(var i) -> -i;
                case AddNode(Node left, Node right) -> eval(left) + eval(right);
                case MulNode(Node left, Node right) -> eval(left) * eval(right);
                case DivNode(Node left, Node right) -> eval(left) / eval(right);
                case SubNode(Node left, Node right) -> eval(left) - eval(right);


            };
        } catch (Exception e) {
            System.out.println(e);

        }
        return -1;
    }



    public static void main(String[] args) {
        EvalVisitor visitor = new EvalVisitor();
        //Add(Add(2,Sub(2,3));
        /**
         * BODMAS Bracket of (Division,Multiplication) Addition,Subtraction
         * Expression-> 2*2-3+3/2-1;
         * MulNode(x,2),
         */
        EvalVisitor x = new EvalVisitor();

        //Redo without thinking of patterns...
        int first=x.eval(new MulNode(new IntNode(2),new IntNode(2)));
        int  second  = x.eval(new MulNode(new IntNode(3),new DivNode(new IntNode(3),new IntNode(2))));
        int third = new IntNode(1).eval();

        System.out.println(first-second-third);//0


        System.out.println(visitor.eval(new AddNode(new IntNode(2), new IntNode(3))));//5
        Visitor v = new Visitor();
        //v.visit(new AddNode(new IntNode(2)),new AddNode(3))
    }

}
