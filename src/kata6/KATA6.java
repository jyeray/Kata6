package kata6;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


public class KATA6 {

    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException, SQLException{
//        ArrayList<String> mailArray=MailListReaderDB.read();
        ArrayList<Person> mailArray=MailListReader.read("/home/joaquin/NetBeansProjects/KATA6/DATA/emails.txt");
        
        HistogramBuilder<Person> builder=new HistogramBuilder<>(mailArray);
        
        Histogram<String> domains = builder.build(new Attribute<Person, String>() {
            @Override
            public String get(Person item) {
                return item.getMail().split("@")[1];
            }
        });
        
        Histogram<Character> letters = builder.build(new Attribute<Person, Character>() {
            @Override
            public Character get(Person item) {
                return item.getMail().charAt(0);
            }
        });
        
        new HistogramDisplay(domains, "Dominios").execute();
        new HistogramDisplay(letters, "Caracter").execute();

        
        
    }


}
