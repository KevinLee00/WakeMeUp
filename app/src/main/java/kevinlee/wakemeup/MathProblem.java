package kevinlee.wakemeup;

import java.util.Random;

public class MathProblem {
    private int num1;
    private int num2;
    private int sum;
    private boolean isSolved;

    public MathProblem() {
        // Generate two values in the inclusive range [10,99]
        Random rand = new Random();
        num1 = rand.nextInt(90) + 10;
        num2 = rand.nextInt(90) + 10;
        sum = num1 + num2;
        isSolved = false;
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public void setSolved() {
        isSolved = true;
    }
}
