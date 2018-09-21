package Volume_I.Chapter5;

/**
 * Created by Star Yang on 2017/1/14.
 */
public class C_Enumeration {
    public static void main(String[] args){
        Size s = Enum.valueOf(Size.class , "SMALL");
        System.out.println(s);
        Size[] sizes = Size.values();
        for(Size size : sizes){
            System.out.println(size + "\t" + size.ordinal());
        }

        Style style = Enum.valueOf(Style.class,"WINTER");
        System.out.println("\n"+style+"\t"+style.getAbbreviation());
    }
}

enum Size{
    SMALL,MEDIUM,LARGE,EXTRA_LARGE
}

enum Style{
    SPRING("S"),SUMMER("M"),AUTUMN("A"),WINTER("W");

    private String abbreviation;
    private Style(String abbreviation){
        this.abbreviation = abbreviation;
    }
    public String getAbbreviation(){
        return this.abbreviation;
    }
}
