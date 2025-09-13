public class Car {
    private String make;
    private String model;
    private int year;

    // Constructor with input validation
    public Car(String make, String model, int year) {
        java.util.List<String> errors = new java.util.ArrayList<>();

        // to collect all validation errors, each setter is called in a separate try-catch block

        try {
            setMake(make);
        } catch (IllegalArgumentException e) {
            errors.add(e.getMessage());
        }
        try {
            setModel(model);
        } catch (IllegalArgumentException e) {
            errors.add(e.getMessage());
        }
        try {
            setYear(year);
        } catch (IllegalArgumentException e) {
            errors.add(e.getMessage());
        }
        if (!errors.isEmpty()) {
            throw new IllegalArgumentException(String.join("\n", errors));
        }
    }

    // Getters
    public String getMake() {
        return make;
    }
    public String getModel() {
        return model;
    }
    public int getYear() {
        return year;
    }


    // Setters with input validation
    public void setMake(String make) {
        if (make == null || make.trim().isEmpty()) {
            throw new IllegalArgumentException("Make cannot be null or empty.");
        }
        this.make = make;
    }
    public void setModel(String model) {
        if (model == null || model.trim().isEmpty()) {
            throw new IllegalArgumentException("Model cannot be null or empty.");
        }
        this.model = model;
    }
    public void setYear(int year) {
        if (year < 1886 || year > java.time.Year.now().getValue()) { // First car invented in 1886
            throw new IllegalArgumentException("Year must be between 1886 and current year.");
        }
        this.year = year;
    }

    // Method to get car information as a string
    public String getCarInfoString() {
        return  make + " " + model + " " + year;
    }

    @Override
    public String toString() {
        return getCarInfoString();
    }

    public void displayCarInfo() {
        System.out.println(getCarInfoString());
    }
    
public static void main(String[] args) {
    java.util.Scanner scanner = new java.util.Scanner(System.in);
    while (true) {
        System.out.print("Enter car make: ");
        String make = scanner.nextLine();
        System.out.print("Enter car model: ");
        String model = scanner.nextLine();
        System.out.print("Enter car year: ");
        String yearInput = scanner.nextLine();

        try {
            int year = Integer.parseInt(yearInput);
            Car car = new Car(make, model, year);
            System.out.println("Car created: " + car);
            break;
        } catch (NumberFormatException e) {
            System.out.println("Error: Year must be a valid integer.\nPlease try again.\n");
            continue;
        } catch (IllegalArgumentException e) {
            String errorString = e.getMessage();
            String[] errorArray = errorString.split("\n");
            System.out.println("Error(s):");
            for (String error : errorArray) {
                System.out.println("- " + error);
            }
            System.out.println("Please try again.\n");
            continue;
        }


        //break;
    }
    scanner.close();
}
}