import javax.sound.midi.Soundbank;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class CarInfo {

    private String CarName;
    private String CarNumber;
    private Double RentPrice;
    private int TotalCars;

    public String getCarName() {
        return CarName;
    }

    public void setCarName(String carName) {
        CarName = carName;
    }

    public String getCarNumber() {
        return CarNumber;
    }

    public void setCarNumber(String carNumber) {
        CarNumber = carNumber;
    }

    public Double getRentPrice() {
        return RentPrice;
    }

    public void setRentPrice(Double rentPrice) {
        RentPrice = rentPrice;
    }

    public int getTotalCars() {
        return TotalCars;
    }

    public void setTotalCars(int totalCars) {
        TotalCars = totalCars;
    }

    @Override
    public String toString() {
        return
                "{CarName='" + CarName + '\'' +
                ", CarNumber='" + CarNumber + '\'' +
                ", RentPrice=" + RentPrice +
                ", TotalCars=" + TotalCars +
                '}';
    }
}

class BookingInfo{
    private String CarName;
    private String CarNumber;

    private String From ;

    private String to;

    private int ReturnDays;

    private Double RentPrice;

    private  String Id;

    private String  UserAddress;


    public String getCarName() {
        return CarName;
    }

    public void setCarName(String carName) {
        CarName = carName;
    }

    public String getCarNumber() {
        return CarNumber;
    }

    public void setCarNumber(String carNumber) {
        CarNumber = carNumber;
    }

    public String getFrom() {
        return From;
    }

    public void setFrom(String from) {
        From = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getReturnDays() {
        return ReturnDays;
    }

    public void setReturnDays(int returnDays) {
        ReturnDays = returnDays;
    }

    public Double getRentPrice() {
        return RentPrice;
    }

    public void setRentPrice(Double rentPrice) {
        RentPrice = rentPrice;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getUserAddress() {
        return UserAddress;
    }

    public void setUserAddress(String userAddress) {
        UserAddress = userAddress;
    }

    @Override
    public String toString() {
        return  CarName + ',' +  CarNumber + ',' + From + ','+ to + ','+ ReturnDays+','+ RentPrice + ',' +Id + ',' + UserAddress;
    }
}


class AddingAndSelecting {

    private static ArrayList<BookingInfo> BookingInformation = new ArrayList<>();
   private static ArrayList<CarInfo> AddingCars = new ArrayList<>();
    public static void CarInfoFunc() {
        try {
            File f = new File("C:\\New folder\\carinfo.txt");
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String SplitArr[] = line.split(",");
                CarInfo obj = new CarInfo();
                obj.setCarName(SplitArr[0]);
                obj.setCarNumber(SplitArr[1]);
                obj.setRentPrice(Double.valueOf(SplitArr[2]));
                obj.setTotalCars(Integer.valueOf(SplitArr[3]));
                AddingCars.add(obj);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        for (CarInfo info:AddingCars) {
            System.out.println(info);
        }

        System.out.print("\n\n");

    }


    public static void MakeBooking() {
        Scanner Sc = new Scanner(System.in);
        AddingCars.clear();
        CarInfoFunc();
        System.out.println(" Car Number ");
        String CarNum = Sc.next();


        int CheckingCArNum = 0;

        for (CarInfo loopObj : AddingCars) {
            if (CarNum.equalsIgnoreCase(loopObj.getCarNumber())) {
                CheckingCArNum = 1;

                BookingInfo obj = new BookingInfo();


                System.out.println(loopObj);
                obj.setCarName(loopObj.getCarName());
                obj.setCarNumber(loopObj.getCarNumber());

                System.out.println(" Enter Return Days ");
                int ReturnDays = Sc.nextInt();
                obj.setReturnDays(ReturnDays);

                System.out.println(" From ");
                String From = Sc.next();
                obj.setFrom(From);

                System.out.println(" To ");
                String To = Sc.next();
                obj.setTo(To);

                System.out.println(" CNIC ");
                Sc.nextLine();
                String Id = Sc.nextLine();
                obj.setId(Id);

                System.out.println("  Address ");
                String Address = Sc.nextLine();
                obj.setUserAddress(Address);

                obj.setRentPrice(loopObj.getRentPrice() * ReturnDays);

                BookingInformation.add(obj);

                System.out.println(" Booking Added Successfully " + obj);
                System.out.println("\n\n");



                try {
                    FileWriter FWrite = new FileWriter("C:\\New folder\\BookingInfo.txt", true);
                    FWrite.write(obj.toString() + "\n");
                    FWrite.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        }

        if (CheckingCArNum == 0) {
            System.out.println(" Invalid Car Number ");
        }

    }

    public static void ShowBooking() {
        ArrayList<BookingInfo> ReadBooking = new ArrayList<>();
        try{
            File f = new File("C:\\New folder\\BookingInfo.txt");
            Scanner SObj = new Scanner(f);
            while (SObj.hasNextLine()) {
                String line = SObj.nextLine();
                String SplitArr[] = line.split(",");
                System.out.println(" Car name : " + SplitArr[0] + "\n Car Number : " +  SplitArr[1]  + "\n From : " +  SplitArr[2]  + "\n To : " +  SplitArr[3]  + "\n Return Days : " +  SplitArr[4]  + " \n Total_price :  " +  SplitArr[5] + "\n CNIC " + SplitArr[6] + "\n Address " + SplitArr[7] );
                System.out.print(" ................................... \n\n");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void DeleteBooking() {
        try {
            ArrayList<BookingInfo> Dlt = new ArrayList<>();
            Scanner Sc = new Scanner(System.in);
            File f = new File("C:\\New folder\\BookingInfo.txt");
            Scanner SObj = new Scanner(f);
            while (SObj.hasNextLine()) {
                BookingInfo b = new BookingInfo();
                String line = SObj.nextLine();
                String SplitArr[] = line.split(",");
                b.setCarName(SplitArr[0]);
                b.setCarNumber(SplitArr[1]);
                b.setFrom(SplitArr[2]);
                b.setTo(SplitArr[3]);
                b.setReturnDays(Integer.parseInt(SplitArr[4]));
                b.setRentPrice(Double.parseDouble(SplitArr[5]));
                b.setId(SplitArr[6]);
                b.setUserAddress(SplitArr[7]);

                Dlt.add(b);
            }

            for (BookingInfo d : Dlt) {
                System.out.println(d);
            }

            System.out.println(" Enter CNIC ");
            String CNIC = Sc.nextLine();
            int Book = 0;

            Iterator<BookingInfo> iterator = Dlt.iterator();
            while (iterator.hasNext()) {
                BookingInfo book = iterator.
                        next();
                if (CNIC.equalsIgnoreCase(book.getId())) {
                    System.out.println(" ID Found");
                    System.out.println(book);
                    Book = 1;
                    iterator.remove();
                }
            }

            for (BookingInfo d : Dlt) {
                System.out.println(d);
            }

            FileWriter FWrite = new FileWriter("C:\\New folder\\BookingInfo.txt");
            for (BookingInfo book : Dlt) {
                FWrite.write(book.toString() + "\n");
            }
            FWrite.close();

            if (Book == 0) {
                System.out.println(" Enter Valid CNIC ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void ShowMenu(){
        Scanner sc = new Scanner(System.in);


        do {
            System.out.println(" 1 : Display Cars ");
            System.out.println(" 2 : Make Booking ");
            System.out.println(" 3 : Display Booking ");
            System.out.println(" 4 : Delete Booking ");
            System.out.println(" 0 : For Exit ");
            System.out.println();

            int choice = sc.nextInt();
            if(choice == 1){
                AddingAndSelecting.CarInfoFunc();
            }
            if(choice == 2){
                AddingAndSelecting.MakeBooking();
            }
            if(choice == 3){
                AddingAndSelecting.ShowBooking();
            }
            if(choice == 4){
                AddingAndSelecting.DeleteBooking();
            }
            if(choice == 0) {
                break;
            }
        }while (true);


    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = "admin";
      String password = "root";
        System.out.println("         Enter Login Details        ");
        System.out.println("    Enter UserName ");
        String UserName = sc.next();
        if(UserName.equalsIgnoreCase(name)){
            System.out.println(" Enter Password ");
            String UserPassword = sc.next();
            if(UserPassword.equalsIgnoreCase(password)){
             AddingAndSelecting.ShowMenu();
            }
            else {
                System.out.println(" incorrect Password");
            }
        }
        else {
            System.out.println("Incorrect Username ");
        }
    }
}
