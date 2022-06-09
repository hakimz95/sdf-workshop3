package vttp2022.day3.workshop;

import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class Cart {
    private List<String> contents = new LinkedList<>();
    private String username;

    public Cart(String name) {
        this.username = name;
    }

    public String getUsername() {
        return username;
    }

    public void add(String item) {
        for(String inCart: contents) 
            if(inCart.equals(item)) 
                return;
        contents.add(item);
    }

    public String delete(int index) {
        if( index < contents.size()) 
            return contents.remove(index);
        return "nothing";
        
    }

    public void load(InputStream is) throws IOException {
        InputStreamReader isr = new InputStreamReader(is); //raw file reading
        BufferedReader br = new BufferedReader(isr); //actual content reading | line by line reading
        String item; //to assign the content to a string
        while((item = br.readLine()) != null)  //when it reach null, it is end of file(eof)
            contents.add(item);
        br.close(); //claim resources back 
        isr.close(); //first in last out
    }

    public void save(OutputStream os) throws IOException {
        OutputStreamWriter ows = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(ows);
        for (String item: contents) //for every loop, save the contents
            bw.write(item + "\n");

            ows.flush();
            bw.flush();
            bw.close();
            ows.close(); 
            //no need first in last out as the data has been flushed
    }

    public List<String> getContents() {
        return contents;
    }
}
