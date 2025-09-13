public class Rectangle {
   private double width;
   private double height;

    public Rectangle(double width, double height) {
        java.util.List<String> errors = new java.util.ArrayList<>();
        // to collect all validation errors, each setter is called in a separate try-catch block
        try {
            setWidth(width);
        } catch (IllegalArgumentException e) {
            errors.add("Width Error: " + e.getMessage());
        }
        try {
            setHeight(height);
        } catch (IllegalArgumentException e) {
            errors.add("Height Error: " + e.getMessage());
        }
        if (!errors.isEmpty()) {
            throw new IllegalArgumentException(String.join("\n", errors));
        }
    }
    public Rectangle() {
        this.width = 0;
        this.height = 0;
    }

    public double getWidth() {
        return width;
    }
    public double getHeight() {
        return height;
    }
    public void setWidth(double width) {
        if (width < 0) {
            throw new IllegalArgumentException("Width cannot be negative.");
        }
        this.width = width;
    }
    public void setHeight(double height) {
        if (height < 0) {
            throw new IllegalArgumentException("Height cannot be negative.");
        }
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        while (true) {
            System.out.print("Enter width (or 'x' to exit): ");
            String widthInput = scanner.nextLine();
            if (widthInput.equalsIgnoreCase("X")) {
                System.out.println("Exiting program.");
                break;
            }
            System.out.print("Enter height (or 'x' to exit): ");
            String heightInput = scanner.nextLine();
            if (heightInput.equalsIgnoreCase("X")) {
                System.out.println("Exiting program.");
                break;
            }

            double width = 0;
            double height = 0;
            try {
                width = Double.parseDouble(widthInput);
                height = Double.parseDouble(heightInput);
            } catch (NumberFormatException e) {
                System.out.println("Error: Width and Height must be valid numbers.\nPlease try again.\n");
                continue;
            }

            try {
                Rectangle rectangle = new Rectangle(width, height);
                System.out.printf("Rectangle created with Width: %.2f, Height: %.2f, Area: %.2f%n",
                        rectangle.getWidth(), rectangle.getHeight(), rectangle.getArea());
                break;
            } catch (IllegalArgumentException e) {
                String errorString = e.getMessage();
                String[] errorArray = errorString.split("\n");
                System.out.println("Errors:");
                for (String error : errorArray) {
                    System.out.println("- " + error);
                }
                System.out.println("Please try again.\n");
                continue;
            }
        }
        scanner.close();
    }
}
