import java.util.Scanner;
public class HelloWorld {
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);
    //Ask the user for their package type
    System.out.println("Which package do you have? ");
    String packageType = input.nextLine();
    packageType = packageType.toLowerCase();
    //Ask the user for how data they used
    System.out.println("How much data did you use? ");
    double data_used = input.nextDouble();

    double price = 0;
    double data_limit = 0;
    double price_extra = 0;
    boolean couponApplied = false;
    
    //Details if package is purple
    if(packageType.equalsIgnoreCase("purple")){
      price = 99.95;
    }

    //Details if package is blue
    else if(packageType.equalsIgnoreCase("blue")){
      price = 70;
      data_limit = 4;
      price_extra = 10;
    }


    //Details if package is green
    else if(packageType.equalsIgnoreCase("green")){
      System.out.println("Do you have a coupon? ");
      String coupon = input.next();
      coupon = coupon.toLowerCase();
      if(coupon.equalsIgnoreCase("yes")){
        couponApplied = true;
      }
      else if(coupon.equalsIgnoreCase("no")){
        couponApplied = false;
      }
      else{
        System.out.println("invalid choice");
      }
      price = 49.99;
      data_limit = 2;
      price_extra = 15;
    } else{
      System.out.println("Invalid package name");
    }
    //Calculate the total price
    boolean valid = true;
    
    if (valid){
      if(data_used > data_limit){
        price += (data_used - data_limit) * price_extra;
      }
       if (packageType.equalsIgnoreCase("green") && couponApplied && price >= 75){
         price -= 20;
       }
    System.out.println("You owe $" + String.format("%.2f", price));
    }
  }
}
