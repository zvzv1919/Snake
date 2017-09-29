
public class ErrorHandler {
    public ErrorHandler(Error error){
        switch (error){
            case NULL_HEAD:{
                System.out.println("Head passed to Map() or when used in Snake class is null.");
                break;
            }
            case NULL_MAP:{
                System.out.println("The map to be print is null.");
                break;
            }
            case NULL_MAP2:{
                System.out.println("The map of Snake is null.");
                break;
            }
        }
    }
}
