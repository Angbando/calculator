package com.example.calculator;

public class Calculate {
    private double oneNum;
    private double twoNum;
    private double actSelect;

    final int STRING_LENGTH = 17;

    private StringBuilder inputString = new StringBuilder();

    private State state;

    public enum State {
        ONE_NUM_INP,
        TWO_NUM_INP,
        RESULT
    }

    public Calculate() {
        state = State.ONE_NUM_INP;
    }

    public void numPress (int numId) {
        if (inputString.length() < STRING_LENGTH) {
            if (numId == R.id.button0) {
                inputString.append("0");
            } else if (numId == R.id.button1) {
                inputString.append("1");
            } else if (numId == R.id.button2) {
                inputString.append("2");
            } else if (numId == R.id.button3) {
                inputString.append("3");
            } else if (numId == R.id.button4) {
                inputString.append("4");
            } else if (numId == R.id.button5) {
                inputString.append("5");
            } else if (numId == R.id.button6) {
                inputString.append("6");
            } else if (numId == R.id.button7) {
                inputString.append("7");
            } else if (numId == R.id.button8) {
                inputString.append("8");
            } else if (numId == R.id.button9) {
                inputString.append("9");
            } else if (numId == R.id.comma) {
                inputString.append(".");
            }
        }
    }

    public void actPress (int actId) {
        if (actId == R.id.equals && state == State.TWO_NUM_INP && inputString.length() > 0) {
            twoNum = Double.parseDouble(inputString.toString());
            state = State.RESULT;
            inputString.setLength(0);
            if (actSelect == R.id.plus) {
                inputString.append(oneNum + twoNum);
            } else if (actSelect == R.id.minus) {
                inputString.append(oneNum - twoNum);
            } else if (actSelect == R.id.multiply) {
                inputString.append(oneNum * twoNum);
            } else if (actSelect == R.id.divide) {
                inputString.append(oneNum / twoNum);
            }
        } else if (inputString.length() > 0 && state == State.ONE_NUM_INP) {
            oneNum = Double.parseDouble(inputString.toString());
            state = State.TWO_NUM_INP;
            inputString.setLength(0);
            if (actId == R.id.plus) {
                actSelect = R.id.plus;
            } else if (actId == R.id.minus) {
                actSelect = R.id.minus;
            } else if (actId == R.id.multiply) {
                actSelect = R.id.multiply;
            } else if (actId == R.id.divide) {
                actSelect = R.id.divide;
            }
        } else if (actId == R.id.del) {
            inputString.setLength(0);
            state = State.ONE_NUM_INP;
        }
    }

    public String numText() {
        return inputString.toString();
    }
}
