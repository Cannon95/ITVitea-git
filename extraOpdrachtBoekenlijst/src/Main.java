import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Main {

    List<GeleendBoek> zelfGeleend = List.of(new GeleendBoek("Learn C the Hard Way", "Daphne", LocalDate.of(2022, Calendar.JULY, 22 )));
    List<GeleendBoek> uitgeleend = List.of(new GeleendBoek("Code Complete 2", "", LocalDate.of(2022,Calendar.JULY,7)),
            new GeleendBoek("The Pragmatic Programmer","Julia", LocalDate.of(2022, Calendar.AUGUST, 5)),
            new GeleendBoek("Learning Java","Flip", LocalDate.of(2022, Calendar.AUGUST, 1)),
            new GeleendBoek("The C# Player's Guide","Marco", LocalDate.of(2022, Calendar.JULY, 12)),
            new GeleendBoek("C++ How to Program (Deitel & Deitel)", "Janice" , LocalDate.of(2022, Calendar.JULY, 31))
    );
    List<String> voorraad = List.of("Domain Driven Design", "The Psychology of Computer Programming", "Facts and Fallacies of Software Engineering", "Writing Maintainable Software", "The Inmates are Running the Asylum", "Patterns of Enterprise Application Architecture (Fowler)", "Refactoring");

//    B.new GeleendBoek("The Pragmatic Programmer","Julia", LocalDate.of(2022, Calendar.AUGUST, 5)),
//    C.new GeleendBoek("Learning Java","Flip" - 2022/08/01 LocalDate.of(2022, Calendar.AUGUST, 1)),
//    D.new GeleendBoek("The C# Player's Guide" - "Marco" - 2022/07/12 LocalDate.of(2022, Calendar.JULY, 12)),
//    E.new GeleendBoek("C++ How to Program (Deitel & Deitel)" - "Janice" - 2022/07/31 LocalDate.of(2022, Calendar.JULY, 31))




    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<String> list = new ArrayList<>();


    }





}
record GeleendBoek(String boek, String lener, LocalDate datum){}

