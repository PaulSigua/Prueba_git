
package controllers;

import java.util.ArrayList;

/**
 *
 * @author mateo
 */
public class Sentences {
    private String sentence;

    public Sentences() {
        this.sentence = "";
    }
    
    public ArrayList returnSentence(){
        ArrayList<String> list = new ArrayList<>();
        String s1 = "CREATE TABLE (?)";
        String s2 = "INSERT INTO (?) VALUES (?,?,?,?)";
        String s3 = "DROP TABLE (?)";
        String s4 = "SELECT * FROM (?)";
        String s5 = "SELECT (?) FROM (?) ORDER BY (?)";
        String s6 = "ALTER TABLE (?) MODIFY (?) (NOT NULL) (NULL)";
        String s7 = "UPDATE (?) SET (?) WHERE (?)";
        String s8 = "DELETE FROM (?) WHERE (?)";
        
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);
        list.add(s6);
        list.add(s7);
        list.add(s8);
        
        for(int i = 0; i < list.size();i++){
            System.out.println((i+1) + ". " + list.get(i));
        }
        
        System.out.println("");
        
        return list;
    }
    
}
