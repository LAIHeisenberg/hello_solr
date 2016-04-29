package pojo;

import org.apache.solr.client.solrj.beans.Field;

import java.util.ArrayList;

/**
 * Created by Heisenberg on 4/29/16.
 */
public class Item {

    @Field
    ArrayList<String> id;
    @Field
    ArrayList<String> cat;
    @Field
    ArrayList<Double> price;

    public Item() {
    }

    public ArrayList<String> getId() {
        return id;
    }

    public void setId(ArrayList<String> id) {
        this.id = id;
    }

    public ArrayList<String> getCat() {
        return cat;
    }

    public void setCat(ArrayList<String> cat) {
        this.cat = cat;
    }

    public ArrayList<Double> getPrice() {
        return price;
    }

    public void setPrice(ArrayList<Double> price) {
        this.price = price;
    }
}
