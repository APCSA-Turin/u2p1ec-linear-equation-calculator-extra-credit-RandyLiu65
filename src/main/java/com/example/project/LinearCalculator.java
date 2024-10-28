package com.example.project;
public class LinearCalculator{
    //FOR EXTRA CREDIT 
    //you should copy and paste all of your code from the LinearCalculator class
    // but NOT printInfo(). Please update it below
    private int x1;
    private int x2;
    private int y1;
    private int y2;


    //CONSTRUCTOR
    //1 constructor with 2 String parameters. Each parameter represents a coordinate. 
    //For example, "(1,2)" and "(3,4)" would be two parameter values 
    //You will have to parse the string into 4 integers, representing the 2 points.
    public  LinearCalculator(String point1, String point2){ // <--add 2 string parameters to this constructor
        
        // For point 1 finding the index of the parenthesis and the comma. Using that information to 
        // create strings that hold the x and y values
        int p1FirstPar = point1.indexOf("(");
        int p1Comma = point1.indexOf(",");
        int p1LastPar = point1.indexOf(")");
        String x1String = point1.substring(p1FirstPar + 1, p1Comma);
        String y1String = point1.substring(p1Comma + 1, p1LastPar);

        // doing the same thing for point 2
        int p2FirstPar = point2.indexOf("(");
        int p2Comma = point2.indexOf(",");
        int p2LastPar = point2.indexOf(")");
        String x2String = point2.substring(p2FirstPar + 1, p2Comma);
        String y2String = point2.substring(p2Comma + 1, p2LastPar);

        // change all the coordinate string values to integers
        x1 = Integer.parseInt(x1String);
        y1 = Integer.parseInt(y1String);
        x2 = Integer.parseInt(x2String);
        y2 = Integer.parseInt(y2String);

    }



    //METHODS
    //getters and setters for the 4 instance variables (8 methods total) 
    public int getX1(){return x1;}
    public int getY1(){return y1;}
    public int getX2(){return x2;}
    public int getY2(){return y2;}
    public void setX1(int newX1){x1 = newX1;}
    public void setY1(int newY1){y1 = newY1;}
    public void setX2(int newX2){x2 = newX2;}
    public void setY2(int newY2){y2 = newY2;}


    //distance() -> returns a double. 
    //calculates the distance between the two points to the nearest HUNDREDTH and returns the value.
    public double distance(){
        double calcX = Math.pow((getX2() - getX1()), 2);
        double calcY = Math.pow((getY2() - getY1()), 2);
        double ans = Math.sqrt(calcX + calcY);
        return roundedToHundredth(ans);
    }

    //yInt() -> returns a double.
    //calculates the y intercept of the equation and returns the value to the nearest HUNDREDTH
    //if y-int if undefined, should return -999.99
    public double yInt(){
        double negSlope = slope() * (-1);
        if (slope() == -999.99) {
            return slope();
        } else {
        return roundedToHundredth((negSlope * getX1()) + getY1());
        }
    }

    //slope() -> returns a double. 
    //calculates the slope of the equations and returns the value to the nearest HUNDREDTH
    //if slope is undefined, should return -999.99
    public double slope(){
        if (getX1() == getX2()) {
            double unD = -999.99;
            return unD;
        } else {
        double calcY = getY2() - getY1();
        double calcX = getX2() - getX1();
        double ans = calcY / calcX;
        return roundedToHundredth(ans);
        }
    }

    //equations() -> returns a String.
    //calculates the final equation in y=mx+b form and returns the string
    //if the equation has no slope, the equation should return -> "undefined"
    //HINT: You may need other custom methods to decrease the amount of code in the equations() method
    public String equation(){
        String yint = String.valueOf(yInt());
        if (slope() == -999.99) {
            return "undefined";
        } else if (slope() == 0.0) {
                return "y=" + yint;
        } else {
            if (yInt() < 0.0){
                return "y=" + slope() + "x" + yInt();
            } else {
                if (yInt() == 0.0) {
                    return "y=" + slope() + "x";
                } else {
                return "y=" + slope() + "x+" + yInt();
                }
            }
        }
    }
      //Learned how to convert double to String from https://stackoverflow.com/questions/5766318/converting-double-to-string

    //roundedToHundredth(double x)-> returns double
    //calculates the input to the nearest hundredth and returns that value
    public double roundedToHundredth(double x){  
        return (Math.round(x*100.00) / 100.00);
    }

    //You will need to concatenate to the string 
    //the results from findSymmetry() and Midpoint()
    public String printInfo(){
        String str = "The two points are: (" + /*insert var here*/getX1() + "," +/*insert var here*/getY1()  + ")";
        str += " and " + "(" + /*insert var here*/getX2() + "," + /*insert var here*/getY2() + ")";
        str += "\nThe equation of the line between these points is: " + equation();
        str += "\nThe slope of this line is: " + slope();
        str += "\nThe y-intercept of the line is: " + yInt();
        str += "\nThe distance between the two points is: " + distance();
        str += "\n" + findSymmetry();
        str += "\n" + Midpoint();
 
        return str;
    }

    //findSymmetry()-> returns a string 
    //the method should determine if there is symmetry between the two points
    // there should be  4 return statements 
    // return "Symmetric about the x-axis";
    // return "Symmetric about the y-axis";
    //return "Symmetric about the origin";
    //return "No symmetry";
    public String findSymmetry(){
        if (slope() == -999.99) {
            return "Symmetric about the x-axis";
        } else if (yInt() == 0.0) {
            if (Midpoint().equals("The midpoint of this line is: (0.0,0.0)")){
                return "Symmetric about the origin";
            }
        } else {
            if (slope() == 0.0) {
                return "Symmetric about the y-axis";
            } 
        }
        return "No symmetry";
    }


    //Midpoint()->return a string 
    //the method should calculate the midpoint between the two points
    //it should return "The midpoint of this line is: (0,0)";
    public String Midpoint(){
        double point1 = (double) (getX1() + getX2()) / 2;
        double point2 = (double) (getY1() + getY2()) / 2;
        String point1Str = String.valueOf(point1);
        String point2Str = String.valueOf(point2);
        return "The midpoint of this line is: " + "(" + point1Str + "," + point2Str + ")";
    }

}



