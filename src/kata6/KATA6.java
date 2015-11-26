package kata6;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


public class KATA6 {

    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException, SQLException{
        ArrayList<Person> mailArray=MailListReader.read("/home/joaquin/NetBeansProjects/KATA6/DATA/emails.txt");
        ArrayList<Person1> personList = PersonLoader.read();
        HistogramBuilder<Person> builder=new HistogramBuilder<>(mailArray);
        HistogramBuilder<Person1> personBuilder=new HistogramBuilder<>(personList);
        
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
        
        
        Histogram<String> domains1 = personBuilder.build(new Attribute<Person1, String>() {
            
            @Override
            public String get(Person1 item) {
                return item.getMail().split("@")[1];
            }
        });
        
        Histogram<Float> pesos = personBuilder.build(new Attribute<Person1, Float>() {
            @Override
            public Float get(Person1 item) {
                return item.getPeso();
            }
        });
        
        
        Histogram<String> genero = personBuilder.build(new Attribute<Person1, String>() {
            
            @Override
            public String get(Person1 item) {
                return item.getGenero();
            }
        });
        new HistogramDisplay(domains, "Dominios").execute();
        new HistogramDisplay(letters, "Caracter").execute();
        new HistogramDisplay(domains1, "Dominios").execute();
        new HistogramDisplay(pesos, "Peso").execute();
        new HistogramDisplay(genero, "Genero").execute();
    }


}
