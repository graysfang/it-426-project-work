package calculator;

/**
 * @author Nicholas Perez
 * @version 1.0
 *
 * 10/12/2017
 * This file hold the main logic for running calculations from the UI.
 */


/**
 * This class hold the main logic for running calculations from the UI.
 */
public class Calculator
{
    private static final int MIN_EQUATION_PARTS = 2;

    /**
     * This class handles the post parse string and uses a switch to manage the operator
     * @param value is the incoming String value to be parsed and later solved.
     * @return the calculated string to be displayed in the ui class.
     */
    public static String calculate(String value)
    {
        //parses the in coming value and returns an array of parts
        String[] equation = parseEquation(value);

        String result;

        switch (equation[0])
        {
            case "+":
                result = Integer.toString(Integer.parseInt(equation[1])+Integer.parseInt(equation[2]));
                break;
            case "-":
                result = Integer.toString(Integer.parseInt(equation[1])-Integer.parseInt(equation[2]));
                break;
            case "/":
                result = Integer.toString(Integer.parseInt(equation[1])/Integer.parseInt(equation[2]));
                break;
            case "*":
                result = Integer.toString(Integer.parseInt(equation[1])*Integer.parseInt(equation[2]));
                break;
            default:
                result = equation[0];
                break;
        }
        return result;
    }

    //helper class to parse the string and hand back to calculate
    private static String[] parseEquation(String value)
    {
        String[] equationParts = new String[3];
        String operator =  value.replaceAll("[0-9]+", "");

        //checks if the operator is 1
        if(operator.length() > 0 && operator.length() <= 1 )
        {

            String[] numbers = value.split("\\"+operator);

            //checks if there was a number to start
            if (numbers[0].equals(""))
            {
                numbers[0] = numbers[1];
                return numbers;
            }

            //checks of there is enough numbers to do math
            if (numbers.length < MIN_EQUATION_PARTS)
            {
                equationParts[0] = value;
                return equationParts;
            }
            equationParts[0] = operator;
            equationParts[1] = numbers[0];
            equationParts[2] = numbers[1];
        }
        //if there are to many operators
        else
        {
            if (operator.length() > 1)
            {
                equationParts[0] = value.substring(0,2);
            }
            else
            {
                equationParts[0] = value;
            }
        }
        return equationParts;
    }

    //failed attempt at getting an active total label to work .. will try again at a later date
    public static String activeTotal(String currentInput)
    {
        String fromCalc = "";

        String[] fromParse = parseEquation(currentInput);

        if (fromParse.length == 3)
        {
            fromCalc = calculate(currentInput);
        }

        return fromCalc;
    }

}
